package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.User;


@Service
public class UserService implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Resource(name = "userDao")
	private IUserDao userDao;
	
	public UserService() {
		
	}
	
	public UserService(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	
	@Override
	public List<User> getUserList() {
		List<User> userList = userDao.getUserList();
		return userList;
	}

	@Override
	public User getUser(String userId) {
		User user = userDao.getUser(userId);
		return user;
	}

	@Override
	public List<User> getUserListHalf() {
		List<User> userHalfList = userDao.getUserListHalf();
		return userHalfList;
	}

	@Override
	public Map<String,Object> getUserPagingList(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<User> pageList = userDao.getUserPagingList(page);
		int totalCnt = userDao.getUserTotalCnt();
		
		map.put("userList", pageList);
		map.put("paginationSize", (int)Math.ceil((double)totalCnt / page.getPagesize()));
		
		return map;
	}

	@Override
	public int insertUser(User user) {
		
		//선언적트랙잭션
		// .예외가 발생 했을때 정상적으로 rollback이 되는지
		// .예외가 발생하지 않고 정상적으로 코드가 실행되었을 때
		//  명시적인 commit없는데 commit이 정상적으로 되는지
		
		int insert = userDao.insertUser(user);
		return insert;
	}

	@Override
	public int deleteUser(String userId) {
		int delete = userDao.deleteUser(userId);
		return delete;
	}

	@Override
	public int modifyUser(User user) {
		int modify = userDao.modifyUser(user);
		return modify;
	}

}
