package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.model.Prod;

public interface IProdService  {
	List<Prod> getProd(String id);
}
