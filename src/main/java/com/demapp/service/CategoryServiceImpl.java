/**
 * 
 */
package com.demapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demapp.model.Category;
import com.demapp.repository.CategoryRepository;

/**
 * @author muthu_m
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category addOrUpdateCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Long id) {
		Category category = categoryRepository.findOne(id);
		if (category != null) {
			categoryRepository.delete(category);
		}
	}

	@Override
	public Category getCategoryByID(Long id) {
		Category category = categoryRepository.findOne(id);
		if (category != null) {
			return category;
		}
		return null;
	}

	@Override
	public List<Category> getCategoryByName(String name) {
		List<Category> categories = categoryRepository.findByName(name);
		if(categories.isEmpty()){
			return null;
		}
		return categories;
	}

}
