package kr.or.ddit.prod.repository;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.prod.model.Prod;

@Repository
public class ProdDao implements IProdDao {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Prod> getProd(String id) {
		return sqlSession.selectList("prod.getProd", id);
	}

}
