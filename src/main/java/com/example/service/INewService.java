package com.example.service;

import java.util.List;

import com.example.model.NewsModel;

public interface INewService {
	List<NewsModel> findByCategoryId(Long categoryid);
	NewsModel save(NewsModel newmodel);
	NewsModel update(NewsModel updateNew);
	void delete(long[] ids);
	List<NewsModel> findAll(Integer offset, Integer limit);
	int getTotalItem();
}
