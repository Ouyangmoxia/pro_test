package cn.ouyang.web.servlet01;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Stuservlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收method参数
		String md=request.getParameter("method");
		String path = null;
		if(md != null){
			//获取到当前的字节码模块 
			Class clazz = this.getClass();
			try{
				//查看当前模块中是否有对应的方法，方法的名称和md中的内容一至方法参数都是否一样
				Method method = clazz.getMethod(md, HttpServletRequest.class, HttpServletResponse.class);
				if(method != null){
					//找到的对应方法，执行当前的方法，本质上就是在执行addStu, delStu, updateStu, findStu
					path = (String)method.invoke(this, request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		//通过判断method不能的取值，执行不同的函数
		//转发到success.jsp页面
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(path != null)
		{
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
	
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
