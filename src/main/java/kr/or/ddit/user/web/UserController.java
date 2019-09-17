package kr.or.ddit.user.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;

@RequestMapping("user/")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name = "userService")
	private IUserService userService;
	
	/**
	 * Method : userView
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 상세화면 요청
	 */
	
	//사용자가 localhost:8081/spring/user/view.do
	@RequestMapping("view.do")
	public String userView() {
		logger.debug("userController.userView()");
		return "user/view";
		
		//prefix + viewName + suffix
		//WEB-INF/views/user/view.jsp
	}
	
//	//사용자가 localhost:8081/user/modifyView
//	@RequestMapping("modifyView")
//	public String userModifyView() {
//		return null;
//	}
	
	
	/**
	 * Method : userList
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param model
	 * @return
	 * Method 설명 : 사용자 전체 리스트 조회
	 */
	@RequestMapping(path = "userList", method = RequestMethod.GET)
	public String userList(Model model) {
		
//		List<User> userList = userService.getUserList();
//		
//		request.setAttribute("userList", userList);
//		
//		request.getRequestDispatcher("/user/userList.jsp").forward(request, response);
		
		//사용자 정보 전체 조회
		model.addAttribute("userList", userService.getUserList());
		
		return "user/userList";
	}
	
	@RequestMapping(path = "userListOnlyHalf", method = RequestMethod.GET)
	public String userOnlyHalf(Model model) {
		
		model.addAttribute("list", userService.getUserListHalf());
		return "user/userListOnlyHalf";
	}
	
	@RequestMapping(path = "userPagingList", method = RequestMethod.GET)
	//public String userPagingList(Model model, Integer page, Integer pagesize) {
	public String userPagingList(Model model, Page page) {
		
//		page = page == null ? 1 : page;
//		pagesize = pagesize == null ? 10 : pagesize;
		
		model.addAttribute("pageVo", page);
		
		Map<String, Object> resultMap = userService.getUserPagingList(page);
//		List<User> pageList = (List<User>)resultMap.get("userList");
//		int paginationSize = (Integer)resultMap.get("paginationSize");
		model.addAllAttributes(resultMap);
		
		
//		model.addAttribute("userList", pageList);
//		model.addAttribute("paginationSize", paginationSize);
		
		return "user/userPagingList";
		
	}
	
	
}
