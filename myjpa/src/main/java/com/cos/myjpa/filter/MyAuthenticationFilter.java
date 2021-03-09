package com.cos.myjpa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cos.myjpa.domain.user.User;
import com.cos.myjpa.handler.ex.MyAuthenticationException;

// Filter (javax.servlet) 
public class MyAuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("나의 인증 필터");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		User principal = (User)session.getAttribute("principal");
		
		if(principal == null) { //로그인이 안되었다는 뜻
			// 로그인 안 하면 AuthenticationException 에러 뜸.
			throw new MyAuthenticationException();
		} else {
			chain.doFilter(request, response);
		}
		
	}

}
