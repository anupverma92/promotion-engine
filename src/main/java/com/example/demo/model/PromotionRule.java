package com.example.demo.model;

import org.springframework.stereotype.Component;

import com.tutorial.businessRule.model.AppConstants;
import com.tutorial.businessRule.model.BusinessRuleModel;

@Component
public class PromotionRule {

	public int calculateValueForPromotionA(BusinessRuleModel bModel) {
		int totalValForSku = (bModel.getCount()/3)*130
		              + (bModel.getCount()%3)*AppConstants.priceOfSkUA;
		
		return totalValForSku;
	}
	
	public int calculateValueForPromotionB(BusinessRuleModel bModel) {
		int totalValForSku = (bModel.getCount()/2)*45 + (bModel.getCount()%2)*AppConstants.priceOfSKUB;
		return totalValForSku;
	}
	
	public int calculateValueForNormal(BusinessRuleModel bModel) {
		int totalValForSku = 0;
		if(bModel.getSKU().equalsIgnoreCase(AppConstants.SKUA))
		   totalValForSku = bModel.getCount()*AppConstants.priceOfSkUA;
		if(bModel.getSKU().equalsIgnoreCase(AppConstants.SKUB))
			totalValForSku = bModel.getCount()*AppConstants.priceOfSKUB;
		if(bModel.getSKU().equalsIgnoreCase(AppConstants.SKUC))
			totalValForSku = bModel.getCount()*AppConstants.priceOfSKUC;
		if(bModel.getSKU().equalsIgnoreCase(AppConstants.SKUD))
			totalValForSku = bModel.getCount()*AppConstants.priceofSKUD;
		
		return totalValForSku;
		
	}
	
	
}
