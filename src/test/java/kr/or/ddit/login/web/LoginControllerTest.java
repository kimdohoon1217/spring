package kr.or.ddit.login.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.config.test.WebTestConfig;
import kr.or.ddit.user.model.User;

public class LoginControllerTest extends WebTestConfig{
	private static final Logger logger = LoggerFactory.getLogger(LoginControllerTest.class);

	/**
	 * Method : loginViewTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 로그인 화면 요청 테스트
	 * @throws Exception 
	 */
	@Test
	public void loginViewTest() throws Exception {
		/***Given***/

		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/login")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals("login/login", mav.getViewName());
	}
	
	@Test
	public void loginProcessTest() throws Exception {
		/***Given***/
//		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		//가짜 session 객체
		MockHttpSession session = new MockHttpSession();
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/login")
				.param("userId", "brown").param("pass", "brown1234").session(session)).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		User user = (User)session.getAttribute("S_USERVO");
		logger.debug("user - {}",user);

		/***Then***/
		assertNotNull(user);
		assertEquals("main", mav.getViewName());
	}
	

}
