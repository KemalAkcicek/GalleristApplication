package com.kemalakcicek.controller;

import com.kemalakcicek.dto.DtoAccount;
import com.kemalakcicek.dto.DtoAccountIU;

public interface IRestAccountController {

	public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);

}
