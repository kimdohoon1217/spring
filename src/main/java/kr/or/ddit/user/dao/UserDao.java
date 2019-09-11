package kr.or.ddit.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

//class 명에서 맨 첫글자를 소문자로 변경한 문자열이 스프링 빈 이름으로 기본 설정됨
//다른이름의 스프링 빈이름으로 등록을 하려면 속성 설정 @Repository("설정하고자 하는 스프링 빈 이름")
@Repository
public class UserDao implements IUserDao {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	

	/**
	 * Method : getUserList
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<User> getUserList() {
		return sqlSession.selectList("user.getUserList");
//		List<User> userList = new ArrayList<User>();
//		userList.add(new User("brown"));
//		userList.add(new User("cony"));
//		userList.add(new User("sally"));
//		return userList;
	}


	@Override
	public User getUser(String userId) {
		return sqlSession.selectOne("user.getUser", userId);
	}


	@Override
	public List<User> getUserListHalf() {
		
		return sqlSession.selectList("user.getUserListHalf");
	}


	@Override
	public List<User> getUserPagingList(Page page) {
		return sqlSession.selectList("user.getUserPagingList", page);
	}


	@Override
	public int getUserTotalCnt() {
		return sqlSession.selectOne("user.getUserTotalCnt");
	}


	@Override
	public int insertUser(User user) {
		
		return sqlSession.insert("user.insertUser", user);
	}


	@Override
	public int deleteUser(String userId) {
		
		return sqlSession.delete("user.deleteUser", userId);
	}


	@Override
	public int modifyUser(User user) {
		return sqlSession.update("user.modifyUser", user);
	}

}
