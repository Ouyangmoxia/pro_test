package cn.ouyang.web.servlet01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收method参数
		String md=request.getParameter("method");
		String path = null;
		if("addStu".equals(md)){
			path = addStu(request, response);
		}else if("delStu".equals(md)){
			path = delStu(request, response);
		}else if("updateStu".equals(md)){
			path = updateStu(request, response);
		}else if("findStu".equals(md)){
			path = findStu(request, response);
		}
		//通过判断method不能的取值，执行不同的函数
		//转发到success.jsp页面
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(path != null)
		{
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
	
	protected String addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务端添加学生的功能");
		//转发到success.jsp页面
		//request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
	
	protected String delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务端删除学生功能");
		//request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
	
	protected String updateStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务修改除学生功能");
		//这个是ajax实现，是不需要转发的直接响应数据即可
		response.getWriter().print("updateOK");
		return null;
	}
	
	protected String findStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务查询学生功能");
		//request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
}
