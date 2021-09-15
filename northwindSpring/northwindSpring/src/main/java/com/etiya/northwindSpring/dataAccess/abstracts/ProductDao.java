package com.etiya.northwindSpring.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.northwindSpring.entities.concretes.Product;
import com.etiya.northwindSpring.entities.dtos.ProductDetailDto;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
	
	boolean existsProductByProductName(String productName);
	//isme göre arama getby yada findby yazabilirsiniz
	
	 List<Product> getByProductName(String productName); 
	 List<Product> getByCategory_CategoryId (int categoryId);
	
	 List<Product> getByProductNameAndUnitPrice(String productName, double unitPrice);
	
	  List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	  
	  List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
	  
	  List<Product> getByProductNameContains(String productName);
	  
	  List<Product> getByProductNameStartsWith(String productName);
	  
	  @Query("From Product where productName=:productName and category.categoryId=:categoryId")
	  List<Product> getByNameAndCategory(String productName, int categoryId);
	  
	  @Query("Select new com.etiya.northwindSpring.entities.dtos.ProductDetailDto"
	  		+ "(p.id, p.productName, c.categoryName,p.unitPrice) "
	  		+ "From Category c Inner Join c.products p")
	  List<ProductDetailDto> getProductWithCategoryDetails();
	  
	  int countByCategory_CategoryId(int categoryId);
	  
	  
	 

}
