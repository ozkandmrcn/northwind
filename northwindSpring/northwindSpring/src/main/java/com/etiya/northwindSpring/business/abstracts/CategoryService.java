package com.etiya.northwindSpring.business.abstracts;

import java.util.List;

import com.etiya.northwindSpring.core.utilities.results.Result;
import com.etiya.northwindSpring.entities.concretes.Category;


public interface CategoryService {
	
	List<Category> getAll();
	//List<Category> getByCategoryName(String categoryName); 
	Result add(Category category);
	Result update(Category category);

}
