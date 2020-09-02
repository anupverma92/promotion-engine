package com.example.demo.service;


import com.example.demo.model.ProductsRequest;

public interface ProductsRuleService {

	public Integer calculatePriceForSku(ProductsRequest request);
}
