package cn.mmciel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mmciel.bean.GroupData;
import cn.mmciel.bean.GroupNameData;
import cn.mmciel.dao.impl.GroupDataDaoImpl;
import cn.mmciel.dao.impl.GroupNameDataDaoImpl;
import cn.mmciel.utils.StringUtils;

/**
 * Servlet implementation class DelGroupDataServlet
 */
@WebServlet("/DelGroupDataServlet")
public class DelGroupDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String userid = request.getParameter("userid");
		String groupName = request.getParameter("groupName");
		GroupData gdata = new GroupData();
		GroupNameData gndata = new GroupNameData();
		String key = StringUtils.getZNstringMD5(userid+groupName);
		gdata.setGroupkey(key);
		gndata.setGroupName(groupName);
		gndata.setUserid(userid);
		GroupDataDaoImpl GDDI = new GroupDataDaoImpl();
		GroupNameDataDaoImpl GNDDI = new GroupNameDataDaoImpl();
		if(GNDDI.DeleteGroupNameData(gndata) && GDDI.DeleteGroupData(gdata)) {
			response.getWriter().write("{\"status\":\"" + "1" + "\"}");
		}else {
			response.getWriter().write("{\"status\":\"" + "0" + "\"}");
		}
		
		
		
		
	}

}
