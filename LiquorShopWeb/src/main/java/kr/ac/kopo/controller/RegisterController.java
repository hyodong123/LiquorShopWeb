package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.dao.MemberDAOImpl;
import kr.ac.kopo.vo.MemberVO;

public class RegisterController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String method = request.getMethod();

        if ("GET".equalsIgnoreCase(method)) {
            // 회원가입 페이지 보여주기
            return "/jsp/member/register.jsp";
        } else if ("POST".equalsIgnoreCase(method)) {
            // 회원가입 데이터 처리
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String username = request.getParameter("username");
            String phoneNumber = request.getParameter("phone");
            String address = request.getParameter("address");
            String socialProvider = request.getParameter("socialProvider");
            String socialAccountId = request.getParameter("socialAccountId");

            // 입력값 검증
            if (email == null || email.isEmpty() || username == null || username.isEmpty()) {
                request.setAttribute("errorMessage", "이메일과 이름은 필수 입력 항목입니다.");
                return "/jsp/error.jsp";
            }

            if ((password == null || password.isEmpty()) &&
                (socialProvider == null || socialProvider.isEmpty() || socialAccountId == null || socialAccountId.isEmpty())) {
                request.setAttribute("errorMessage", "비밀번호 또는 소셜 로그인 정보가 필요합니다.");
                return "/jsp/error.jsp";
            }

            // 비밀번호를 그대로 저장 (해싱 생략)
            // 보안 강화를 위해 추후에 해싱 알고리즘 적용 고려 필요

            // MemberVO 생성
            MemberVO member = new MemberVO();
            member.setEmail(email);
            member.setPassword(password); // 평문 비밀번호 저장
            member.setUsername(username);
            member.setPhoneNumber(phoneNumber);
            member.setAddress(address);
            member.setSocialProvider(socialProvider);
            member.setSocialAccountId(socialAccountId);
            member.setMembershipType("USER");

            MemberDAO memberDAO = new MemberDAOImpl();

            try {
                // 이메일 중복 체크
                if (memberDAO.isEmailDuplicate(email)) {
                    request.setAttribute("errorMessage", "이미 등록된 이메일입니다.");
                    return "/jsp/error.jsp";
                }

                // 소셜 계정 중복 체크
                if (socialProvider != null && !socialProvider.isEmpty() &&
                    socialAccountId != null && !socialAccountId.isEmpty()) {
                    if (memberDAO.isSocialAccountDuplicate(socialProvider, socialAccountId)) {
                        request.setAttribute("errorMessage", "이미 등록된 소셜 계정입니다.");
                        return "/jsp/error.jsp";
                    }
                }

                // 회원 데이터 삽입
                memberDAO.insertMember(member);

            } catch (Exception e) {
                request.setAttribute("errorMessage", "회원가입 처리 중 오류가 발생했습니다: " + e.getMessage());
                return "/jsp/error.jsp";
            }

            // 회원가입 성공 후 로그인 페이지로 리다이렉트
            return "redirect:/member/login.do";
        }

        return "/jsp/error.jsp";
    }
}
