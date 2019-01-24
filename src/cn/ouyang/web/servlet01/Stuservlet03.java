package cn.ouyang.web.servlet01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ouyang.web.baseservlet.Baseservlet;


public class Stuservlet03 extends Baseservlet {
	public String addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务端添加学生的功能");
		//转发到success.jsp页面
		//request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
	
	public String delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务端删除学生功能");
		//request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
	
	public String updateStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务修改除学生功能");
		//这个是ajax实现，是不需要转发的直接响应数据即可
		response.getWriter().print("updateOK");
		return null;
	}
	
	public String findStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务查询学生功能");
		//request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
}
