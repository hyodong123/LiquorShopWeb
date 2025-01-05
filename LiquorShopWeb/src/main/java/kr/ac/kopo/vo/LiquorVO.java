package kr.ac.kopo.vo;

public class LiquorVO {
	private int liquorId;
	private String name;
	private String category;
	private double price;
	private int stock;
	private String createdDate;
	private String updatedDate;
	private String imageUrl;
	
	public int getLiquorId() {
		return liquorId;
	}

	public void setLiquorId(int liquorId) {
		this.liquorId = liquorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "LiquorVO [liquorId=" + liquorId + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", stock=" + stock + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", imageUrl="
				+ imageUrl + "]";
	}
}
