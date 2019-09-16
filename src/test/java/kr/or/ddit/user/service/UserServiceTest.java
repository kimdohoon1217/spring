package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.user.model.User;


public class UserServiceTest extends RootTestConfig{

	private String userId = "brownTest";
	
	@Resource(name = "userService")
	private IUserService userService;
	
	@Test
	public void getUserListTest() {
		/***Given***/
		
		/***When***/
		List<User> userList = userService.getUserList();
		
		/***Then***/
		assertEquals(105, userList.size());
		
	}
	
	
	
	/**
	 * Method : getUserTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		//한개의메서드만 실행하고싶으면 클래스위에서 ctrl + F11을 한다
		/***Given***/
		String userId = "brown";
		
		/***When***/
		User userVo = userService.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
		//assertEquals("brown1234", userVo.getPass());
		
		
		
	}
	
	/**
	 * Method : getUserListHalf
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 사용자 전체리스트중에 절반(50 개만)출력
	 */
	
	@Test
	public void getUserListHalf() {
		/***Given***/
		
		/***When***/
		List<User> userList = userService.getUserListHalf();
		
		/***Then***/
		assertEquals(50, userList.size());
	}
	
	/**
	 * Method : getUserPagingList
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void getUserPagingList() {
		/***Given***/
		Page page = new Page();
		page.setPage(3);
		page.setPagesize(10);

		/***When***/
		Map<String, Object> resultMap = userService.getUserPagingList(page);
		List<User> userList = (List<User>)resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");

		/***Then***/
		assertEquals(10, userList.size());
		assertEquals("xuserId22", userList.get(0).getUserId());
		assertEquals(11, paginationSize);
		
	}
	
	@Test
	public void ceilingTest() {
		/***Given***/
		int totalCnt = 1;
		int pagesize = 10;
		
		/***When***/
		double paginationSize = Math.ceil((double)totalCnt / pagesize);

		/***Then***/
		assertEquals(1, (int)paginationSize);
	}
	
	@Test
	public void insertUserTest() throws ParseException{
		
		/***Given***/
		User user = new User();
		//'2019-08-08'
		
		user.setUserId(userId);
		user.setUserNm("브라운테스트");
		user.setAlias("곰테스트");
		user.setPass("brownTest1234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");
		
		
		/***When***/
		int insertCnt = userService.insertUser(user);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void ModifyUserTest() throws ParseException {
		/***Given***/
		User user = new User();
		user.setUserId(userId);
		user.setUserNm("브라운테스트");
		user.setAlias("곰테스트");
		user.setPass("brownTest1234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");
		user.setRealFilename("user.jpg");
		/***When***/
		int in = userService.insertUser(user);
		int res = userService.modifyUser(user);
		
		/***Then***/
		assertEquals(1, res);
	}
	
}
