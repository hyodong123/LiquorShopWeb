package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.dao.CartDAO;
import kr.ac.kopo.dao.CartDAOImpl;
import kr.ac.kopo.vo.CartVO;
import kr.ac.kopo.vo.MemberVO;

import java.util.List;

public class CartController implements Controller {

	private final CartDAO cartDAO = new CartDAOImpl();

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    HttpSession session = request.getSession();
	    MemberVO user = (MemberVO) session.getAttribute("user");

	    if (user == null) {
	        request.setAttribute("errorMessage", "로그인이 필요합니다.");
	        return "/jsp/error.jsp";
	    }

	    int memberId = user.getMemberId();
	    String action = request.getParameter("action");

	    // action 값이 null일 경우 자동 설정
	    if ((action == null || action.isEmpty()) && request.getParameter("cartId") != null) {
	        action = "delete";
	        System.out.println("cartId가 존재합니다. action을 'delete'로 설정합니다.");
	    } else if (action == null || action.isEmpty()) {
	        action = "view";
	        System.out.println("action 값이 null입니다. 기본값 'view'로 설정합니다.");
	    }

	    System.out.println("요청된 action 값: " + action);

	    try {
	        switch (action) {
	            case "add":
	                return handleAddToCart(request, response, memberId);
	            case "view":
	                return handleViewCart(request, memberId);
	            case "delete":
	                return handleDeleteFromCart(request, response);
	            case "clear":
	                return handleClearCart(request, response, memberId);
	            default:
	                request.setAttribute("errorMessage", "잘못된 요청입니다.");
	                return "/jsp/error.jsp";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("errorMessage", "오류 발생: " + e.getMessage());
	        return "/jsp/error.jsp";
	    }
	}


	private String handleDeleteFromCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cartIdParam = request.getParameter("cartId");
		System.out.println("Controller - 삭제 요청: cartId = " + cartIdParam);

		if (cartIdParam == null || cartIdParam.isEmpty()) {
			throw new Exception("삭제할 cartId가 비어있습니다.");
		}

		int cartId = Integer.parseInt(cartIdParam);
		cartDAO.deleteFromCart(cartId);
		System.out.println("Controller - 삭제 완료: cartId = " + cartId);

		response.sendRedirect(request.getContextPath() + "/cart/view.do?action=view");
		return null;
	}

	private String handleViewCart(HttpServletRequest request, int memberId) throws Exception {
	    System.out.println("Controller - 장바구니 조회 요청: memberId = " + memberId);

	    List<CartVO> cartList = cartDAO.getCartByMemberId(memberId);
	    
	    // 세션에 cartList 저장
	    HttpSession session = request.getSession();
	    session.setAttribute("cartList", cartList);

	    System.out.println("Controller - 장바구니 조회 완료: " + cartList.size() + "개 항목");

	    // 요청 속성에도 저장 (JSP에서 JSTL을 사용할 경우)
	    request.setAttribute("cartList", cartList);

	    return "/jsp/cart/view.jsp";
	}


	private String handleAddToCart(HttpServletRequest request, HttpServletResponse response, int memberId)
			throws Exception {
		int liquorId = Integer.parseInt(request.getParameter("liquorId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		System.out.println("Controller - 추가 요청: liquorId = " + liquorId + ", quantity = " + quantity);

		CartVO cart = new CartVO();
		cart.setMemberId(memberId);
		cart.setLiquorId(liquorId);
		cart.setQuantity(quantity);

		cartDAO.addToCartOrUpdateQuantity(cart);
		response.sendRedirect(request.getContextPath() + "/cart/view.do?action=view");
		return null;
	}

	private String handleClearCart(HttpServletRequest request, HttpServletResponse response, int memberId)
			throws Exception {
		cartDAO.clearCartByMemberId(memberId);
		response.sendRedirect(request.getContextPath() + "/cart/view.do?action=view");
		return null;
	}

	protected void updateQuantity(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    int cartId = Integer.parseInt(request.getParameter("cartId"));
	    int quantity = Integer.parseInt(request.getParameter("quantity"));

	    // DAO를 통해 수량 업데이트
	    cartDAO.updateCartQuantity(cartId, quantity);

	    // 응답 상태 전송
	    response.setStatus(HttpServletResponse.SC_OK);
	}

}
