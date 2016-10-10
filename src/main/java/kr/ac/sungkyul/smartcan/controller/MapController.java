package kr.ac.sungkyul.smartcan.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.sungkyul.smartcan.service.MapService;

/*
 2016-10-04 
   작업자 : 최형민
   개발 상황 : 완료
*/


@Controller
@RequestMapping("/map")
public class MapController {
	

	@Autowired
	MapService mapservice;
	
	//쓰레기 지점 검색 리스트
	@RequestMapping("/list")
	public String maplist(Model model,
			@RequestParam(value="p",required=true,defaultValue="1") String page,
			@RequestParam(value="kwd",required=false, defaultValue="") String keyword,
			@RequestParam(value="no", required=true, defaultValue="1") Long no){
		
		//게시판 리스트
		Map<String, Object> map=mapservice.list(page, keyword); 
		
		//지도 리스트
		Map<String, Object> map2=mapservice.maplist(keyword, no); 

		//게시판 리스트 객체 넘기기
		model.addAttribute("map", map);
		
		//지도 리스트 객체 넘기기
		model.addAttribute("map2", map2);

		return "/main/position_search";
	}
	
}
