package cn.mmciel.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import cn.mmciel.bean.GroupData;
import cn.mmciel.dao.impl.GroupDataDaoImpl;
import cn.mmciel.utils.ReadExcelFile;
import cn.mmciel.utils.StringUtils;

/**
 * Servlet implementation class UploadGroupDataExcelFileServlet
 */
@WebServlet("/UploadGroupDataExcelFileServlet")
public class UploadGroupDataExcelFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadGroupDataExcelFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		//String WebProjectPath = this.getClass().getResource("/").getPath().replaceFirst("/", "").replaceAll("WEB-INF/classes/", ""); 
		//String ExcelFileFloder = WebProjectPath+"/group-data-excel-file";
		String ExcelFileFloder = request.getSession().getServletContext().getRealPath("group-data-excel-file");
		boolean isMu = ServletFileUpload.isMultipartContent(request);
		if (isMu) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			String zhui;
			String FileName;
			String FilePath = null;
			String GroupName=null;
			String UserId = null;
			try {
				
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				//System.out.println(items.size());
//				String userid = 
//				String projectid = 

				while (iter.hasNext()) {
                    FileItem item = iter.next();
					String itemName = item.getFieldName();
					if(item.isFormField()) {
						if(itemName.equals("GroupFileName")) {
							GroupName = item.getString("UTF-8");//��ȡ���ļ�һ�����������
							//System.out.println(GroupName);
						}else if(itemName.equals("userid")) {
							UserId = item.getString("UTF-8");
							//System.out.println(UserId);
						}
						//System.out.println(itemName);
					}else {
	                    //�����ļ������
						zhui = item.getName().substring(item.getName().lastIndexOf("."));
						FileName = StringUtils.getZNstringMD5(UserId+GroupName);
						FilePath = ExcelFileFloder+"/"+FileName+zhui;
	                    File file=new File(FilePath);
	                    if(!file.exists()){
	                        try {   
	                            file.createNewFile();   
	                        } catch (IOException e) {   
	                            e.printStackTrace();   
	                        }   
	                    }
	                    FileOutputStream fos=new FileOutputStream(file);                 
	                    //����������
	                    InputStream fis=(InputStream) item.getInputStream();
	                    //����������ȡ�ֽ�����
	                    byte b[]=new byte[1];
	                    //��ȡһ�����������ֽڵ�b[0]��
	                    int read=fis.read(b);
	                    while(read!=-1) 
	                    { 
	                        fos.write(b,0,1); 
	                        read=fis.read(b); 
	                    } 
	                    fis.close();
	                    fos.flush();
	                    fos.close();
	                    //��ӡList�е����ݣ�ÿһ��FileItem��ʵ������һ���ļ���ִ�����д�����ӡ���ļ���һЩ�������ԣ��ļ�������С�ȣ�
	                    //System.out.println(FilePath); 
					}
                    
                    
 
                }
//				while(iter.hasNext()) {
//					FileItem item = iter.next();
//					String itemName = item.getFieldName();
//					if(item.isFormField()) {
//						if(itemName.equals("name")) {
//							System.out.println("name");
//						}else{
//							
//						}
//					}else {
//						fileItem = item;
//						String filename = item.getName();
//						System.out.println(filename);
//						fileItem.write(new File("D://text.txt"));
//					}
//				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write("ok");
			this.setDBfromExcel(FilePath,GroupName,UserId);
		} else {
			response.getWriter().write("no");
		}
		
		//����ط����ļ��е������������ݿ�
		
	}

	private void setDBfromExcel(String filePath, String groupName, String userId) {
		String dataKey = StringUtils.getZNstringMD5(userId+groupName);
		
		ReadExcelFile efile = new ReadExcelFile();
		if(efile.OpenExcel(filePath)) {
			ArrayList<ArrayList<String>> datalist = efile.getListData();
			//efile.PrintList(datalist);
			ArrayList<GroupData> data = new ArrayList<GroupData>();
			
	        for (ArrayList<String> list: datalist) {
	        	//System.out.println(list.get(2));
	        	GroupData tempdata = new GroupData();
	        	tempdata.setKey(dataKey);
	        	tempdata.setGrade(list.get(0));
	        	tempdata.setNumber(list.get(1));
	        	tempdata.setName(list.get(2));
	        	data.add(tempdata);
	        }
        	//System.out.println(data.size());

			GroupDataDaoImpl GDDI = new GroupDataDaoImpl();
			if(GDDI.setGroupListData(data)) {
				System.out.println("set list data ok");
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
