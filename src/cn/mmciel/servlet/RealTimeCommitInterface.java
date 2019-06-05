package cn.mmciel.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.mmciel.bean.GroupData;
import cn.mmciel.bean.UploadRecord;
import cn.mmciel.bean.ViewData;
import cn.mmciel.dao.impl.GroupDataDaoImpl;
import cn.mmciel.dao.impl.ProjectDataDaoImpl;
import cn.mmciel.dao.impl.UploadRecordDaoImpl;

@WebServlet("/RealTimeCommitInterface")
public class RealTimeCommitInterface extends HttpServlet {

	List<GroupData> gdata = null;
	List<UploadRecord> udata = null;
	HashMap<String,GroupData> mgdata = null;
	HashMap<String,UploadRecord> mudata = null;
//	HashMap<String,ViewData> mvdata = null;
	List<ViewData> vdata = null;
	String projectId = null;
	String GroupKey = null;
	Timestamp ZeroTime = new Timestamp(new Date(0).getTime()); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");

		projectId = request.getParameter("projectid");
		
		//根据projectid先提取出本项目所有成员，再把已经提交信息写入所有成员中
//		创建map： number - {grade number name committime iscommit}
		GroupKey = new ProjectDataDaoImpl().getProjectDataByProjectId(projectId).getGroupkey();
		System.out.println("GrouoKey = "+ GroupKey);
		
		//取出所有名单
		gdata = new GroupDataDaoImpl().getGroupData(GroupKey);
		//取出已经提交的名单
		udata = new UploadRecordDaoImpl().getUploadRecordByProjectId(projectId);
		
		//构造已经提交名单的map
		getMudata();
		
		
		//构造总体名单
		getMvdata();
		
		//测试数据
//		for(ViewData item : vdata) {
//			System.out.println(item.toString());
//		}
		
//		生成json
		JSONObject obj = new JSONObject();
		int len = 1000;
		obj.put( "code", 0);
		obj.put( "msg", "");
		obj.put("data", vdata);
		len = JSON.toJSONString(vdata).length();
		obj.put( "count", len);
		String objstr = JSON.toJSONString(obj);
		//System.out.println(objstr);
		response.getWriter().print(objstr);

	}

	private void getMvdata() {
		vdata = new ArrayList<ViewData>();
		
		for(GroupData item : gdata) {
			String number = item.getNumber();
			UploadRecord temp = mudata.get(number);
		
			if(temp != null) { //查到了
				ViewData iv = new ViewData(projectId,
						item.getGroupkey(), item.getNumber(), 
						temp.getFileName(), temp.getCreateTime(),
						item.getName(), item.getGrade(),1);
				vdata.add(iv);
			}else {//没查到
				ViewData iv2 = new ViewData(projectId,
						item.getGroupkey(), item.getNumber(), 
						"", ZeroTime,
						item.getName(), item.getGrade(),0);
				vdata.add(iv2);
			}
			
		}
	}

	private void getMudata() {
		mudata = new HashMap<String, UploadRecord>();
		for(UploadRecord item : udata) {
			mudata.put(item.getNumber(), item);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
