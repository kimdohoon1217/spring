package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public interface IUserDao {
	List<User> getUserList();

	User getUser(String userId);
	
	List<User> getUserListHalf();
	
	/**
	 * Method : getUserPagingList
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param page
	 * @return
	 * Method 설명 : 사용자 페이징 리스트 조회
	 */
	List<User> getUserPagingList(Page page);
	
	/**
	 * Method : getUserTotalCnt
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 전체 사용자 건수 조회
	 */
	int getUserTotalCnt();
	
	/**
	 * Method : insertUser
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param user
	 * @return
	 * Method 설명 : 사용자 등록
	 */
	int insertUser(User user);
	
	/**
	 * Method : deleteUser
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 삭제
	 */
	int deleteUser(String userId);
	
	/**
	 * Method : modifyUser
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param map
	 * @return
	 * Method 설명 : 사용자 수정
	 */
	int modifyUser(User user);
}
