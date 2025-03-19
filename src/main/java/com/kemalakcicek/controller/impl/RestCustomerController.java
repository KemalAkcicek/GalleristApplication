package com.kemalakcicek.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalakcicek.controller.IRestCustomerController;
import com.kemalakcicek.controller.RootEntity;
import com.kemalakcicek.dto.DtoCustomer;
import com.kemalakcicek.dto.DtoCustomerIU;
import com.kemalakcicek.service.ICustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/rest/api/customer")
public class RestCustomerController extends RestBaseController implements IRestCustomerController {

	@Autowired
	private ICustomerService iCustomerService;
	
	
	@Override
	@PostMapping(path = "/save")
	public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
		
		return ok(iCustomerService.saveCustomer(dtoCustomerIU));
	}

}
