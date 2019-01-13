package my.application.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductRequestWrapper {
	@JsonProperty("productRequest")
	private ProductRequest productRequest;

	public ProductRequest getProductRequest() {
		return productRequest;
	}

	public void setProductRequest(ProductRequest productRequest) {
		this.productRequest = productRequest;
	}
	
	
}
