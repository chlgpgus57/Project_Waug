package com.wg.p1.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.ui.context.Theme;

import com.wg.p1.model.GoodsVO;
import com.wg.p1.model.NationVO;
import com.wg.p1.model.ReviewVO;
import com.wg.p1.model.ThemeVO;
import com.wg.p1.util.Pager;

@Repository
public class AdminDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="adminMapper.";
	
	public int city_add(NationVO nationVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"city_add",nationVO);
	}

	public List<NationVO> city_list() throws Exception{
		return sqlSession.selectList(NAMESPACE+"city_list");
	}
	
	public NationVO check_city(NationVO nationVO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"check_city", nationVO);
	}
	
	public int addTheme(ThemeVO themeVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"addTheme", themeVO);
	}
	
	public ThemeVO selectTheme(ThemeVO themeVO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"selectTheme", themeVO);
	}
	
	public int theme_update(ThemeVO themeVO) throws Exception{
		return sqlSession.update(NAMESPACE+"theme_update", themeVO);
	}
	
	public int theme_delete(ThemeVO themeVO) throws Exception{
		return sqlSession.delete(NAMESPACE+"theme_delete", themeVO);
	}
	
	public List<ReviewVO> review_list(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"review_list", pager);
	}
	public int review_count(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"review_count", pager);
	}
	public int count_review_new() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"count_review_new");
	}
	public ReviewVO review_select(ReviewVO reviewVO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"review_select", reviewVO);
	}
	public int check_update() throws Exception{
		return sqlSession.update(NAMESPACE+"check_update");
	}
	public int reservation_date_1() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"reservation_date_1");
	}
	public int reservation_date_2() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"reservation_date_2");
	}
	public int reservation_date_3() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"reservation_date_3");
	}
	public int reservation_date_4() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"reservation_date_4");
	}
	public int reservation_date_today() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"reservation_date_today");
	}
	public List<Integer> hot5_goods()throws Exception{
		return sqlSession.selectList(NAMESPACE+"hot5_goods");
	}
	public int countReservation()throws Exception{
		return sqlSession.selectOne(NAMESPACE+"countReservation");
	}
	public int countMember()throws Exception{
		return sqlSession.selectOne(NAMESPACE+"countMember");
	}
	public int countGoods()throws Exception{
		return sqlSession.selectOne(NAMESPACE+"countGoods");
	}
	public int sumTotalSale()throws Exception{
		return sqlSession.selectOne(NAMESPACE+"sumTotalSale");
	}
	public List<String> hot5_city()throws Exception{
		return sqlSession.selectList(NAMESPACE+"hot5_city");
	}
	public List<GoodsVO> hot5_goodsss() throws Exception{
		return sqlSession.selectList(NAMESPACE+"hot5_goodsss");
	}
}
