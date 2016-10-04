package kr.ac.sungkyul.smartcan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.sungkyul.smartcan.dao.MapDao;
import kr.ac.sungkyul.smartcan.vo.MapBoardVo;
import kr.ac.sungkyul.smartcan.vo.MapVo;

/*
 2016-10-04 
   작업자 : 최형민
   개발 상황 : 완료
*/

@Service
public class MapService {

	// 리스팅 되는 게시물 수
	private static final int LIST_PAGESIZE = 5; 
	
	// 페이지 리스트에 표시되는 페이지 수
	private static final int LIST_BLOCKSIZE = 3; 
	@Autowired
	private MapDao mapdao;

	public Map<String, Object> list(String spage, String keyword) {
		
		// 1. 페이지 값 받기
		int page = Integer.parseInt(spage);
		
		// 2. 페이지를 그리기 위한 기초 작업
		int totalCount = mapdao.getTotalCount();
		int pageCount = (int) Math.ceil((double) totalCount / LIST_PAGESIZE);
		int blockCount = (int) Math.ceil((double) pageCount / LIST_BLOCKSIZE);
		int currentBlock = (int) Math.ceil((double) page / LIST_BLOCKSIZE);

		// 3. page값 검증
		if (page < 1) {
			page = 1;
			currentBlock = 1;
		} else if (page > pageCount) {
			page = pageCount;
			currentBlock = (int) Math.ceil((double) page / LIST_BLOCKSIZE);
		}

		// 4. 페이지를 그리기 위한 값 계산
		int startPage = (currentBlock - 1) * LIST_BLOCKSIZE + 1;
		int endPage = (startPage - 1) + LIST_BLOCKSIZE;
		int prevPage = (page >= startPage) ? (page-1) : (currentBlock - 1) * LIST_BLOCKSIZE;
		int nextPage = (page <= endPage) ? (page+1) : currentBlock * LIST_BLOCKSIZE + 1;
		int nexttoPage = (currentBlock < blockCount) ? currentBlock * LIST_BLOCKSIZE + 1 : page;
		int prevtoPage = (currentBlock > 1) ? startPage-3  : page;
		
		List<MapBoardVo> list = mapdao.getList(page, LIST_PAGESIZE, keyword);
		
		// 5. map에 객체 담기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sizeList", LIST_PAGESIZE);
		map.put("firstPage", startPage);
		map.put("lastPage", endPage);
		map.put("prevPage", prevPage);
		map.put("nextPage", nextPage);
		map.put("currentPage", page);
		map.put("pageCount", pageCount);
		map.put("list", list);
		map.put("totalCount", totalCount);
		map.put("keyword", keyword);
		map.put("nexttoPage", nexttoPage);
		map.put("prevtoPage", prevtoPage);
		
		return map;
	}
	
	public Map<String, Object> maplist(String keyword, Long no){
		
		//맵 리스트 가져오기 
		List<MapVo> list=mapdao.getList(keyword, no);
		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("list", list);
		map2.put("keyword", keyword);
		return map2;
	}
	

}
