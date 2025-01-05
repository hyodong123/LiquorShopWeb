package kr.ac.kopo.vo;

public class CartVO {
    private int cartId;
    private int memberId;
    private int liquorId;
    private int quantity;

    // 추가된 필드
    private String liquorName;
    private int price; // 추가: 단가
    private int totalPrice; // 추가: 총 가격

    // Getter와 Setter 메서드 추가
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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

    public String getLiquorName() {
        return liquorName;
    }

    public void setLiquorName(String liquorName) {
        this.liquorName = liquorName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
