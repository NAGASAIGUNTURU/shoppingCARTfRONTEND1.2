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

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierDAO supplierDAO;

	@Autowired
	Supplier supplier;
	
	
	
	@RequestMapping(value={"editsupplier","addeditsupplier/{id}/editsupplier"})
	public String editsupplier(@ModelAttribute("Supplier") Supplier supplier,  Model m){
		supplierDAO.saveOrUpdate(supplier);
		return "redirect:/Supplier";
	}
@RequestMapping(value ="Supplier" )
	public ModelAndView SupplierPage(@ModelAttribute("Supplier") Supplier supplier,BindingResult result,
			@ModelAttribute("Supplier") Supplier supplier1,BindingResult result1) {
		ModelAndView mv= new ModelAndView("/Admin");
		//mv.addObject("supplier", new Supplier());
		mv.addObject("supplierList", supplierDAO.list());
		mv.addObject("UserClickedsupplier", "true");
		return mv;
	}
@RequestMapping(value ={"addeditsupplier/{id}"} )
public String SupplierPageedit(@PathVariable("id") String id,RedirectAttributes attributes) {
	attributes.addFlashAttribute("Supplier", this.supplierDAO.get(id));
	return "redirect:/Supplier";
}
@RequestMapping(value ={"adddeletesupplier/{id}"} )
public String SupplierPagedelete(@ModelAttribute("Supplier") Supplier supplier,Model m) {
	//attributes.addFlashAttribute("supplier2", this.supplierDAO.get(id));
	supplierDAO.delete(supplier);
	return "redirect:/Supplier";
	
}

}