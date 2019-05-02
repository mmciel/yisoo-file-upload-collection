package cn.mmciel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.mmciel.bean.UserData;
import cn.mmciel.dao.impl.UserDataImpl;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usermail = request.getParameter("email");
		int perm = Integer.parseInt(request.getParameter("yperm"));
		UserData userdata = new UserData(username, usermail, password, perm);
		
		UserDataImpl udImpl = new UserDataImpl();
		if(udImpl.setUserData(userdata)) {
			UserDataImpl UDtemp = new UserDataImpl();
			Boolean result = UDtemp.getFind(userdata);
            HttpSession session = request.getSession();
            // �������session userid username
            session.setAttribute("userid", UDtemp.getUserId(userdata));
            session.setAttribute("username", username);
			response.sendRedirect("mian.jsp");
		}else {
			response.sendRedirect("index.jsp");
		}
		
		
	}

}
