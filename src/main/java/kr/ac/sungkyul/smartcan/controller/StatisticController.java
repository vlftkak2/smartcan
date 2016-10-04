package kr.ac.sungkyul.smartcan.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.sungkyul.smartcan.service.StatisticService;

@Controller
@RequestMapping("/statistic")
public class StatisticController {
	
	@Autowired
	private StatisticService statisticService;
	
	@RequestMapping("/statistic")
	public String statistic(Model model){
		
		Map<String, Object> map = statisticService.getList();
		model.addAttribute("map",map);
		return "/main/statistic";
	}
}
