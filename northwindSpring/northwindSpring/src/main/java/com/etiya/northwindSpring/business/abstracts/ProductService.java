package com.etiya.northwindSpring.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.etiya.northwindSpring.core.utilities.results.DataResult;
import com.etiya.northwindSpring.core.utilities.results.Result;
import com.etiya.northwindSpring.entities.concretes.Product;
import com.etiya.northwindSpring.entities.dtos.ProductDetailDto;

public interface ProductService {

	DataResult<List<Product>> getAll();

	DataResult<List<Product>> getByProductName(String productName);

	DataResult<Product> getById(int id);

	DataResult<List<Product>> getByCategory(int categoryId);

	DataResult<List<Product>> getByProductNameAndUnitPrice(String productName, double unitPrice);

	DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

	@Query("Select new com.etiya.northwindSpring.entities.dtos.ProductDetailDto"
			+ "(p.id, p.productName, c.categoryName) " + "From Category c Inner Join c.products p")
	DataResult<List<ProductDetailDto>> getProductWithCategoryDetails();
	
	Result add(Product product);

}
