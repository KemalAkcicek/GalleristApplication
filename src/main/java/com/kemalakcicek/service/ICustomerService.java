package com.kemalakcicek.service;

import com.kemalakcicek.dto.DtoCustomer;
import com.kemalakcicek.dto.DtoCustomerIU;

public interface ICustomerService {

	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);

}
