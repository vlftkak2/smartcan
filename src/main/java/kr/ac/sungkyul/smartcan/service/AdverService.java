package kr.ac.sungkyul.smartcan.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.sungkyul.smartcan.dao.AdverCenterDao;
import kr.ac.sungkyul.smartcan.vo.AdverBoardVo;
import kr.ac.sungkyul.smartcan.vo.AttachFileAdVO;

/*
2016-10-04 
 작업자 : 최형민
 개발 상황 : 완료
*/

@Service
public class AdverService {
	// 리스팅 되는 게시물 수
		private static final int LIST_PAGESIZE = 10; 
		// 페이지 리스트에 표시되는 페이지 수
		private static final int LIST_BLOCKSIZE = 5; 

		@Autowired
		private AdverCenterDao adverdao;

		public Map<String, Object> list(String spage, String keyword) {
			
			// 1. 페이지 값 받기
			int page = Integer.parseInt(spage);

			// 2. 페이지를 그리기 위한 기초 작업
			int totalCount = adverdao.getTotalCount();
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
			int prevPage = (page >= startPage) ? (page - 1) : (currentBlock - 1) * LIST_BLOCKSIZE;
			int nextPage = (page <= endPage) ? (page + 1) : currentBlock * LIST_BLOCKSIZE + 1;
			int nexttoPage = (currentBlock < blockCount) ? currentBlock * LIST_BLOCKSIZE + 1 : page;
			int prevtoPage = (currentBlock > 1) ? startPage - 3 : page;

			List<AdverBoardVo> list = adverdao.getList(page, LIST_PAGESIZE, keyword);

			Map<String, Object> map = new HashMap<String, Object>();
			
			// 5. map에 객체 담기
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

		//고객센터 글쓰기 작성
		public void write(AdverBoardVo vo, MultipartFile file) throws Exception{
			        
					// 1. 게시물의 번호 얻기
					Long no=adverdao.insert(vo);
					AdverBoardVo vo1 = adverdao.get(no);
					// 2. 그룹넘버 정보 얻어오기
					int groupno=vo1.getGroupNo(); 
					int orderno=vo1.getGroupOrderNo();

					
			       // 3. orgName
					String orgName ="이미지";
					
					// 4. fileSize
					long fileSize =file.getSize();
					
					// 5. saveName
					String saveName = UUID.randomUUID().toString()+ "_" + orgName;
					
					// 6. path 경로 정하기
					String path ="c:\\upload";
					
					//7. 첨부파일 객체에 담기
					AttachFileAdVO AttachFileAdVO = new AttachFileAdVO();
					AttachFileAdVO.setNo(no);
					AttachFileAdVO.setPath(path);
					AttachFileAdVO.setOrgName(orgName);
					AttachFileAdVO.setSaveName(saveName);
					AttachFileAdVO.setFileSize(fileSize);
					AttachFileAdVO.setGroupno(groupno);
					AttachFileAdVO.setOrderno(orderno);
													
					//8. 첨부파일 삽입
					adverdao.insertAttachFile(AttachFileAdVO);
					
					//9. 파일 복사 및 이동
					File target = new File(path, saveName);
					FileCopyUtils.copy(file.getBytes(),target);
			
		}
		
		//첨부파일 삭제
		public void delete(Integer no, int orderno){
			adverdao.delete(no,orderno);
		}

		//게시물 삭제
		public void delete(AdverBoardVo vo) {
			adverdao.delete(vo);
		}

		//게시물 정보 얻기
		public AdverBoardVo boardinfo(Long no) {

			AdverBoardVo vo = adverdao.get(no);
			return vo;
		}
		
		//게시물 조회수 증가
		public void viewcountup(Long no) {

			adverdao.updateViewCount(no);
		}
		
		//게시물 수정
		public void modify(AdverBoardVo vo){
			adverdao.update(vo);

		}
		
		//답글 조회수 증가
		public void updatereplyCount(int groupno, int ordernumber){
			
			
			adverdao.updatereplyCount(groupno, ordernumber);
		}
		
		//게시물 답글 달기
		public void reply(AdverBoardVo vo,MultipartFile file) throws Exception{
			
			// 1. 게시물의 번호 얻기
			Long no=adverdao.reply(vo);
			// 2. 그룹 정보 얻기
			AdverBoardVo vo1 = adverdao.get(no);
			int groupno=vo1.getGroupNo(); //그룹넘버 정보 얻어오기
			int orderno=vo1.getGroupOrderNo();
			
			 // 3. orgName
			String orgName ="이미지";
			
			// 4. fileSize
			long fileSize =file.getSize();
			
			// 5. saveName
			String saveName = UUID.randomUUID().toString()+ "_" + orgName;
			
			// 6. path 
			String path ="c:\\upload";
			
			//7. 첨부파일 객체에 담기
			AttachFileAdVO AttachFileAdVO = new AttachFileAdVO();
			AttachFileAdVO.setNo(no);
			AttachFileAdVO.setPath(path);
			AttachFileAdVO.setOrgName(orgName);
			AttachFileAdVO.setSaveName(saveName);
			AttachFileAdVO.setFileSize(fileSize);
			AttachFileAdVO.setGroupno(groupno);
			AttachFileAdVO.setOrderno(orderno);
					
			//8. 첨부파일 삽입
			adverdao.insertAttachFile(AttachFileAdVO);
			
			// 9. 파일 복사 및 이동
			File target = new File(path, saveName);
			FileCopyUtils.copy(file.getBytes(),target);

		}
		
		// 첨부파일 정보 얻기
		public AttachFileAdVO selectAttachFileByNO(Long no){
			return adverdao.selectAttachFileByNO(no);
		}
		
		//첨부파일 정보 얻기
		public AttachFileAdVO selectAttachFileByFNO(Long fNO){
			return adverdao.selectAttachFileByFNO(fNO);
		}
		
		//그룹 번호 얻기
		public int getgroupno(AttachFileAdVO vo){
			int groupno=adverdao.getgroupno(vo);
			
			return groupno;
		}
		
		////사용자에게 댓글 달린 것을 확인 하기 위한 객체 얻기
		public AdverBoardVo userno(int groupNo) {
			AdverBoardVo vo  = adverdao.getList(groupNo);
			return vo;
		}
}
