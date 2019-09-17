package kr.or.ddit.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;

public class ContextPathInitListener implements ServletContextListener {
	
	private static final Logger logger = LoggerFactory.getLogger(ContextPathInitListener.class);
	

	//application 객체가 생성될 때 호출
	//application 객체는 서버가 기동이될떄 한번 한 객체가 생성된다
	// 만약 서버 contextPath 가 /(root) 이면 아무값도 안찍히게된다
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("cp", sc.getContextPath());
		
		//application객체가 생성될때 arrayList객체를 생성시켜준다
		sc.setAttribute("S_USERVO_LIST", new ArrayList<User>());
		logger.debug("cp : {}", sc.getAttribute("cp"));
	}

	//application 객체가 삭제될 때 호출
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
}
