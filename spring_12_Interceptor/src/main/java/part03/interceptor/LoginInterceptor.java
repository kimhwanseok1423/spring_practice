package part03.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
public LoginInterceptor() {
	// TODO Auto-generated constructor stub
}

@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
System.out.println("Login preHandle...");
String uri=request.getRequestURI();

// uri:/myapp/noticeList.do

uri=uri.substring(uri.lastIndexOf("/")+1);
System.out.println("uri:"+uri);

HttpSession session=request.getSession();
if(session.getAttribute("chk")==null) { //현재 로그인 상태가 아니면
response.sendRedirect("login.do?returnUrl="+uri);	//uri 위치로 보내기위함
return false;
}
	return true;
}

@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
	// TODO Auto-generated method stub
	super.postHandle(request, response, handler, modelAndView);
}

@Override
public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	// TODO Auto-generated method stub
	super.afterConcurrentHandlingStarted(request, response, handler);
}






}
