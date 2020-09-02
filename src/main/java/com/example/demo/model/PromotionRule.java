package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class PromotionRule {

	public int calculateValueForPromotionA(Products bModel) {
		int totalValForSku = (bModel.getCount()/3)*130
		              + (bModel.getCount()%3)*AppConstants.priceOfSkUA;
		
		return totalValForSku;
	}
	
	public int calculateValueForPromotionB(Products bModel) {
		int totalValForSku = (bModel.getCount()/2)*45 + (bModel.getCount()%2)*AppConstants.priceOfSKUB;
		return totalValForSku;
	}
	
	public int calculateValueForNormal(Products bModel) {
		int totalValForSku = 0;
		if(bModel.getSku().equalsIgnoreCase(AppConstants.SKUA))
		   totalValForSku = bModel.getCount()*AppConstants.priceOfSkUA;
		if(bModel.getSku().equalsIgnoreCase(AppConstants.SKUB))
			totalValForSku = bModel.getCount()*AppConstants.priceOfSKUB;
		if(bModel.getSku().equalsIgnoreCase(AppConstants.SKUC))
			totalValForSku = bModel.getCount()*AppConstants.priceOfSKUC;
		if(bModel.getSku().equalsIgnoreCase(AppConstants.SKUD))
			totalValForSku = bModel.getCount()*AppConstants.priceofSKUD;
		
		return totalValForSku;
		
	}
	
	
}
