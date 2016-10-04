package kr.ac.sungkyul.smartcan.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.sungkyul.smartcan.dao.StatisticDao;

@Service
public class StatisticService {
	@Autowired
	private StatisticDao statisticDao;
	
	public Map<String, Object> getList(){
		Long anyang = statisticDao.getAnyang();
		Long incheon = statisticDao.getIncheon();
		Long seoul = statisticDao.getSeoul();
		Long anyangCount = statisticDao.getAnyangCount();
		Long incheonCount = statisticDao.getIncheonCount();
		Long seoulCount = statisticDao.getSeoulCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("anyang", anyang);
		map.put("incheon", incheon);
		map.put("seoul", seoul);
		map.put("anyangCount", anyangCount);
		map.put("incheonCount", incheonCount);
		map.put("seoulCount", seoulCount);
		return map;
	}
	
}