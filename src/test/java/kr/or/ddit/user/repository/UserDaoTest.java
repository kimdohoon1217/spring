package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:kr/or/ddit/config/spring/context-root.xml",
		"classpath:kr/or/ddit/config/spring/context-datasource.xml",
		"classpath:kr/or/ddit/config/spring/context-transaction.xml"})
public class UserDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	//userDao를 테스트 하기 위해 필요한거
	//db 연결, 트랜잭션, dao
	private String userId = "brownTest";
	
	@Resource(name="userDao")
	private IUserDao userDao;
	
	@Before
	public void setup() {
		userDao.deleteUser(userId);
	}
	
	
	
	
	@Test
	public void getUserListTest() {
		/***Given***/
		
		/***When***/
		List<User> userList = userDao.getUserList();
		
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
		User userVo = userDao.getUser(userId);
		

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
		List<User> userList = userDao.getUserListHalf();
		
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
		List<User> pageList = userDao.getUserPagingList(page);
		

		/***Then***/
		assertEquals(10, pageList.size());
		assertEquals("xuserId22", pageList.get(0).getUserId());
		
	}
	
	/**
	 * Method : getUserTotalCnt
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 전체 사용자 건수 조회
	 */
	@Test
	public void getUserTotalCnt() {
		
		/***Given***/
		

		/***When***/
		int totalCnt = userDao.getUserTotalCnt();

		/***Then***/
		assertEquals(105, totalCnt);
		
	}
	
	/**
	 * Method : insertUserTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 사용자 등록 테스트
	 * @throws ParseException 
	 * @throws java.text.ParseException 
	 * @throws Exception 
	 */
	@Test
	public void insertUserTest() throws ParseException, Exception {
		
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
		int insertCnt = userDao.insertUser(user);
		
		
		/***Then***/
		assertEquals(1, insertCnt);
		
		
	}
	
	@Test
	public void ModifyUserTest() throws ParseException, Exception {
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
		userDao.insertUser(user);
		
		int res = userDao.modifyUser(user);
		
		
		/***Then***/
		assertEquals(1, res);
	}
	
	
	
	

}
