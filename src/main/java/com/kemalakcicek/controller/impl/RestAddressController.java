package com.kemalakcicek.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalakcicek.controller.IRestAddressController;
import com.kemalakcicek.controller.RootEntity;
import com.kemalakcicek.dto.DtoAddress;
import com.kemalakcicek.dto.DtoAddressIU;
import com.kemalakcicek.service.IAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/rest/api/address")
public class RestAddressController extends RestBaseController implements IRestAddressController {

	@Autowired
	private IAddressService iAddressService;

	@Override
	@PostMapping(path = "/save")
	public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dtoAddressIU) {

		System.out.println("sfd");
		return ok(iAddressService.saveAddress(dtoAddressIU));
	}

}
