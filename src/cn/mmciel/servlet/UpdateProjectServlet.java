package cn.mmciel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.mmciel.dao.impl.ProjectDataDaoImpl;
import cn.mmciel.dao.impl.ProjectShareDataDaoImpl;

/**
 * Servlet implementation class UpdateProjectServlet
 */
@WebServlet("/UpdateProjectServlet")
public class UpdateProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String order = request.getParameter("order");
		//System.out.println(order);
		//发布与停止命令
		if(order.equals("share")) {
			String status = request.getParameter("status");
			String ProjectID = request.getParameter("projectid");
			if(status.equals("0")) {//关闭项目
				status = "未发布";
				//更新数据库
				new ProjectDataDaoImpl().UpdateProjectStatus(ProjectID, status);

				JSONObject obj = new JSONObject();
				obj.put( "url", "null");
				response.getWriter().print(obj);
			}else {//启动项目
				status = "已发布";
				//更新数据库
				new ProjectDataDaoImpl().UpdateProjectStatus(ProjectID, status);
				ProjectShareDataDaoImpl PSDDI = new ProjectShareDataDaoImpl();
				String Key = PSDDI.getProjectKeyById(ProjectID);//MD5字符串
				String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
				String UrlParam = basePath + "UploadServer?" + "url=" + Key;
				JSONObject obj = new JSONObject();
				obj.put( "url", UrlParam);
				response.getWriter().print(obj);		
			}

		}
	}

}
