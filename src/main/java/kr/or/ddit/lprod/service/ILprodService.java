package kr.or.ddit.lprod.service;

import java.util.Map;

import kr.or.ddit.common.model.Page;

public interface ILprodService {
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
