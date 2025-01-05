package kr.ac.kopo.dao;

import java.util.List;
import kr.ac.kopo.vo.CartVO;

public interface CartDAO {
    void addToCartOrUpdateQuantity(CartVO cartVO);

    List<CartVO> getCartByMemberId(int memberId);

    void deleteFromCart(int cartId);

    void clearCartByMemberId(int memberId);

	void updateCartQuantity(int cartId, int change);
}
