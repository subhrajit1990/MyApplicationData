package my.application.entities;

public class ProductResponse {
	private String productName;
	private String productImageUrl;
	private String productImageThumbnailUrl;
	private Float productPrice;
	private String headerTopRightText;
	private String headerTopLeftText;
	private String productCtaText;
	private String productDetails;
	private String productId;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	public String getProductImageThumbnailUrl() {
		return productImageThumbnailUrl;
	}
	public void setProductImageThumbnailUrl(String productImageThumbnailUrl) {
		this.productImageThumbnailUrl = productImageThumbnailUrl;
	}
	public Float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}
	public String getHeaderTopRightText() {
		return headerTopRightText;
	}
	public void setHeaderTopRightText(String headerTopRightText) {
		this.headerTopRightText = headerTopRightText;
	}
	public String getHeaderTopLeftText() {
		return headerTopLeftText;
	}
	public void setHeaderTopLeftText(String headerTopLeftText) {
		this.headerTopLeftText = headerTopLeftText;
	}
	public String getProductCtaText() {
		return productCtaText;
	}
	public void setProductCtaText(String productCtaText) {
		this.productCtaText = productCtaText;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public ProductResponse(String productName, String productImageUrl, String productImageThumbnailUrl,
			Float productPrice, String headerTopRightText, String headerTopLeftText, String productCtaText,
			String productDetails) {
		this.productName = productName;
		this.productImageUrl = productImageUrl;

		this.productImageThumbnailUrl = productImageThumbnailUrl;
		this.productPrice = productPrice;
		this.headerTopRightText = headerTopRightText;
		this.headerTopLeftText = headerTopLeftText;
		this.productCtaText = productCtaText;
		this.productDetails = productDetails;
	}
}
