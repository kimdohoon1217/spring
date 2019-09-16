package kr.or.ddit.lprod.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.lprod.model.Lprod;

public class LProdDaoTest extends RootTestConfig{
	
	@Resource(name = "lprodDao")
	private ILprodDao lprodDao;
	
	
	@Test
	public void getLprodListTest() {
		/***Given***/
		
		/***When***/
		List<Lprod> lprodList = lprodDao.getLprodList();

		/***Then***/
		assertEquals(10, lprodList.size());
	}
	
	@Test
	public void getLprodPagingListTest() {
		
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(5);

		/***When***/
		List<Lprod> lprodList = lprodDao.getLprodPagingList(page);

		/***Then***/
		assertEquals("1", lprodList.get(0).getLprod_id());
		assertEquals(5, lprodList.size());
	}
}
