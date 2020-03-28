package com.example.dao.impl;

import java.util.List;

import com.example.dao.ICategoryDAO;
import com.example.mapper.CategoryMapper;
import com.example.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{
	
	@Override
	public List<CategoryModel> findAll() {	
		String sql = "SELECT * FROM category";	
		return query(sql, new CategoryMapper());
	}
}
