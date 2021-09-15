package com.etiya.northwindSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwindSpring.business.abstracts.CategoryService;
import com.etiya.northwindSpring.core.utilities.business.BusinessRules;
import com.etiya.northwindSpring.core.utilities.results.ErrorResult;
import com.etiya.northwindSpring.core.utilities.results.Result;
import com.etiya.northwindSpring.core.utilities.results.SuccessResult;
import com.etiya.northwindSpring.dataAccess.abstracts.CategoryDao;
import com.etiya.northwindSpring.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService {

	private CategoryDao categoryDao;

	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> getAll() {
		return this.categoryDao.findAll();
	}

	@Override
	public Result add(Category category) {
		
		var result=BusinessRules.run(categorynameCheck(category.getCategoryName()),
				checkCategoryCount());
		
		if(result!=null)
		{
			return result;
		}
		
		
		
		this.categoryDao.save(category);
		return new SuccessResult("Kategori eklendi");
	}

	private Result categorynameCheck(String categoryName) {

		if (this.categoryDao.existsCategoryByCategoryName(categoryName)) {
			return new ErrorResult("Böyle bir kategori mevcut");
		}

		return new SuccessResult();

	}

	private Result checkCategoryCount() {

		if (this.categoryDao.count() > 15) {
			return new ErrorResult(" Kategori sayısı 15 geçemez.");
		}

		return new SuccessResult();
	}

	@Override
	public Result update(Category category) {
		
		this.categoryDao.save(category);
		
		return new SuccessResult("Kategori güncellendi.");
		
	}

}
