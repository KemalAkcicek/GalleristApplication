package com.kemalakcicek.controller;

import com.kemalakcicek.dto.DtoCustomer;
import com.kemalakcicek.dto.DtoCustomerIU;

public interface IRestCustomerController {

	public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);

}
