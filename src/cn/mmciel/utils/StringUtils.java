package cn.mmciel.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {
	
	private static final String hexDigIts[] = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    public static String getMD5(String origin){
        String resultString = null;
        try{
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes("utf-8")));
        }catch (Exception e){
        }
        return resultString;
    }
    private static String byteArrayToHexString(byte b[]){
        StringBuffer resultSb = new StringBuffer();
        for(int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b){
        int n = b;
        if(n < 0){
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }
    
//    public static void main(String[] args) {
//		String k = StringUtils.getMD5("123456");
//		System.out.println(k);
//	}

    /**
     * MD5中文加密
     * @param str
     * @return
     */
	public static String getZNstringMD5(String str) {  
	    String result = "";  
	    MessageDigest md5 = null;  
	    try {  
	        md5 = MessageDigest.getInstance("MD5");  
	        md5.update(str.getBytes("UTF-8"));  
	    } catch (NoSuchAlgorithmException e) {  
	        e.printStackTrace();  
	    } catch (UnsupportedEncodingException e) {  
	        e.printStackTrace();  
	    }  
	    byte b[] = md5.digest();  
	    int i;  
	    StringBuffer buf = new StringBuffer("");  
	    for (int offset = 0; offset < b.length; offset++) {  
	        i = b[offset];  
	        if (i < 0)  
	            i += 256;  
	        if (i < 16)  
	            buf.append("0");  
	        buf.append(Integer.toHexString(i));  
	    }  
	    result = buf.toString();  
	  
	    return result;  
	}  
//	public static void main(String[] args) {
//		String s = StringUtils.getZNstringMD5("你说2312");
//		System.out.println(s);
//	}
}
