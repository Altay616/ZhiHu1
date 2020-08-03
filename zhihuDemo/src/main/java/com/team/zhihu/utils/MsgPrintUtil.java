package com.team.zhihu.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class MsgPrintUtil {
		
	/**
	 *  功能 ： 将 跳转到路径 并提示相应的信息
	 * @param resp  HttpServletResponse实体
	 * @param msg : 要提示的信息
	 * @param path  跳转的路径
	 * @throws IOException
	 */
	
	public static void doResponse(HttpServletResponse resp,String msg,String path) throws IOException {
		 resp.setContentType("text/html; charset=UTF-8");
		 String sendMsg = "alert('"+msg +"');";
		 String pathInfo = "location.href='"+path+"';";
	 		PrintWriter out = resp.getWriter();
			out.write("<script>");
			out.write(sendMsg);
			out.write(pathInfo);
			out.write("</script>");
			out.close();
	}
}
