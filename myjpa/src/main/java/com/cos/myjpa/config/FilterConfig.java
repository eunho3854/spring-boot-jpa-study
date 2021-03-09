package com.cos.myjpa.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cos.myjpa.filter.MyAuthenticationFilter;

// web.xml

// 설정 관련된 클래스이기 때문에 @Configuration
@Configuration
public class FilterConfig {
	
	// 리턴되는 값을 IoC에 등록
	@Bean
	public FilterRegistrationBean<MyAuthenticationFilter> authenticationFilterAddRegister() {
		
		// 필터 객체 생성 완료
		FilterRegistrationBean<MyAuthenticationFilter> bean =
				new FilterRegistrationBean<>(new MyAuthenticationFilter());
		
		// 어떻게 들어오든 동작 시키겠다.
		bean.addUrlPatterns("/test");
		// 필터 여러 개 -> 필터 순서 -> SetOrder(0) 낮은 숫자가 먼저 실행됨
		
		return bean;
	}
}
