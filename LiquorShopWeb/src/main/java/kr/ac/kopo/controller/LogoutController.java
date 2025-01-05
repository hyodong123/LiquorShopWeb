package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false); // 세션이 없으면 null 반환
        if (session != null) {
            session.invalidate(); // 세션 무효화 (로그아웃)
        }
        // 메인 페이지로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return null; // 리다이렉트 후 반환값 필요 없음
    }
}
