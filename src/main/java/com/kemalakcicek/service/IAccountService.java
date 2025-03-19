package com.kemalakcicek.service;

import com.kemalakcicek.dto.DtoAccount;
import com.kemalakcicek.dto.DtoAccountIU;

public interface IAccountService {

	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);

}
