package cn.mmciel.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSONObject;

import cn.mmciel.bean.GroupData;
import cn.mmciel.bean.ProjectData;
import cn.mmciel.bean.UploadRecord;
import cn.mmciel.dao.impl.GroupDataDaoImpl;
import cn.mmciel.dao.impl.ProjectDataDaoImpl;
import cn.mmciel.dao.impl.UploadRecordDaoImpl;
import cn.mmciel.utils.StringUtils;


@WebServlet("/UploadFileServlet")
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		String ParentPath = null;//文件夹路径
		String FileName = null; //文件名
		String FileSuffix = null;//原始文件后缀
		String FilePath = null;//文件保存路径
		String ProjectId = null;//项目id
		String GroupKey = null;//项目组key
		String Number = null;//名单编号
		String tempPath = null;//临时文件地址
		String tempParent = request.getSession().getServletContext().getRealPath("uploadfiles")+"\\";

		boolean isMu = ServletFileUpload.isMultipartContent(request);
		if (isMu) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

				
			List<FileItem> items;
			try {
				items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();

				while (iter.hasNext()) {
                    FileItem item = iter.next();
					String itemName = item.getFieldName();
					if(item.isFormField()) {
						if(itemName.equals("projectid")) {
							ProjectId = item.getString("UTF-8");
							//System.out.println(ProjectId);
						}else if(itemName.equals("groupkey")) {
							GroupKey = item.getString("UTF-8");
						}else if(itemName.equals("number")) {
							Number = item.getString("UTF-8");
						}
					}else {
                		File targetFile = new File(tempParent+"uploadTemp");
                		if (!targetFile.exists()) {
                			targetFile.mkdirs();
                		}
						//记录文件后缀
						FileSuffix = item.getName().substring(item.getName().lastIndexOf("."));
						//获取文件临时存储位置
						tempPath = tempParent + "uploadTemp\\"+item.getName();
//						System.out.println(tempPath);
	                    File file=new File(tempPath);
	                    if(!file.exists()){
	                        try {   
	                            file.createNewFile();   
	                        } catch (IOException e) {   
	                            e.printStackTrace();   
	                        }   
	                    }
	                    FileOutputStream fos=new FileOutputStream(file);                 
	                    InputStream fis=(InputStream) item.getInputStream();
	                    byte b[]=new byte[1];
	                    int read=fis.read(b);
	                    while(read!=-1){ 
	                        fos.write(b,0,1); 
	                        read=fis.read(b); 
	                    } 
	                    fis.close();
	                    fos.flush();
	                    fos.close();

					}
                }
			} catch (FileUploadException e1) {
				e1.printStackTrace();
			}

			//System.out.println(FilePath);
			//new File(tempPath).delete();
			//
			Timestamp nowTime = new Timestamp(System.currentTimeMillis());
            UploadRecord udata = new UploadRecord(ProjectId, nowTime, FileName+FileSuffix, GroupKey, Number);
            new UploadRecordDaoImpl().setUploadRecord(udata);
			JSONObject obj = new JSONObject();
			obj.put( "status", "1");
			response.getWriter().print(obj);
			
			//把文件存到应该存的地方
            //文件存储成功后，相关信息写入到数据库
			//System.out.println("@"+Number);
			ParentPath = this.getParentPath(tempParent,ProjectId);
			FileName = this.getFileName(ProjectId,GroupKey,Number);
			FilePath = ParentPath+"/"+FileName+FileSuffix;

    		File targetFile = new File(ParentPath);
    		if (!targetFile.exists()) {
    			targetFile.mkdirs();
    		}
			FileUtils.copyFile(new File(tempPath), new File(FilePath));
		} 
	}

	private String getFileName(String projectId, String groupKey, String number) {
		ProjectData pdata = new ProjectDataDaoImpl().getProjectDataByProjectId(projectId);
		GroupData gdata = new GroupDataDaoImpl().getGroupDataByNumber(groupKey, number);
		return pdata.getFnhead()+gdata.getGrade()+
				pdata.getFnmid()+gdata.getNumber()+
				pdata.getFnmid()+gdata.getName()+
				pdata.getFnend();
	}

	private String getParentPath(String  Parent,String projectId) {
		ProjectData temp = new ProjectDataDaoImpl().getProjectDataByProjectId(projectId);
		return Parent+temp.getFilepath();

	}

}
