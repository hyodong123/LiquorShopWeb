package kr.ac.kopo.vo;

public class OrderVO {
    private long orderId;        // 주문 ID
    private int memberId;        // 회원 ID
    private int totalPrice;      // 총 금액 (소수점 없음)
    private String shippingAddress; // 배송 주소

    // 기본 생성자
    public OrderVO() {
    }

    // 매개변수 생성자
    public OrderVO(long orderId, int memberId, int totalPrice, String shippingAddress) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.totalPrice = totalPrice;
        this.shippingAddress = shippingAddress;
    }

    // Getter 및 Setter 메서드
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "OrderVO [orderId=" + orderId + ", memberId=" + memberId + ", totalPrice=" + totalPrice
                + ", shippingAddress=" + shippingAddress + "]";
    }
}
