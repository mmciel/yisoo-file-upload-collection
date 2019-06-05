package cn.mmciel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.realm.UserDatabaseRealm;

import cn.mmciel.bean.UserData;
import cn.mmciel.dao.impl.UserDataImpl;
import cn.mmciel.utils.ReadExcelFile;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("login");
		
		String username = request.getParameter("yusername");
		String password = request.getParameter("ypassword");
		UserData userdata = new UserData();
		userdata.setUsername(username);
		userdata.setPassword(password);
		System.out.println(username);
		System.out.println(password);
		UserDataImpl UDtemp = new UserDataImpl();
		Boolean result = UDtemp.getFind(userdata);
		
		if(result) {
            HttpSession session = request.getSession();
            session.setAttribute("userid", UDtemp.getUserId(userdata));
            session.setAttribute("username", username);
            System.out.println("login start");
			response.sendRedirect("main.jsp");
		}else {
			//System.out.println("login end");
			response.sendRedirect("index.jsp");
		}
	}

}
