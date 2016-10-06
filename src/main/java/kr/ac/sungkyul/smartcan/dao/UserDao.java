package kr.ac.sungkyul.smartcan.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.sungkyul.smartcan.vo.PassLinkVo;
import kr.ac.sungkyul.smartcan.vo.UserVo;


@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 회원가입
	public void insert(UserVo vo) {
		 sqlSession.insert("user.insert",vo);
	}
	
	// login
	public UserVo login(String email, String password) {
		
		UserVo userVo = new UserVo();
		userVo.setEmail(email);
		userVo.setPassword(password);
	
		UserVo vo = sqlSession.selectOne("user.login", userVo);
		return vo;
	}
	
	//회원 정보 수정 시 정보 불러오기
	public UserVo get(Long no) {
		
		UserVo vo = sqlSession.selectOne("user.getModify",no);
		System.out.println(vo.toString());
		return vo;
	}
	
	//회원정보 수정  (패스워드 미입력)
	public void update(UserVo vo) {	
		sqlSession.update("user.update",vo);
	}
	
	// 아이디 찾기
	public String find(UserVo vo) { 
		String email = sqlSession.selectOne("user.idFind",vo);
		return email;
	}
	// 비밀번호 찾기
	public String passfind(UserVo vo) {
		String email = sqlSession.selectOne("user.passFind",vo);
		return email;
	}
	
	// 비밀번호 검사
	public void savelink(String link, String email) {
		Long user_no = sqlSession.selectOne("user.checkEmail",email); // no 가져옴
		Integer state = 0;
		
		PassLinkVo passlinkvo = new PassLinkVo();
		passlinkvo.setLink(link);
		passlinkvo.setState(state);
		passlinkvo.setUser_no(user_no);
		
		sqlSession.insert("user.savelink",passlinkvo);
	}
	// 비밀번호 링크 설정
	public PassLinkVo passlink(String link) {
		
		PassLinkVo plVo = sqlSession.selectOne("user.passlink",link); // no 가져옴
		return plVo;
	}
	
	// password 재설정
	public Integer setPass(Long no, String password) {
		
		UserVo userVo = new UserVo();
		userVo.setNo(no);
		userVo.setPassword(password);
		
		Integer result = sqlSession.update("user.setPass",userVo);
		return result;
	}
	
	// password (상태) 재설정
	public void setState(Long user_no, Integer state) { 
		PassLinkVo passlinkvo = new PassLinkVo();
		passlinkvo.setUser_no(user_no);
		passlinkvo.setState(state);
		sqlSession.update("user.setState",passlinkvo);
	}
	
	// email 유효성 검사
	public Long checkEmail(String email) {
		
		Long no = sqlSession.selectOne("user.checkEmail",email);
		return no;
	}
}
