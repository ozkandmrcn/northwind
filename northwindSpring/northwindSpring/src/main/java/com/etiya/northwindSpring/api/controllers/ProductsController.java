package com.etiya.northwindSpring.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwindSpring.business.abstracts.ProductService;
import com.etiya.northwindSpring.core.utilities.results.DataResult;
import com.etiya.northwindSpring.core.utilities.results.Result;
import com.etiya.northwindSpring.entities.concretes.Product;
import com.etiya.northwindSpring.entities.dtos.ProductDetailDto;

@RestController 
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
	
	private ProductService  productService;
	
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	
	@GetMapping("/getall")
	public DataResult< List<Product>> getall()
	{
	
		return this.productService.getAll();
		
		
	}
	
	@GetMapping("/getbyproductname")
	public  DataResult<List<Product>> getbyproductname(String productName )
	{
		//List<Product> products=this.prod
	
		return this.productService.getByProductName(productName);
	
	}
	
	@GetMapping("/getbyid")
	public DataResult< Product> getById(int id )
	{
	
		return this.productService.getById(id);
		
		
	}
	

	@GetMapping("/getbycategory")
	public DataResult< List<Product>> getByCategory(int categoryId )
	{
	
		return this.productService.getByCategory(categoryId);
		
		
	}
	
	@GetMapping("/getbyproductnameandunitprice")
	public DataResult< List<Product>> getByProductNameAndUnitPrice(String productName, double unitPrice )
	{
	
		return this.productService.getByProductNameAndUnitPrice(productName,unitPrice);
		
		
	}
	
	@GetMapping("/getByproductnameorcategory")
	public DataResult< List<Product>> getByProductNameOrCategory(String productName, int categoryId)
	{
	
		return this.productService.getByProductNameOrCategory(productName,categoryId);
		
		
	}
	@GetMapping("/getByCategoryin")
	public DataResult< List<Product>> getByCategoryIn(List<Integer> categories )
	{
		List<Integer> params=new ArrayList<Integer>();
		
		for (Integer category : categories) {
			
			params.add(category);
			
		}
	
		return this.productService.getByCategoryIn(params);
		
		
	}
	@GetMapping("/getByProductNamecontains")
	public DataResult< List<Product>> getByProductNameContains(String productName)
	{
	
		return this.productService.getByProductNameContains(productName);
		
		
	}
	
	@GetMapping("/getByProductNamestartswith")
	public DataResult< List<Product>> getByProductNameStartsWith(String productName )
	{
	
		return this.productService.getByProductNameStartsWith(productName);
		
		
	}
	
	@GetMapping("/getByNameAndCategory")
	public DataResult< List<Product>> getByNameAndCategory(String productName,int categoryId)
	{
	
		return this.productService.getByNameAndCategory(productName,categoryId);
		
		
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult< List<ProductDetailDto>> getProductWithCategoryDetails()
	{
	
		return this.productService.getProductWithCategoryDetails();
		
		
	}
	
	@PostMapping("/postproductadd")
	public Result add(Product product)
	{
		return this.productService.add(product);
	}
	


}
