package com.tkbaru.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tkbaru.common.RandomProvider;
import com.tkbaru.dao.ProductDAO;
import com.tkbaru.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;

	@Autowired
	ServletContext servletContext;
	
	@Override
	@Transactional
	public List<Product> getAllProduct() {
		
		return productDAO.getAllProduct();
	}

	@Override
	@Transactional
	public Product getProductById(int selectedId) {
		
		return productDAO.getProductById(selectedId);
	}

	@Override
	@Transactional
	public void addProduct(Product product) {
		try {
			String path = servletContext.getRealPath("/") +  "resources\\images\\product\\";
			RandomProvider rndm = new RandomProvider();			
			String fileName = Integer.toString(product.getProductId()) + "-" + product.getProductName() + "-" + rndm.generateRandomInString() + ".jpg"; 			
			product.getImageBinary().transferTo(new File(path + fileName).getAbsoluteFile());
			
			product.setImagePath(fileName);
			
			productDAO.addProduct(product);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void editProduct(Product product) {
		
		productDAO.editProduct(product);
	}

	@Override
	@Transactional
	public void deleteProduct(int selectedId) {

		productDAO.deleteProduct(selectedId);		
	}

	@Override
	public List<Product> getProductByIds(String selectedIds) {
		
		if (selectedIds.length() == 0) return new ArrayList<Product>();
		
		return productDAO.getProductByIds(selectedIds);
	}

	@Override
	@Transactional
	public List<Product> getProductHasInStock() {
		
		return productDAO.getProductHasInStock();
	}

}
