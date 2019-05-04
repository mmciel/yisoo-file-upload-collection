package cn.mmciel.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.mmciel.bean.AirFileData;
import cn.mmciel.dao.impl.AirFileDataDaoImpl;
import cn.mmciel.utils.FileTools;
import cn.mmciel.utils.StringUtils;

/**
 * Servlet implementation class AirFileUploadServlet
 */
@WebServlet("/AirFileUploadServlet")
public class AirFileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
//		文件保存地址
		String AirFileFloder = request.getSession().getServletContext().getRealPath("airfiles");
//		文件字段
		boolean isMu = ServletFileUpload.isMultipartContent(request);
		boolean result = false;
		if (isMu) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			String FileSuffix = null;
			String FileName =null;
			String FilePath = null;
			String FileCode = null;
			int MaxCount = 0;
			try {
				
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();

				while (iter.hasNext()) {
                    FileItem item = iter.next();
					String itemName = item.getFieldName();
//					非文件字
					if(item.isFormField()) {
						if(itemName.equals("maxcount")) {
							MaxCount = Integer.valueOf(item.getString("UTF-8"));
						}
					}else {//文件字段
//						文件后缀
						FileSuffix = item.getName().substring(item.getName().lastIndexOf("."));
						FileName = item.getName();
						//可能包含路径的情况
						int index=FileName.lastIndexOf("\\");
						if(index!=-1) {
							FileName = FileName.substring(index+1);
						}

						FilePath = AirFileFloder+"/"+FileName;
						System.out.println(FilePath);
	                    
						File file=new File(FilePath);
						
	                    if(!file.exists()){
	                        try {   
	                            file.createNewFile();   
	                        } catch (IOException e) {   
	                            e.printStackTrace();   
	                        }   
	                    }
	                    FileOutputStream fos=new FileOutputStream(file);                 
	                    InputStream fis=(InputStream) item.getInputStream();
	                    byte b[]=new byte[1];
	                    int read=fis.read(b);
	                    while(read!=-1) 
	                    { 
	                        fos.write(b,0,1); 
	                        read=fis.read(b); 
	                    } 
	                    fis.close();
	                    fos.flush();
	                    fos.close();
	                    FileCode = FileTools.getMD5(FilePath);
	                   
					}
                }
				//这里传入的不是文件地址 而是文件名称
				 result = this.setData(FileName, MaxCount, FileCode);
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//文件已经存到磁盘上了，开始信息存入数据库

			//response.getWriter().write("{\"status\":\"" + "1" + "\"}");
		}
		if(result) {
			response.getWriter().write("{\"status\":\"" + "1" + "\"}");
		}else {
			response.getWriter().write("{\"status\":\"" + "0" + "\"}");
		}
		
	}
	private boolean setData(String filePath,int maxCount,String fileCode) {
		
		String ShareCode=getShareCode();
		AirFileData data = new AirFileData();
		AirFileDataDaoImpl AFDDI = new AirFileDataDaoImpl();
		while(AFDDI.getAirFileData(ShareCode)!=null) {
			ShareCode = getShareCode();
		}
		data.setDownCount(0);
		data.setFileCode(fileCode);
		data.setMaxCount(maxCount);
		data.setFilePath(filePath);
		data.setShareCode(ShareCode);
		if(AFDDI.setAirFileData(data)) {
			return true;
		}
		return false;
	}
	private String getShareCode() {
		Random random = new Random();
		String ShareCode="";
		for (int i=0;i<5;i++){
			ShareCode+=random.nextInt(10);
		}
		return ShareCode;
	}

}
