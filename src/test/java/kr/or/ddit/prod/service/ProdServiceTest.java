package kr.or.ddit.prod.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.prod.model.Prod;

public class ProdServiceTest extends RootTestConfig{
	
	@Resource(name="prodService")
	private IProdService prodService;
	

	@Test
	public void getProdtest() {
		/***Given***/

		/***When***/
		String id = "P101";
		List<Prod> list = prodService.getProd(id);

		/***Then***/
		assertEquals(6, list.size());
		
	}

}
