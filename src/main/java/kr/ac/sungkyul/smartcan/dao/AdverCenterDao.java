package kr.ac.sungkyul.smartcan.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.sungkyul.smartcan.vo.AdverBoardVo;
import kr.ac.sungkyul.smartcan.vo.AttachFileAdVO;

/*
2016-10-04 
 작업자 : 최형민
 개발 상황 : 완료
*/

@Repository
public class AdverCenterDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//게시판 리스트
		public List<AdverBoardVo> getList(int page, int pagesize, String keyword) { 
			Map<String, Object> map=new HashMap<>();

			//키보드가 null or 비어있을 때 리스트 가져오기
			if (keyword == null || "".equals(keyword)) {

				map.put("page_start", (page - 1) * pagesize + 1);
				map.put("page_end", page * pagesize);
				
				List<AdverBoardVo> list=sqlSession.selectList("adver.getList",map);
				return list;
				
			//검색된 리스트 가져오기
			} else {
				map.put("keyword", "%" + keyword + "%");
				map.put("page_start", (page - 1) * pagesize + 1);
				map.put("page_end", page * pagesize);
				
				List<AdverBoardVo> list=sqlSession.selectList("adver.getListKeyword",map);
				return list;
			}
		}

		//게시판 총 개수
		public int getTotalCount() { 

		return sqlSession.selectOne("adver.totalCount");
		}

		//게시판 글쓰기
		public Long insert(AdverBoardVo vo) { 
			sqlSession.insert("adver.insertBoard", vo);
			return vo.getNo();
		}

		//게시판 댓글 달기
		public Long reply(AdverBoardVo vo) { 
			sqlSession.insert("adver.replyBoard", vo);
			return vo.getNo();
		}

		 //첨부파일 삭제
		public void delete(int no, int orderno) {
			Map<String, Object> map=new HashMap<>();
			map.put("no", no);
			map.put("orderno", orderno);
			
			sqlSession.delete("adver.deleteAttachFile",map);
			
		}

		//게시판 삭제
		public void delete(AdverBoardVo vo) { 
			sqlSession.delete("adver.deleteBoard",vo);

		}

		 //게시판 정보 얻기
		public AdverBoardVo get(Long no1) {
			System.out.println(no1);
			AdverBoardVo vo=sqlSession.selectOne("adver.listByNo",no1);
			return vo;
		}

		//조회수 증가
		public void updateViewCount(Long no) { 
			sqlSession.update("adver.updateViewCount",no);
		}

		//게시판 수정
		public void update(AdverBoardVo vo) { 

			sqlSession.update("adver.update",vo);
		}

		 //그룹 내 순서 정렬
		public void updatereplyCount(int groupNo, int orderNo) {
			Map<String, Object> map=new HashMap<>();
			map.put("groupNo", groupNo);
			map.put("orderNo", orderNo);
			
			sqlSession.update("adver.updatereplyCount",map);
		}

		//첨부파일 정보 얻기
		public AttachFileAdVO selectAttachFileByFNO(Long fNO) { 
			return sqlSession.selectOne("adver.selectAttachFileByFNO", fNO);
		}

		//첨부파일 삽입
		public void insertAttachFile(AttachFileAdVO AttachFileAdVO) { 
			sqlSession.insert("adver.insertAttachFile", AttachFileAdVO);
		}

		//해당 첨부파일 번호 가져오기
		public AttachFileAdVO selectAttachFileByNO(Long no) {
			return sqlSession.selectOne("adver.selectAttachFileByNO", no);
		}

		 //첨부파일 그룹번호 반환
		public int getgroupno(AttachFileAdVO vo) {
			sqlSession.selectList("adver.list");
			System.out.println(vo.getGroupno());
			return vo.getGroupno();
		}

		//사용자에게 댓글 달린 것을 확인 하기 위한 객체 얻기
		public AdverBoardVo getList(int groupNo) { 
			
			AdverBoardVo vo=sqlSession.selectOne("adver.ListByGroupNo",groupNo);
			return vo;
		
	}
	
}

