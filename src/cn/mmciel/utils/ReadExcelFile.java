package cn.mmciel.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	private Workbook workbook =null;
	private Sheet sheet = null;
	private Row row = null;
	private ArrayList<ArrayList<String>> list = null;

	/**
	 * ����1.import org.apache.poi.ss.usermodel.Workbook,��ӦExcel�ĵ���
		
		����2.import org.apache.poi.hssf.usermodel.HSSFWorkbook����Ӧxls��ʽ��Excel�ĵ���
		
		����3.import org.apache.poi.xssf.usermodel.XSSFWorkbook����Ӧxlsx��ʽ��Excel�ĵ���
		
		����4.import org.apache.poi.ss.usermodel.Sheet����ӦExcel�ĵ��е�һ��sheet��
		
		����5.import org.apache.poi.ss.usermodel.Row����Ӧһ��sheet�е�һ�У�
		
		����6.import org.apache.poi.ss.usermodel.Cell����Ӧһ����Ԫ��
		
			String s = ReadExcelFile.class.getClassLoader().getResource("").toURI().getPath();
			System.out.println(s);
			System.out.println(Class.class.getClass().getResource("/").getPath());
			System.out.println(System.getProperty("user.dir"));
			/D:/PublicCode/WebWorkspace/AAAA/build/classes/
			/D:/PublicCode/WebWorkspace/AAAA/build/classes/
			D:\PublicCode\WebWorkspace\AAAA
			
					
		String WebProjectPath = this.getClass().getResource("/").getPath().replaceFirst("/", "").replaceAll("WEB-INF/classes/", ""); 
		
		String ExcelFileFloder = WebProjectPath+"/group-data-excel-file";

			
	 */
//	public static void main(String[] args) {
//		ReadExcelFile file = new ReadExcelFile();
//		file.OpenExcel("C:\\Users\\mmciel\\Desktop\\stu.xlsx");
//		file.PrintList(file.getListData());
//	}
	//��ӡ list
	public void PrintList(ArrayList<ArrayList<String>> lists) {
        for (ArrayList<String> list: lists) {
            for (String s: list) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
	}
	//��ȡ�ļ���Ϣ��list
	public ArrayList<ArrayList<String>> getListData(){
		try {
			list = new ArrayList<ArrayList<String>>();
            //��ȡ��һ��sheet
            sheet = workbook.getSheetAt(0);
            //��ȡ�������
            int MaxRow = sheet.getPhysicalNumberOfRows();
            //��ȡ��һ��
            row = sheet.getRow(0);
            //��ȡ�������
            int MaxCol = row.getPhysicalNumberOfCells();
            for (int i = 1; i<MaxRow; i++) {
                row = sheet.getRow(i);
                ArrayList<String> tempData = new ArrayList<String>();
                if(row !=null){
                    for (int j=0;j<MaxCol;j++){
                        tempData.add((String) getCellFormatValue(row.getCell(j)));
                    }
                }else{
                    break;
                }
                list.add(tempData);
            }
        }catch (NullPointerException e) {
			e.printStackTrace();
			
		}
		return list;
	}

	private static Object getCellFormatValue(Cell cell){
	    Object cellValue = null;
	    if(cell!=null){
	        //�ж�cell����
	        switch(cell.getCellTypeEnum()){
	        case NUMERIC:{
	        	cell.setCellType(Cell.CELL_TYPE_STRING);
	        	cellValue = cell.getStringCellValue();
	            break;
	        }
	        case FORMULA:{
	        	cell.setCellType(Cell.CELL_TYPE_STRING);
	        	cellValue = cell.getStringCellValue();

	            break;
	        }
	        case STRING:{
	            cellValue = cell.getStringCellValue();
	            break;
	        }
	        default:
	            cellValue = "";
	        }
	    }else{
	        cellValue = "";
	    }
	    return cellValue;
	}

	//���ļ�
	public boolean OpenExcel(String path) {

        String extString = path.substring(path.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            if(".xls".equals(extString)){
                workbook = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                workbook = new XSSFWorkbook(is);
            }else{
                workbook = null;
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } 
		if(workbook == null) {
			return false;
		}else { 
			return true;
		}
		
	}

}
