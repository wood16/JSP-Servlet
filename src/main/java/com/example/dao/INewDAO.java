package com.example.dao;

import java.util.List;

import com.example.model.NewsModel;

public interface INewDAO extends GenericDAO<NewsModel>{
	List<NewsModel> findByCategoryId(Long categoryId);
	Long save(NewsModel newmodel);
	NewsModel findOne(Long id);
	void update(NewsModel updateNew);
	void delete(long id);
	List<NewsModel> findAll(Integer offset, Integer limit);
	int getTotalItem();
}
