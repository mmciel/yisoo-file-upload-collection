package cn.mmciel.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.mmciel.bean.GroupData;
import cn.mmciel.bean.ProjectData;
import cn.mmciel.dao.impl.GroupDataDaoImpl;
import cn.mmciel.dao.impl.ProjectDataDaoImpl;

/**
 * Servlet implementation class PersonDataTableInterface
 */
@WebServlet("/PersonDataTableInterface")
public class PersonDataTableInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String GroupKey = request.getParameter("groupkey");
		//System.out.println(GroupKey);
		GroupDataDaoImpl GDDI = new GroupDataDaoImpl();
		List<GroupData> data = GDDI.getGroupData(GroupKey);
		JSONObject obj = new JSONObject();
		int len = 1000;
		obj.put( "code", 0);
		obj.put( "msg", "");
		obj.put("data", data);
		len = JSON.toJSONString(data).length();
		obj.put( "count", len);
		//System.out.println(obj);
		//System.out.println(obj);
		response.getWriter().print(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
