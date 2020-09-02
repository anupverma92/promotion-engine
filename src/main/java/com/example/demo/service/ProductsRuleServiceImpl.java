package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AppConstants;
import com.example.demo.model.Products;
import com.example.demo.model.ProductsRequest;
import com.example.demo.model.PromotionRule;


@Service
public class ProductsRuleServiceImpl implements ProductsRuleService {

	@Autowired
	private PromotionRule promoRule;

	public Integer calculatePriceForSku(ProductsRequest request) {
		List<Products> listOfSkus = request.getListOfSku();
		System.out.println("listOfSkus in cacalculatePriceForSkul:   "+listOfSkus.toString());
		
		int totalPriceOfSku = 0;
		
		boolean isPromotionForC = listOfSkus.stream()
				.anyMatch(model -> model.getSku().equalsIgnoreCase(AppConstants.SKUC));
				
		boolean isPromotionForD = 	listOfSkus.stream()
				.anyMatch(model -> model.getSku().equalsIgnoreCase(AppConstants.SKUD));		
		
		System.out.println("isPromotionForC:    "+isPromotionForC);
		System.out.println("isPromotionForD:    "+isPromotionForD );
		
		if (isPromotionForC && isPromotionForD) {
			totalPriceOfSku += 30;
			listOfSkus.removeIf(model -> model.getSku().equalsIgnoreCase(AppConstants.SKUC));
			listOfSkus.removeIf(model -> model.getSku().equalsIgnoreCase(AppConstants.SKUD));
		}
		System.out.println("totalPriceOfSku  1 :   "+totalPriceOfSku);
		for (Products model : listOfSkus) {
			if (model.getSku().equalsIgnoreCase(AppConstants.SKUA) && model.getCount() >= 3) {
				totalPriceOfSku += promoRule.calculateValueForPromotionA(model);
			}
			else if (model.getSku().equalsIgnoreCase(AppConstants.SKUB) && model.getCount() >= 2) {
				totalPriceOfSku += promoRule.calculateValueForPromotionB(model);
			} else {
				totalPriceOfSku += promoRule.calculateValueForNormal(model);
			}

		}
		return totalPriceOfSku;
	}

}
