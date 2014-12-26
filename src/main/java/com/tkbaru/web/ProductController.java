package com.tkbaru.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tkbaru.common.Constants;
import com.tkbaru.model.Product;
import com.tkbaru.service.LookupService;
import com.tkbaru.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productManager;
	
	@Autowired
	LookupService lookupManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public String productPageLoad(Locale locale, Model model) {
		logger.info("[productPageLoad] : " + "");
		
		model.addAttribute("productList", productManager.getAllProduct());
		
		model.addAttribute(Constants.PAGEMODE, Constants.PAGEMODE_PAGELOAD);
		model.addAttribute(Constants.ERRORFLAG, Constants.ERRORFLAG_HIDE);

		return Constants.JSPPAGE_PRODUCT;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addProduct(Locale locale, Model model) {
		logger.info("[addProduct] : " + "");
		
		model.addAttribute("productForm", new Product());
		model.addAttribute("productTypeDDL", lookupManager.getLookupByCategory(Constants.LOOKUPCATEGORY_PRODUCT_TYPE));
		model.addAttribute("unitDDL", lookupManager.getLookupByCategory(Constants.LOOKUPCATEGORY_UNIT));
		model.addAttribute("statusDDL", lookupManager.getLookupByCategory(Constants.LOOKUPCATEGORY_STATUS));
		
		model.addAttribute(Constants.PAGEMODE, Constants.PAGEMODE_ADD);
		model.addAttribute(Constants.ERRORFLAG, Constants.ERRORFLAG_HIDE);
	
		return Constants.JSPPAGE_PRODUCT;
	}
	
	@RequestMapping(value = "/edit/{selectedId}.html", method = RequestMethod.GET)
	public String editProduct(Locale locale, Model model, @PathVariable Integer selectedId) {
		logger.info("[editProduct] " + "selectedId = " + selectedId);
			
		Product selectedProduct = productManager.getProductById(selectedId);
		
		model.addAttribute("productForm", selectedProduct);
		model.addAttribute("productTypeDDL", lookupManager.getLookupByCategory(Constants.LOOKUPCATEGORY_PRODUCT_TYPE));
		model.addAttribute("unitDDL", lookupManager.getLookupByCategory(Constants.LOOKUPCATEGORY_UNIT));
		model.addAttribute("statusDDL", lookupManager.getLookupByCategory(Constants.LOOKUPCATEGORY_STATUS));
		
		model.addAttribute(Constants.PAGEMODE, Constants.PAGEMODE_EDIT);
		model.addAttribute(Constants.ERRORFLAG, Constants.ERRORFLAG_HIDE);

		return Constants.JSPPAGE_PRODUCT;
	}
	
	@RequestMapping(value = "/delete/{selectedId}.html", method = RequestMethod.GET)
	public String deleteProduct(Locale locale, Model model, @PathVariable Integer selectedId) {
		logger.info("[deleteProduct] : " + "");

		productManager.deleteProduct(selectedId);
		
		model.addAttribute(Constants.PAGEMODE, Constants.PAGEMODE_DELETE);
		model.addAttribute(Constants.ERRORFLAG, Constants.ERRORFLAG_HIDE);

		return Constants.JSPPAGE_REDIRECT_TO + Constants.JSPPAGE_PRODUCT;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveProduct(Locale locale, Model model, @ModelAttribute("productForm") Product prod) {	
		logger.info("[saveProduct] : " + "");
	
		if (prod.getProductId() == 0) { productManager.addProduct(prod); }
		else { productManager.editProduct(prod); }
		
		model.addAttribute(Constants.PAGEMODE, Constants.PAGEMODE_LIST);
		model.addAttribute(Constants.ERRORFLAG, Constants.ERRORFLAG_HIDE);

		return Constants.JSPPAGE_REDIRECT_TO + Constants.JSPPAGE_PRODUCT;
	}
}
