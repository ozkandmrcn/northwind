package com.etiya.northwindSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwindSpring.business.abstracts.ProductService;
import com.etiya.northwindSpring.core.utilities.business.BusinessRules;
import com.etiya.northwindSpring.core.utilities.results.DataResult;
import com.etiya.northwindSpring.core.utilities.results.ErrorResult;
import com.etiya.northwindSpring.core.utilities.results.Result;
import com.etiya.northwindSpring.core.utilities.results.SuccessDataResult;
import com.etiya.northwindSpring.core.utilities.results.SuccessResult;
import com.etiya.northwindSpring.dataAccess.abstracts.ProductDao;
import com.etiya.northwindSpring.entities.concretes.Product;
import com.etiya.northwindSpring.entities.dtos.ProductDetailDto;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}



	@Override
	public DataResult<List<Product>> getAll() {
		
		List<Product> products=this.productDao.findAll();
		
		return new SuccessDataResult<List<Product>>(products, " Ürünler başarıyla listelendi.");
	}



	@Override
	public DataResult<List<Product>> getByProductName(String productName) {

		List<Product> products=this.productDao.getByProductName(productName);
		
		return new SuccessDataResult<List<Product>>(products, " Ürünler başarıyla listelendi.");
	}



	@Override
	public DataResult<Product> getById(int id) {
		Product product=this.productDao.findById(id).get();
		return new SuccessDataResult<Product>(product,"Ürün listelendi");
	}



	@Override
	public DataResult<List<Product>> getByCategory(int categoryId) {

		List<Product> products=this.productDao.getByCategory_CategoryId(categoryId);
		
		return new SuccessDataResult<List<Product>>(products, " Ürünler başarıyla listelendi.");
	}



	@Override
	public DataResult<List<Product>> getByProductNameAndUnitPrice(String productName, double unitPrice) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
	List<Product> products=this.productDao.getByCategory_CategoryIdIn(categories);
		
		return new SuccessDataResult<List<Product>>(products, " Ürünler başarıyla listelendi.");
	}



	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		
	    List<Product> products=this.productDao.getByNameAndCategory(productName, categoryId);
		
		return new SuccessDataResult<List<Product>>(products, " Ürünler başarıyla listelendi.");
	}



	@Override
	public DataResult<List<ProductDetailDto>> getProductWithCategoryDetails() {
		
	    List<ProductDetailDto> products=this.productDao.getProductWithCategoryDetails();
		
		return new SuccessDataResult<List<ProductDetailDto>>(products, " Ürünler başarıyla listelendi.");
	}



	@Override
	public Result add(Product product) {
		
		var result=BusinessRules.run(productnameCheck(product.getProductName()),
				checkProductCountInCategory(product.getCategory().getCategoryId()));
		
		if(result!=null)
		{
			return result;
		}
		
		
		  this.productDao.save(product);
		  
		  return new  SuccessResult ("ürün başarılı bir şekilde eklendi");
		  
		
	}
	
	private Result productnameCheck( String productName)
	{
		
		
		  
		  if(this.productDao.existsProductByProductName(productName))
		  {
			  return new ErrorResult("Böyle bir ürün varmış!!!!!");
		  }
		  
		  return new SuccessResult();
		
		
		
	}
	
	private Result checkProductCountInCategory(int categoryId)
	{
		 
		  if(this.productDao.countByCategory_CategoryId(categoryId)>10)
		  {
			  return new ErrorResult(" Ürün sayısı 10 geçemez.");
		  }
		  
		  return new SuccessResult();
	}



}
