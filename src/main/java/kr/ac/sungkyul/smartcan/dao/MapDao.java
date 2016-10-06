package kr.ac.sungkyul.smartcan.dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.sungkyul.smartcan.vo.MapBoardVo;
import kr.ac.sungkyul.smartcan.vo.MapVo;

/*
 2016-10-04 
  작업자 : 최형민
  개발 상황 : 완료
*/


@Repository
public class MapDao {

	@Autowired
	private SqlSession sqlSession;

	//게시물 리스트 가져오기
	public List<MapBoardVo> getList(int page, int pagesize, String keyword) {

		Map<String, Object> map = new HashMap<>();

		 //키보드가 null or 비어있을 때 리스트 가져오기
		if (keyword == null || "".equals(keyword)) {

			map.put("page_start", (page - 1) * pagesize + 1);
			map.put("page_end", page * pagesize);

			List<MapBoardVo> list = sqlSession.selectList("search.getList", map);

			return list;

		//검색된 리스트 가져오기
		} else {

			map.put("keyword", "%" + keyword + "%");
			map.put("page_start", (page - 1) * pagesize + 1);
			map.put("page_end", page * pagesize);

			List<MapBoardVo> list = sqlSession.selectList("search.getListKeyword", map);

			return list;

		}
	}

	 //게시판 총 개수
	public int getTotalCount() {

		int totalCount = sqlSession.selectOne("search.getTotalCount");
		return totalCount;
	}
	
	//지도 리스트 가져오기
	public List<MapVo> getList(String keyword, Long reno) {

		Map<String, Object> map = new HashMap<>();
	  	
		//키보드가 null or 비어있을 때 지도 리스트 가져오기
		if (keyword == null || "".equals(keyword)) {

			map.put("reno", reno);
			List<MapVo> list = sqlSession.selectList("search.getMapList", map);

			return list;

		//검색된 지도 리스트 가져오기
		} else {
			
			map.put("keyword", "%" + keyword + "%");
			List<MapVo> list = sqlSession.selectList("search.getMapListKeyword", map);

			return list;
		}
	}
	
	//(안드로이드)지도 좌표 리스트
	public List<MapVo> getPointList(){
		
		List<MapVo> list=sqlSession.selectList("search.getPointList");
		return list;
	}
	
	//(안드로이드)검색된 좌표값 가져오기
	public List<MapVo> getSearchlist(String keyword){

		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		
		List<MapVo> list=sqlSession.selectList("search.getSearchlist",map);
		return list;
	}

}
