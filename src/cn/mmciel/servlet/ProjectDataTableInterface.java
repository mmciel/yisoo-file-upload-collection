package cn.mmciel.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.xmlbeans.impl.xb.xmlconfig.impl.UsertypeconfigImpl;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.mmciel.bean.ProjectData;
import cn.mmciel.dao.ProjectDataDao;
import cn.mmciel.dao.impl.ProjectDataDaoImpl;



@WebServlet("/ProjectDataTableInterface")
public class ProjectDataTableInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

		String UserID = (String) session.getAttribute("userid");
		//System.out.println(UserID);
		if(UserID == null) {
			//response.getWriter().print("{\"msg\":\"��¼\",\"code\":1");
			return ;
		}
		ProjectDataDaoImpl PDDI = new ProjectDataDaoImpl();
		List<ProjectData> data = PDDI.getProjectDataByUser(UserID);
		JSONObject obj = new JSONObject();
		int len = 1000;
		obj.put( "code", 0);
		obj.put( "msg", "");
		obj.put("data", data);
		len = JSON.toJSONString(data).length();
		obj.put( "count", len);
		//System.out.println(obj);
		//System.out.println(obj);
		//System.out.println("interface:"+obj);
		response.getWriter().print(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}

}
