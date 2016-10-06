package kr.ac.sungkyul.smartcan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.sungkyul.smartcan.service.MapService;
import kr.ac.sungkyul.smartcan.vo.MapVo;

@Controller
@RequestMapping("/android")
public class AndroidDispatch {
	
	@Autowired
	MapService mapservice;
	
	//안드로이드에 DB에 등록된 좌표값 전송
	@RequestMapping(value="/getJsonPoint", method=RequestMethod.GET)
	@ResponseBody
	public List<MapVo> AndroidGetPoint(HttpServletRequest request) {
		
		List<MapVo> list=mapservice.getPointList();
		
		return list;
	}
	
	//안드로이드에서 지역 검색 시, 검색된 좌표값 뿌려주기 
	@RequestMapping(value="/getSearchPoint", method=RequestMethod.GET)
	@ResponseBody
	public List<MapVo> AndroidGetSearchPoint(HttpServletRequest request,
		@RequestParam(value="keyword",required=false, defaultValue="") String keyword){
		
		System.out.println(keyword); //param값 잘 넘어오는지 확인
		
		List<MapVo> list=mapservice.getSearchlist(keyword); 
		
		return list;
	}

}
