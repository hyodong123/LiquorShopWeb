package kr.ac.kopo.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.vo.OrderDetailVO;
import kr.ac.kopo.vo.OrderVO;

public class OrderDAOImpl implements OrderDAO {

    private final SqlSessionFactory sqlSessionFactory;

    public OrderDAOImpl() {
        this.sqlSessionFactory = MyConfig.getSqlSessionFactory();
    }

    @Override
    public Long getNextOrderId() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) { // 자동 커밋 활성화
            return session.selectOne("OrderMapper.getNextOrderId");
        }
    }

    @Override
    public void insertOrder(OrderVO order) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) { // 자동 커밋 활성화
            session.insert("OrderMapper.insertOrder", order);
        }
    }

    @Override
    public void insertOrderDetail(OrderDetailVO detail) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) { // 자동 커밋 활성화
            session.insert("OrderMapper.insertOrderDetail", detail);
        }
    }

    @Override
    public List<OrderVO> getOrdersByMemberId(int memberId) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) { // 자동 커밋 활성화
            return session.selectList("OrderMapper.getOrdersByMemberId", memberId);
        }
    }

    @Override
    public List<OrderDetailVO> getOrderDetails(Long orderId) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) { // 자동 커밋 활성화
            return session.selectList("OrderMapper.getOrderDetails", orderId);
        }
    }
}
