package com.niit.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.model.Supplier;

@Controller
public class HomeController {

	@RequestMapping("/")

/*public String home(){              //navigate without carrying data
	return "/Home";
}*/
public ModelAndView home(){                //navigate with carrying data
	
ModelAndView mv= new ModelAndView("Home");
mv.addObject("message","Hello");
return mv;
	}
	
	
	/*@RequestMapping("/registration")
	public ModelAndView registration(){
		ModelAndView mv=new ModelAndView("registration");
		mv.addObject("UserClickedRegister","true");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView mv =new ModelAndView("login");
		mv.addObject("UserClickedLogin","true");
		return mv;
	}
	@RequestMapping("/Supplier")
	public ModelAndView supplier(){
		ModelAndView mv =new ModelAndView("Home");
		mv.addObject("UserClickedsupplier","true");
		return mv;
}*/
	
}

