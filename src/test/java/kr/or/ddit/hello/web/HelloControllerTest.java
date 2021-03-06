package kr.or.ddit.hello.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.config.test.WebTestConfig;


public class HelloControllerTest extends WebTestConfig{

	//server(tomcat)가 없는 환경에서 테스트가능하다

	@Test
	public void helloTest() throws Exception {
		/***Given***/

		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/hello/hello.do").param("userId", "brown")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		String msg = (String) mav.getModel().get("msg");
		String userId = (String)mav.getModelMap().get("userId");
		
		//controller viewName(String)을 리턴하지만, 
		//스프링 프레임워크 내부에서는 viewName을 ModelAndView객체로 변환해서 사용
		//또한 컨트롤러 메소드에서는 viewName뿐만 아니라 ModelAndView 객체, View객체 리턴하는게 가능
		//리턴타입이 void인 경우도 존재(response객체를 통해 개발자가 직접 응답을 생성)
		
		/***Then***/
		assertEquals("hello/hello", mav.getViewName());
		assertEquals("hello, world", msg);
		assertEquals("brown_helloController", userId);
	}
	
	@Test
	public void helloTest2() throws Exception {
		mockMvc.perform(get("/hello/hello.do").param("userId", "sally"))
		.andExpect(status().isOk())
		.andExpect(view().name("hello/hello"))
//		.andExpect(model().attributeExists("msg"))
//		.andExpect(model().attributeExists("userId"))
		.andExpect(model().attribute("msg", "hello, world"))
		.andExpect(model().attribute("userId", "sally_helloController"));
		
	}

}
