package com.kemalakcicek.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalakcicek.dto.DtoAccount;
import com.kemalakcicek.dto.DtoAccountIU;
import com.kemalakcicek.model.Account;
import com.kemalakcicek.repository.AccountRepository;
import com.kemalakcicek.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;

	private Account createAccount(DtoAccountIU dtoAccountIU) {

		Account account = new Account();

		account.setDate(new Date());

		BeanUtils.copyProperties(dtoAccountIU, account);

		return account;

	}

	@Override
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {

		Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));

		DtoAccount dtoAccount = new DtoAccount();

		BeanUtils.copyProperties(savedAccount, dtoAccount);

		return dtoAccount;
	}

}
