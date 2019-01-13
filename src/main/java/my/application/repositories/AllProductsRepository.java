package my.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import my.application.entity.Product;



public interface AllProductsRepository extends CrudRepository<Product, Integer> {
	@Query("SELECT  NEW my.application.entities.ProductResponse(p.productName,pImage.productImageUrl,pImage.productImageThumbnailUrl,p.productPrice,p.headerTopRightText,p.headerTopLeftText,p.productCtaText,p.productDetails) FROM Product p JOIN p.productImage pImage") 
	List<Object> fetchAll();
}
