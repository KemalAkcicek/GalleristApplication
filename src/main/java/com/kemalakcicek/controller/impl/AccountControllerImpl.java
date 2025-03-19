package com.kemalakcicek.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalakcicek.controller.IRestAccountController;
import com.kemalakcicek.controller.RootEntity;
import com.kemalakcicek.dto.DtoAccount;
import com.kemalakcicek.dto.DtoAccountIU;
import com.kemalakcicek.service.IAccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/rest/api/account")
public class AccountControllerImpl extends RestBaseController implements IRestAccountController {

	@Autowired
	private IAccountService iAccountService;

	@Override
	@PostMapping("/save")
	public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {

		return ok(iAccountService.saveAccount(dtoAccountIU));
	}

}
