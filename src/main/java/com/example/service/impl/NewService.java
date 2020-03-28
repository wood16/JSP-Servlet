package com.example.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.example.dao.INewDAO;
import com.example.model.NewsModel;
import com.example.service.INewService;

public class NewService implements INewService{
	
	@Inject
	private INewDAO newDAO;

	@Override
	public List<NewsModel> findByCategoryId(Long categoryid) {	
		return newDAO.findByCategoryId(categoryid);
	}

	@Override
	public NewsModel save(NewsModel newmodel) {
		newmodel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newmodel.setCreatedBy("");
//		khi save xuong database se tra ve id
		Long newId = newDAO.save(newmodel);
//		tra lai model vua luu vao database bang id
		return newDAO.findOne(newId);
		
	}

	@Override
	public NewsModel update(NewsModel updateNew) {
		NewsModel oldNew = newDAO.findOne(updateNew.getId());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDAO.update(updateNew);
		return newDAO.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
//		Để xóa được New thì phải xóa comment trc, do News-Comment là 1-n
//		1 - n -> Khóa của News sang Comment làm khóa ngoại 
		for(long id:ids) {
			newDAO.delete(id);
		}
		
	}

	@Override
	public List<NewsModel> findAll(Integer offset, Integer limit) {
		return newDAO.findAll(offset, limit);
	}

	@Override
	public int getTotalItem() {
		return newDAO.getTotalItem();
	}
	

}
