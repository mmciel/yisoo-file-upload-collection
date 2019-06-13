package cn.mmciel.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.mmciel.dao.impl.ProjectDataDaoImpl;
import cn.mmciel.utils.FileTools;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String downKey = request.getParameter("downkey");
		System.out.println(downKey);
		
		//获取需要打包文件的目录
		String projectPath = new ProjectDataDaoImpl().getProjectDataByProjectId(downKey).getFilepath();
		
		String path = request.getSession().getServletContext().getRealPath("uploadfiles/");
		
		String downPath = path+projectPath;
		String ZipSavePath = path+"uploadTemp\\";
		String ZipFileName = projectPath;
		
		String finalPath =  FileTools.fileToZip(downPath, ZipSavePath, ZipFileName);
		System.out.println(finalPath);
		

        FileInputStream fis = new FileInputStream(ZipSavePath+finalPath);
        response.setCharacterEncoding("utf-8");
        String userAgent = request.getHeader("User-Agent");  
        byte[] bytes = userAgent.contains("MSIE") ? finalPath.getBytes() : finalPath.getBytes("UTF-8"); // name.getBytes("UTF-8")处理safari的乱码问题  

        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", new String(bytes, "ISO-8859-1")));
        ServletOutputStream out = response.getOutputStream();
        byte[] bt = new byte[1024];
        int length = 0;
        while((length=fis.read(bt))!=-1){
            out.write(bt,0,length);
        }
        out.close();
		
		
		JSONObject obj = new JSONObject();
		obj.put( "status", 0);
		response.getWriter().print(obj);
		
	}

}
