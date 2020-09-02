package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductsRequest implements Serializable {

private static final long serialVersionUID = 1L;
private List<Products>	listOfSku;

public List<Products> getListOfSku() {
	return listOfSku;
}

public void setListOfSku(List<Products> listOfSku) {
	this.listOfSku = listOfSku;
}
}
