package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.controller.ProductsController;
import com.example.demo.model.AppConstants;

import com.example.demo.model.Products;
import com.example.demo.model.ProductsRequest;
import com.example.demo.service.ProductsRuleService;


@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {
	
	@InjectMocks
	ProductsController prodController;
	
	@Mock
	ProductsRuleService prodRuleService;
	
	@Mock
	AppConstants appConstants;
	
	@Test
	public void testForCalculatPrice() {
		ProductsRequest request = new ProductsRequest();
		List<Products> listOfSkus = new ArrayList<Products>();
	    listOfSkus.add(new Products("A", 3));
	    listOfSkus.add(new Products("B" , 5));
	    listOfSkus.add(new Products("C", 1));
	    listOfSkus.add(new Products("D", 1));
	    
	    request.setListOfSku(listOfSkus);
	    System.out.println("listOfSkus:   "+request.getListOfSku());
	    System.out.println(prodController.calculatePriceWithPromotion(request));
	}

}
