package kr.ac.kopo.vo;

public class OrderDetailVO {
    private long orderDetailId; // 상세 ID (PK)
    private long orderId;       // 주문 ID (FK)
    private int liquorId;       // 주류 ID
    private int quantity;       // 수량
    private int price;          // 가격 (소수점 없음)

    // 기본 생성자
    public OrderDetailVO() {
    }

    // 매개변수 생성자
    public OrderDetailVO(long orderDetailId, long orderId, int liquorId, int quantity, int price) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.liquorId = liquorId;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter 및 Setter 메서드
    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getLiquorId() {
        return liquorId;
    }

    public void setLiquorId(int liquorId) {
        this.liquorId = liquorId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetailVO [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", liquorId=" + liquorId
                + ", quantity=" + quantity + ", price=" + price + "]";
    }
}
