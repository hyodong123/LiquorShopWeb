package kr.ac.kopo.dao;

import java.util.List;

import kr.ac.kopo.vo.OrderDetailVO;
import kr.ac.kopo.vo.OrderVO;

public interface OrderDAO {
    Long getNextOrderId();
    void insertOrder(OrderVO order);
    void insertOrderDetail(OrderDetailVO detail);
    List<OrderVO> getOrdersByMemberId(int memberId);
    List<OrderDetailVO> getOrderDetails(Long orderId);
}
