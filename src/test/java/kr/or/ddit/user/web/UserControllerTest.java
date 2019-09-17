package kr.or.ddit.user.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.WebTestConfig;

public class UserControllerTest extends WebTestConfig {
	private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

	/**
	 * Method : userListTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 사용자 리스트 조회 
	 */
	@Test
	public void userListTest() throws Exception {
		/***Given***/

		/***When***/
		mockMvc.perform(get("/user/userList"))
				.andExpect(model().attributeExists("userList"))
				.andExpect(view().name("user/userList"));

		/***Then***/
	}
	
	/**
	 * Method : userListOnlyHalfTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 사용자 절반 리스트 조회
	 */
	@Test
	public void userListOnlyHalfTest() throws Exception {
		/***Given***/
		
		/***When***/
		mockMvc.perform(get("/user/userListOnlyHalf"))
				.andExpect(model().attributeExists("list"))
				.andExpect(view().name("user/userListOnlyHalf"));
		
		/***Then***/
	}
	
	/**
	 * Method : userPagingListTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Test
	public void userPagingListTest() throws Exception {
		/***Given***/
		
		/***When***/
		mockMvc.perform(get("/user/userPagingList"))
				.andExpect(model().attributeExists("userList"))
				.andExpect(model().attributeExists("paginationSize"))
				.andExpect(view().name("user/userPagingList"));
		
		/***Then***/
	}
	
	@Test
	public void pageTest() {
		Page page = new Page();
		logger.debug("page : {}", page);
		
	}

}
