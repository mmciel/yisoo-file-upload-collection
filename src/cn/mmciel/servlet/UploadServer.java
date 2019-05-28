package cn.mmciel.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import cn.mmciel.bean.ProjectData;
import cn.mmciel.bean.ProjectShareData;
import cn.mmciel.dao.impl.ProjectDataDaoImpl;
import cn.mmciel.dao.impl.ProjectShareDataDaoImpl;
import sun.rmi.runtime.NewThreadAction;

@WebServlet("/UploadServer")
public class UploadServer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String url = request.getParameter("url");
		System.out.println(url);
		
		if(url != null) {
			//获取项目
			ProjectShareData tempShareData = new ProjectShareDataDaoImpl().getProjectShareDataByKey(url);
			String projectId = tempShareData.getProjectId();

			ProjectData projectData = new ProjectDataDaoImpl().getProjectDataByProjectId(projectId);
			System.out.println(projectData);
			//生成json
			JSONObject obj = new JSONObject();
			if(projectData.getStatus().equals("未发布")) {
				obj.put( "status", "0");
				response.getWriter().print(obj);
			}else {
				Timestamp startTime = projectData.getStarttime();
				Timestamp endTime = projectData.getEndtime();
				Timestamp nowTime = new Timestamp(System.currentTimeMillis());
				
				if(nowTime.before(startTime)) {
//					项目未开始
					obj.put( "status", "-1");
					response.getWriter().print(obj);
					return;
				}
				if(endTime.before(nowTime)) {
//					项目过期

					obj.put( "status", "1");
					response.getWriter().print(obj);
					return;
				}
				System.out.println(endTime);
				System.out.println(nowTime);
				obj.put( "status", "2");//项目正常
				String startTimeString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(projectData.getStarttime());
				obj.put( "starttime", startTimeString);
				String endTimeString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(projectData.getEndtime());

				obj.put( "endtime", endTimeString);
				
				obj.put( "projectname", projectData.getProjectname());
				
				obj.put( "projectps", projectData.getProjectps());
				
				obj.put( "projectid", projectData.getProjectid());
				
				obj.put( "groupkey", projectData.getGroupkey());//传入名单关键字
				response.getWriter().print(obj);
			}


				
			
		}
	}
	@Test
	public void test() {

	}
}
