package com.greener.codegreen.visit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.greener.codegreen.dao.VisitCountDAO;
import com.greener.codegreen.dto.VisitCountDTO;

public class SessionListener implements HttpSessionListener {
	
	@Override
    public void sessionCreated(HttpSessionEvent sessionEve) {
		
    	System.out.println("===execute() 실행===\n");
		
		// 세션이 새로 생성되면 execute() 실행한다.
        if(sessionEve.getSession().isNew()){
            execute(sessionEve);
        }
	}
        
	private void execute(HttpSessionEvent sessionEve) {

		System.out.println("===execute() 실행 시작===\n");

		HttpSession session = sessionEve.getSession();
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(session.getServletContext());

		// 등록되어있는 빈을 사용할수 있도록 설정해준다
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();

		// request를 파라미터에 넣지 않고도 사용할수 있도록 설정
		VisitCountDAO VisitCountDAO = (VisitCountDAO) wac.getBean("VisitCountDAO");
		VisitCountDTO dto = new VisitCountDTO();
		dto.setV_ip(req.getRemoteAddr());

		try {

			VisitCountDAO.insertVisitor(dto);

		} catch (Exception e) {

			System.out.println("===방문자 카운터 오류===\n");
			e.printStackTrace();

		}
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}
       
}
