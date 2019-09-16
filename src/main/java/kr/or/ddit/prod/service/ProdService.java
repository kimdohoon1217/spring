package kr.or.ddit.prod.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.prod.model.Prod;
import kr.or.ddit.prod.repository.IProdDao;
import kr.or.ddit.prod.repository.ProdDao;

@Service
public class ProdService implements IProdService{

	@Resource(name = "prodDao")
	private IProdDao prodDao;
	
	public ProdService() {
		prodDao = new ProdDao();
	}
	
	@Override
	public List<Prod> getProd(String id) {
		List<Prod> list = null;
		list = prodDao.getProd(id);
		return list;
	}

}
