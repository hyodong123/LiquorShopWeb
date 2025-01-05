package kr.ac.kopo.dao;

import kr.ac.kopo.vo.CartVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;
import java.util.Map;

public class CartDAOImpl implements CartDAO {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "kr/ac/kopo/mybatis/mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("SqlSessionFactory 초기화 실패: " + e.getMessage());
        }
    }

    @Override
    public void deleteFromCart(int cartId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            System.out.println("DAO - 삭제 실행: cartId = " + cartId);

            int deletedRows = session.delete("CartMapper.deleteFromCart", cartId);
            System.out.println("DAO - 삭제 완료: 삭제된 행 수 = " + deletedRows);

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CartVO> getCartByMemberId(int memberId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("CartMapper.getCartByMemberId", memberId);
        }
    }

    @Override
    public void addToCartOrUpdateQuantity(CartVO cart) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int updatedRows = session.update("CartMapper.updateCartQuantityIfExists", cart);
            if (updatedRows == 0) {
                session.insert("CartMapper.addToCart", cart);
            }
            session.commit();
        }
    }

    @Override
    public void clearCartByMemberId(int memberId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("CartMapper.clearCartByMemberId", memberId);
            session.commit();
        }
    }

    @Override
    public void updateCartQuantity(int cartId, int change) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("CartMapper.updateCartQuantity", Map.of("cartId", cartId, "change", change));
            session.commit();
        }
    }
}
