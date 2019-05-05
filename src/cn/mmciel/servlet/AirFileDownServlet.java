package cn.mmciel.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mmciel.bean.AirFileData;
import cn.mmciel.dao.impl.AirFileDataDaoImpl;


/**
 * Servlet implementation class AirFileDownServlet
 */
@WebServlet("/AirFileDownServlet")
public class AirFileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Set-Cookie", "fileDownload=true; path=/");
		
		String ShareCode = request.getParameter("sharecode");
		System.out.println(ShareCode);
		//通过分享码获取air文件对象
		AirFileDataDaoImpl AFDDI = new AirFileDataDaoImpl();
		AirFileData data = AFDDI.getAirFileData(ShareCode);
		String folder = request.getSession().getServletContext().getRealPath("airfiles")+"\\";

        String fileName = data.getFilePath();
        String path = folder +fileName;
        System.out.println(path);
        //得到要下载的文件

        FileInputStream fis = new FileInputStream(path);
        
        String userAgent = request.getHeader("User-Agent");  
        byte[] bytes = userAgent.contains("MSIE") ? fileName.getBytes() : fileName.getBytes("UTF-8"); // name.getBytes("UTF-8")处理safari的乱码问题  
        String name = new String(bytes, "ISO-8859-1"); 
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", name));
        ServletOutputStream out = response.getOutputStream();
        byte[] bt = new byte[1024];
        int length = 0;
        while((length=fis.read(bt))!=-1){
            out.write(bt,0,length);
        }
        out.close();

	}

}
