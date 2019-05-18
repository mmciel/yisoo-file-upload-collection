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
import cn.mmciel.bean.ProjectShareData;
import cn.mmciel.dao.impl.GroupNameDataDaoImpl;
import cn.mmciel.dao.impl.ProjectDataDaoImpl;
import cn.mmciel.dao.impl.ProjectShareDataDaoImpl;
import cn.mmciel.utils.StringUtils;
import cn.mmciel.utils.TimeStringUtils;


@WebServlet("/AddPorjectServlet")
public class AddPorjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ProjectData pdata = new ProjectData();
		String GroupName = request.getParameter("groupname");
		String Projectname = request.getParameter("projectName");
		String datePicker = request.getParameter("datePicker");
		String projectPs = request.getParameter("projectPs");
		String UserId = request.getParameter("userid");
		pdata.setProjectps(projectPs);
		pdata.setProjectname(Projectname);
		this.solveTimeData(pdata, datePicker);
		pdata.setUserid(UserId);


		if(GroupName != null) {
			pdata.setIsgroup(1);
			pdata.setGroup(GroupName);
			pdata.setFnend("-");
			pdata.setFnhead("-");
			pdata.setFnmid("-");
		}else {
			pdata.setIsgroup(0);
			pdata.setGroup("");
			
		}

		pdata.setFilepath(pdata.getGroup());
		String groupName = new GroupNameDataDaoImpl().getGroupNameDataByGroupKey(pdata.getGroup());
		
		pdata.setGroupname(groupName);
		//System.out.println(fileTemp);
		//response.getWriter().write("123");
		//传入状态
		pdata.setStatus("未发布");
		//System.out.println(pdata.toString());
		
		ProjectDataDaoImpl PDDI = new ProjectDataDaoImpl();
		PDDI.setProjectData(pdata);
		System.out.println(pdata.toString());
		//response.getWriter().print(pdata.toString());
		
		//写入数据到projectsharedata
		ProjectShareData PSData = new ProjectShareData();
		//获取projectdata自动生成的projectid
		
		PSData.setProjectId(PDDI.getProjectId(pdata.getUserid(),pdata.getProjectname()));
		
		//System.out.println("id = "+PSData.getProjectId());
		PSData.setProjectKey(StringUtils.getMD5(PSData.getProjectId()));
		ProjectShareDataDaoImpl PSDDI = new ProjectShareDataDaoImpl();
		PSDDI.setProjectShareData(PSData);
		
		response.getWriter().write("{\"status\":\"" + "1" + "\"}");
	}
	private void solveTimeData(ProjectData pdata, String s) {
		String startTime = s.substring(0,s.length()/2).trim();
		String endTime = s.substring(s.length()/2+1, s.length()).trim();
		//传入开始时间与截止时间
		pdata.setStarttime(TimeStringUtils.StringToTimestamp(startTime));
		pdata.setEndtime(TimeStringUtils.StringToTimestamp(endTime));
	}

}
