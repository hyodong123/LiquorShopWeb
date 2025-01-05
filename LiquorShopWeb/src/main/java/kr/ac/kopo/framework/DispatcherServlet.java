package kr.ac.kopo.framework;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;

public class DispatcherServlet extends HttpServlet 
{
	
	private HandlerMapping mappings;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String propName = config.getInitParameter("propName");
		//System.out.println("propName : " + propName);
		mappings = new HandlerMapping(propName);
	}
	//
	@Override
	public void service(HttpServletRequest request, 
	        HttpServletResponse response)
	        throws ServletException, IOException {
	    
	    String contextPath = request.getContextPath();
	    String uri = request.getRequestURI();
	    uri = uri.substring(contextPath.length());
	    System.out.println("요청 uri : " + uri);
	    
	    // 디버깅: 요청된 파라미터 목록 출력
	    System.out.println("요청된 파라미터 목록:");
	    request.getParameterMap().forEach((key, value) -> {
	        System.out.println(key + " : " + String.join(", ", value));
	    });
	    
	    try {
	        Controller control = mappings.getController(uri);
	        if (control == null) {
	            System.out.println("매핑되지 않은 URI: " + uri);
	            throw new ServletException("매핑되지 않은 URI: " + uri);
	        }
	        String callPage = control.handleRequest(request, response);
	        if (callPage != null) {
	            RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
	            dispatcher.forward(request, response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new ServletException("요청 처리 중 오류 발생: " + e.getMessage());
	    }
	}
}