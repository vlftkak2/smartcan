package kr.ac.sungkyul.smartcan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 2016-09-26 
 작업자 : 최솔빈
 개발 상황 : 완료
*/

@Controller
public class MainController {
	
	@RequestMapping("/main")
	public String main(){
		
		return "/main/index";
	}
	
	@RequestMapping("/productintro")
	public String companyintro(){
		return "/main/productintro";
	}
	


}
