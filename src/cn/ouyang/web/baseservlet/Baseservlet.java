package cn.ouyang.web.baseservlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Baseservlet
 */
public class Baseservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			
		}else{
			execute(request, response);
		}
		//通过判断method不能的取值，执行不同的函数
		//转发到success.jsp页面
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(path != null)
		{
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("您需要提交method的键值对");
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
