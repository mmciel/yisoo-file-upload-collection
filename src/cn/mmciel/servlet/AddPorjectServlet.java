package cn.mmciel.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.mmciel.bean.ProjectData;
import cn.mmciel.dao.impl.ProjectDataDaoImpl;
import cn.mmciel.utils.StringUtils;
import cn.mmciel.utils.TimeStringUtils;


@WebServlet("/AddPorjectServlet")
public class AddPorjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ProjectData pdata = new ProjectData();
		String GroupName = null;
		String zhui = null;//文件后缀名
		
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
                FileItem item = iter.next();
				String itemName = item.getFieldName();
				if(item.isFormField()) {
					if(itemName.equals("projectName")) {
						pdata.setProjectname(item.getString("UTF-8"));
						//String GroupName = item.getString("UTF-8");
						//System.out.println(GroupName);
					}else if(itemName.equals("projectPs")) {
						pdata.setProjectps(item.getString("UTF-8"));
						//String UserId = item.getString("UTF-8");
						//System.out.println(UserId);
					}else if(itemName.equals("datePicker")) {
						String datePicker = item.getString("UTF-8");
						System.out.println(datePicker);
						this.solveTimeData(pdata, datePicker);
					}else if(itemName.equals("userid")){
						pdata.setUserid(item.getString("UTF-8"));
					}else if(itemName.equals("groupfilename")) {
						GroupName = item.getString("UTF-8");
					}else if(itemName.equals("zhui")) {
						zhui = "." + item.getString("UTF-8");
					}
				}
            }
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(GroupName != null) {
			//说明使用了名单
			
			pdata.setIsgroup(1);
			String FileName = StringUtils.getZNstringMD5(pdata.getUserid()+GroupName);
			pdata.setGroup(FileName+zhui);
			pdata.setFnend("-");
			pdata.setFnhead("-");
			pdata.setFnmid("-");
		}else {
			pdata.setIsgroup(0);
			pdata.setGroup("");
			
		}

		
		String UploadPath = request.getSession().getServletContext().getRealPath("")+"upload/";
		String SaveFilePath = pdata.getUserid()+"+"+pdata.getProjectname();
		pdata.setFilepath(SaveFilePath);
		File fileTemp = new File(UploadPath+SaveFilePath);
		if(!fileTemp.exists()) {
			fileTemp.mkdir();
		}
		//System.out.println(fileTemp);
		//response.getWriter().write("123");
		pdata.setStatus("1");
		//System.out.println(pdata.toString());
		
		ProjectDataDaoImpl PDDI = new ProjectDataDaoImpl();
		PDDI.setProjectData(pdata);
	}
	private void solveTimeData(ProjectData pdata, String s) {
		String startTime = s.substring(0,s.length()/2).trim();
		String endTime = s.substring(s.length()/2+1, s.length()).trim();
		//System.out.println(startTime);
		//System.out.println(endTime);
		pdata.setStarttime(TimeStringUtils.StringToTimestamp(startTime));
		pdata.setEndtime(TimeStringUtils.StringToTimestamp(endTime));
	}

}
