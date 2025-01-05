package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.dao.MemberDAOImpl;
import kr.ac.kopo.vo.MemberVO;

public class MyPageController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        MemberVO user = (MemberVO) session.getAttribute("user");

        // 로그인 확인
        if (user == null) {
            request.setAttribute("errorMessage", "로그인이 필요합니다.");
            return "/jsp/error.jsp";
        }

        String action = request.getParameter("action");

        // action 값이 null인 경우 기본 동작 설정
        if (action == null || action.trim().isEmpty()) {
            action = "viewProfile";  // 기본 동작
        }

        System.out.println("Received action: " + action);

        if ("viewProfile".equals(action)) {
            return handleViewProfile(request, user);
        } else if ("updateProfile".equals(action)) {
            return handleUpdateProfile(request, user);
        }

        request.setAttribute("errorMessage", "잘못된 요청입니다.");
        return "/jsp/error.jsp";
    }

    // 프로필 보기
    private String handleViewProfile(HttpServletRequest request, MemberVO user) throws Exception {
        System.out.println("Fetching profile for user ID: " + user.getMemberId());

        MemberDAO memberDAO = new MemberDAOImpl();
        MemberVO member = memberDAO.selectMemberById(user.getMemberId());

        if (member == null) {
            request.setAttribute("errorMessage", "회원 정보를 불러오는 데 실패했습니다.");
            return "/jsp/error.jsp";
        }

        request.setAttribute("member", member);
        System.out.println("Profile data fetched: " + member);
        return "/jsp/member/viewProfile.jsp";
    }

    // 프로필 수정
    private String handleUpdateProfile(HttpServletRequest request, MemberVO user) throws Exception {
        // 폼에서 전송된 데이터 처리
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");

        System.out.println("Updating profile for user ID: " + user.getMemberId());
        System.out.println("New values - username: " + username + ", email: " + email + ", phoneNumber: " + phoneNumber + ", address: " + address);

        MemberDAO memberDAO = new MemberDAOImpl();
        MemberVO member = new MemberVO();
        member.setMemberId(user.getMemberId());
        member.setUsername(username);
        member.setEmail(email);
        member.setPhoneNumber(phoneNumber);
        member.setAddress(address);

        // 업데이트 수행
        memberDAO.updateMemberProfile(member);

        // 세션 갱신
        HttpSession session = request.getSession();
        session.setAttribute("user", member);

        request.setAttribute("successMessage", "프로필 수정이 완료되었습니다.");
        System.out.println("Profile updated: " + member);

        return "/jsp/member/viewProfile.jsp";
    }
}
