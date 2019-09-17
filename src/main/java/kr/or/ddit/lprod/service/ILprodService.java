package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;

public interface ILprodService {
	
	List<Lprod> getLprodList();
	
	/**
	 * Method : getLprodPagingList
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param page
	 * @return
	 * Method 설명 : 제품리스트 페이징 리스트 조회
	 */
	Map<String, Object> getLprodPagingList(Page page);
}
