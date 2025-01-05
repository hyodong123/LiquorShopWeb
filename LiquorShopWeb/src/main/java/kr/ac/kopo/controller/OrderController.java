package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.dao.OrderDAO;
import kr.ac.kopo.dao.OrderDAOImpl;
import kr.ac.kopo.vo.CartVO;
import kr.ac.kopo.vo.OrderDetailVO;
import kr.ac.kopo.vo.OrderVO;
import kr.ac.kopo.vo.MemberVO;

import java.util.List;

public class OrderController implements Controller {

    private final OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        MemberVO user = (MemberVO) session.getAttribute("user");

        if (user == null) {
            request.setAttribute("errorMessage", "로그인이 필요합니다.");
            return "/jsp/error.jsp";
        }

        String action = request.getParameter("action");
        if ("checkout".equals(action)) {
            return handleCheckout(request, response, user.getMemberId());
        } else {
            request.setAttribute("errorMessage", "잘못된 요청입니다.");
            return "/jsp/error.jsp";
        }
    }

    private String handleCheckout(HttpServletRequest request, HttpServletResponse response, int memberId) throws Exception {
        HttpSession session = request.getSession();
        List<CartVO> cartList = (List<CartVO>) session.getAttribute("cartList");

        if (cartList == null || cartList.isEmpty()) {
            request.setAttribute("errorMessage", "장바구니가 비어 있습니다.");
            return "/jsp/error.jsp";
        }

        try {
            // 회원 주소 가져오기
            String memberAddress = orderDAO.getMemberAddressById(memberId);

            // 총 금액 계산
            int totalPrice = cartList.stream()
                                     .mapToInt(cart -> cart.getPrice() * cart.getQuantity())
                                     .sum();

            // 주문 생성
            Long orderId = orderDAO.getNextOrderId();
            OrderVO order = new OrderVO(orderId, memberId, totalPrice, memberAddress);
            orderDAO.insertOrder(order);

            // 주문 상세 추가
            for (CartVO cart : cartList) {
                OrderDetailVO detail = new OrderDetailVO(0L, orderId, cart.getLiquorId(), cart.getQuantity(), cart.getPrice());
                orderDAO.insertOrderDetail(detail);
            }

            // 장바구니 초기화
            session.removeAttribute("cartList");

            // 주문 상세 데이터 조회
            List<OrderDetailVO> orderDetails = orderDAO.getOrderDetails(orderId);
            request.setAttribute("orderDetails", orderDetails);
            request.setAttribute("orderId", orderId);

            return "/jsp/order/success.jsp";

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "주문 처리 중 오류가 발생했습니다.");
            return "/jsp/error.jsp";
        }
    }
}
