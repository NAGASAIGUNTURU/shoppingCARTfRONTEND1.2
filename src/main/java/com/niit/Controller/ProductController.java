package com.niit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO productDAO;

	@Autowired
	Product product;
	
	
	
	@RequestMapping(value={"editproduct","addeditproduct/{id}/editproduct"})
	public String editproduct(@ModelAttribute("Product") Product product,  Model m){
		productDAO.saveOrUpdate(product);
		return "redirect:/Product";
	}
@RequestMapping(value ="Product" )
	public ModelAndView ProductPage(@ModelAttribute("Product") Product product,BindingResult result,
			@ModelAttribute("Product") Product product1,BindingResult result1) {
		ModelAndView mv= new ModelAndView("/Admin");
		//mv.addObject("product", new Product());
		mv.addObject("productList", productDAO.list());
		mv.addObject("UserClickedproduct", "true");
		return mv;
	}
@RequestMapping(value ={"addeditproduct/{id}"} )
public String ProductPageedit(@PathVariable("id") String id,RedirectAttributes attributes) {
	attributes.addFlashAttribute("Product", this.productDAO.get(id));
	return "redirect:/Product";
}
@RequestMapping(value ={"adddeleteproduct/{id}"} )
public String ProductPagedelete(@ModelAttribute("Product") Product product,Model m) {
	//attributes.addFlashAttribute("product2", this.productDAO.get(id));
	productDAO.delete(product);
	return "redirect:/Product";
	
}

}