package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.dao.MemberDAOImpl;
import kr.ac.kopo.vo.MemberVO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    System.out.println("로그인 시도: email=" + email + ", password=" + password);

	    if (email == null || password == null) {
	        request.setAttribute("errorMessage", "이메일과 비밀번호를 입력하세요.");
	        return "/jsp/member/login.jsp";
	    }

	    MemberDAO memberDAO = new MemberDAOImpl();
	    MemberVO member = memberDAO.selectMemberByEmail(email);

	    if (member == null) {
	        System.out.println("존재하지 않는 이메일: " + email);
	        request.setAttribute("errorMessage", "존재하지 않는 이메일입니다.");
	        return "/jsp/member/login.jsp";
	    }

	    System.out.println("DB에서 조회된 사용자: " + member);

	    if (!password.equals(member.getPassword())) {
	        System.out.println("비밀번호 불일치: 입력된 비밀번호=" + password + ", DB 비밀번호=" + member.getPassword());
	        request.setAttribute("errorMessage", "비밀번호가 올바르지 않습니다.");
	        return "/jsp/member/login.jsp";
	    }

	    HttpSession session = request.getSession();
	    session.setAttribute("user", member);

	    System.out.println("로그인 성공: 세션에 저장된 사용자 - " + session.getAttribute("user"));

	    response.sendRedirect(request.getContextPath() + "/index.jsp");
	    return null;
	}
}