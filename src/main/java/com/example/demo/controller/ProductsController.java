package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ProductsRepo;
import com.example.demo.model.Products;
import com.tutorial.businessRule.model.BusinessRequest;

import io.swagger.annotations.ApiParam;

@Controller
public class ProductsController {
	
	@Autowired
	ProductsRepo productRepo; 
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
@RequestMapping("/products")
public String products(@RequestParam("actioncall") String actions) {
	System.out.println("Action is::  "+actions);
	String toReturn = null;
	if(actions.equalsIgnoreCase("addProduct")) {
		
		toReturn=  "addProduct.jsp";
	}
	
	if(actions.equalsIgnoreCase("getTotalCost")) {
		toReturn = "getTotalCost.jsp";
	}
	System.out.println("to Return :   "+toReturn);
	return toReturn;
	
}

@RequestMapping("/addProduct")
public String addProduct(Products cust) {
	
	productRepo.save(cust);
	return "addCustomer.jsp";

}

@PostMapping("/calculateTotalPrice"){
	public ResponseEntity<Integer> calculatePriceWithPromotion(@RequestBody com.example.demo.model.BusinessRequest request){
		int totalCalculateForSku = 0;
		if(request!=null) {
			totalCalculateForSku = ruleService.calculatePriceForSku(request);
			return new ResponseEntity<>(totalCalculateForSku,HttpStatus.OK);
	 	}else
	 		return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
	}
}





}
