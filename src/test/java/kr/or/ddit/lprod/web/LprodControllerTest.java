package kr.or.ddit.lprod.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.config.test.WebTestConfig;

public class LprodControllerTest extends WebTestConfig{


	@Test
	public void lprodListTest() throws Exception {
		/***Given***/

		/***When***/
		mockMvc.perform(get("/lprod/lprodList"))
			.andExpect(model().attributeExists("lprodList"))
			.andExpect(view().name("lprod/lprodList"));
		/***Then***/
	}
	
	@Test
	public void lprodPagingListTest() throws Exception {
		/***Given***/
		
		/***When***/
		mockMvc.perform(get("/lprod/lprodPagingList"))
		.andExpect(model().attributeExists("list"))
		.andExpect(model().attributeExists("paginationSize"))
		.andExpect(view().name("lprod/lprodPagingList"));
		/***Then***/
	}

}
