package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductsRepo;
import com.example.demo.model.Products;
import com.example.demo.model.ProductsRequest;
import com.example.demo.service.ProductsRuleService;



@Controller
public class ProductsController {
	
	@Autowired
	ProductsRepo productRepo; 
	
	@Autowired
	ProductsRuleService ruleService;
	
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
public String addProduct(Products products) {
	
	productRepo.save(products);
	return "addCustomer.jsp";

}

	@PostMapping(value ="/calculateTotalPrice", produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Integer> calculatePriceWithPromotion(@RequestBody ProductsRequest request){
		int totalCalculateForSku = 0;
		if(request!=null) {
			System.out.println("request is not null");
			System.out.println("reuest .get ist of sku:   "+ request.getListOfSku().toString());
			totalCalculateForSku = ruleService.calculatePriceForSku(request);
			return new ResponseEntity<>(totalCalculateForSku,HttpStatus.OK);
	 	}else
	 		return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
	}
}


