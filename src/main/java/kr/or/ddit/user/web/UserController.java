package kr.or.ddit.user.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.model.UserValidator;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.util.FileUtil;
import kr.or.ddit.util.model.FileInfo;

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
	//public String userPagingList(Model model, @RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer pagesize) {
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
		
		//return "user/userPagingList";   //internalResourceViewResolver를 통한 응답
		return "tiles.userPagingList";
		
		//viewResolver order에 따라
		/*
		 * 1. tilesViewSolver가 tiles definition파일중에
		 *    viewName 과 일치하는 definition 이름을 검색
		 *    1-1. 검색이 될 경우 해당 definition을 이용하여 응답생성
		 *    1-2. 검색이 안될 경우 다음 우선순위를 갖는 viewResovler가 처리
		 *    
		 * 2. beanNameViewResolver  
		 * 3. internalResourceViewResolver
		 * 		
		 */
		
	}
	
	
	@RequestMapping(path = "userPagingListAjaxView")
	public String userPagingListAjaxView() {
		return "user/userPagingListAjaxView";
	}
	
	
	
	
	
	@RequestMapping(path = "userPagingListAjax", method = RequestMethod.GET)
	//public String userPagingList(Model model, @RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer pagesize) {
	public String userPagingListAjax(Model model, Page page) {
		
		model.addAttribute("pageVo", page);
		
		Map<String, Object> resultMap = userService.getUserPagingList(page);
		model.addAllAttributes(resultMap);
		
		return "jsonView";
		
	}
	

   /**
   * Method : userPagingListAjaxRequestBody
   * 작성자 : JEON MIN GYU
   * 변경이력 :
   * @param page
   * @param model
   * @return
   * Method 설명 : 사용자 페이징 리스트 결과를 json형식으로 생성
   */
   @RequestMapping(path = "userPagingListAjaxRequestBody", method = RequestMethod.POST)
   @ResponseBody
   public Map<String, Object> userPagingListAjaxRequestBody(@RequestBody Page page, Model model) {
      
      Map<String, Object> resultMap = userService.getUserPagingList(page);
      resultMap.put("pageVo", page);
      
      return resultMap;
   }
	
	
	@GetMapping("user")
	public String userDetail(Model model, String userId) {
		
		model.addAttribute("user", userService.getUser(userId));
		
		return "tiles.user";
	}
	
	@GetMapping("userPicture")
	public void userPicture(String userId, HttpServletResponse response) throws IOException {
		
		User user = userService.getUser(userId);
		
		ServletOutputStream sos = response.getOutputStream();
		
		
		File picture = new File(user.getRealFilename());
//		if(!picture.exists()) {
//			picture = new File("")
//		}
		
		FileInputStream fis = new FileInputStream(picture);
		
		byte[] buff = new byte[512];
		int len = 0;
		while((len = fis.read(buff, 0, 512)) != -1) {
			sos.write(buff, 0, len);
		}
		
		fis.close();
		
	}
	
	@RequestMapping(path = "userForm", method = RequestMethod.GET)
	public String userFormView() {
		return "user/userForm";
	}
	
	//사용자 등록 요청
	@RequestMapping(path = "userForm", method = RequestMethod.POST)
	public String userForm(User user, BindingResult result,
											@RequestPart("picture") MultipartFile picture) {
		
		new UserValidator().validate(user, result);
		if(result.hasErrors())
			return "user/userForm";
		
		else {
			FileInfo fileInfo = FileUtil.getFileInfo(picture.getOriginalFilename());
			
			//첨부된 파일이 있을 경우만 업로드 처리s
			if(picture.getSize() > 0) {
				try {
					picture.transferTo(fileInfo.getFile());
					user.setFilename(fileInfo.getOriginalFileName());	//originalFilename
					user.setRealFilename(fileInfo.getFile().getPath());
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			int insertCnt = userService.insertUser(user);
			
			if(insertCnt == 1)
				return "redirect:/user/user?userId=" + user.getUserId();
			else {
				return "user/userForm";
			}
		}
	}
	
	
	@GetMapping(path = "userModify")
	public String getUserModify(Model model, String userId) {
		
		model.addAttribute("user", userService.getUser(userId));
		
		return "user/userModiForm";
		
	}
	
	@PostMapping(path = "userModify")
	public String postUserModify(Model model, User user, BindingResult result, @RequestPart("picture") MultipartFile picture) {
		
		User vo = userService.getUser(user.getUserId());
		
		user.setFilename(vo.getFilename());
		user.setRealFilename(vo.getRealFilename());
		
			FileInfo fileInfo = FileUtil.getFileInfo(picture.getOriginalFilename());
			
			//첨부된 파일이 있을 경우만 업로드 처리
			if(picture.getSize() > 0) {
				try {
					picture.transferTo(fileInfo.getFile());
					user.setFilename(fileInfo.getOriginalFileName());	//originalFilename
					user.setRealFilename(fileInfo.getFile().getPath());
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			int modiCnt = userService.modifyUser(user);
			if(modiCnt == 1)
				return "redirect:/user/user?userId=" + user.getUserId();
			else {
				return "user/userModiForm";
			}
	}
	
	/**
	 * Method : userPagingListHtmlAjax
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param page
	 * @param pagesize
	 * @param model
	 * @return
	 * Method 설명 : 사용자 페이징 리스트의 결과를 html로 생성한다 (jsp 응답)
	 */
	@RequestMapping("userPagingListHtmlAjax")
	public String userPagingListHtmlAjax(@RequestParam(defaultValue = "1") int page,
										 @RequestParam(defaultValue = "10") int pagesize,
										 Model model) {
		Page pageVo = new Page(page, pagesize);
		Map<String, Object> resultMap = userService.getUserPagingList(pageVo);
		model.addAllAttributes(resultMap);
		model.addAttribute("pageVo", pageVo);
		
		return "user/userPagingListHtmlAjax";
	}
	
}	
