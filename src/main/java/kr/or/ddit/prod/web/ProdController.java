package kr.or.ddit.prod.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.prod.service.IProdService;

@RequestMapping("prod/")
@Controller
public class ProdController {
	
	@Resource(name = "prodService")
	private IProdService prodService;
	
	@RequestMapping(path = "prodList", method = RequestMethod.GET)
	public String prodList(Model model, String id) {
		
		model.addAttribute("prodList", prodService.getProd(id));
		return "prod/prodList";
		
	}
	
}
