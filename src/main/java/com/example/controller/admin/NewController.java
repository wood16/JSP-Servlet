package com.example.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.constant.SystemConstant;
import com.example.model.NewsModel;
import com.example.service.INewService;
import com.example.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private INewService newService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsModel model = FormUtil.toModel(NewsModel.class, request);
		
		Integer offset = (model.getPage() - 1)*model.getMaxPageItem();
		model.setListResult(newService.findAll(offset, model.getMaxPageItem()));
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/new/list.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
