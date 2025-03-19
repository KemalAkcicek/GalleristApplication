package com.kemalakcicek.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalakcicek.dto.DtoAccount;
import com.kemalakcicek.dto.DtoAddress;
import com.kemalakcicek.dto.DtoCustomer;
import com.kemalakcicek.dto.DtoCustomerIU;
import com.kemalakcicek.exception.BaseException;
import com.kemalakcicek.exception.ErrorMessage;
import com.kemalakcicek.exception.MessageType;
import com.kemalakcicek.model.Account;
import com.kemalakcicek.model.Address;
import com.kemalakcicek.model.Customer;
import com.kemalakcicek.repository.AccountRepository;
import com.kemalakcicek.repository.AddressRepository;
import com.kemalakcicek.repository.CustomerRepository;
import com.kemalakcicek.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private AccountRepository accountRepository;

	private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {

		Customer customer = new Customer();

		customer.setDate(new Date());

		BeanUtils.copyProperties(dtoCustomerIU, customer);

		Optional<Address> optionalAddress = addressRepository.findById(dtoCustomerIU.getAddressId());

		if (optionalAddress.isPresent()) {
			customer.setAddress(optionalAddress.get());

		} else {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXİTS, ""));
		}

		Optional<Account> optionalAccount = accountRepository.findById(dtoCustomerIU.getAccountId());

		if (optionalAccount.isEmpty()) {

			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXİTS, ""));
		} else {
			customer.setAccount(optionalAccount.get());
		}

		return customer;
	}

	@Override
	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {

		DtoCustomer dtoCustomer = new DtoCustomer();

		Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));

		BeanUtils.copyProperties(savedCustomer, dtoCustomer);

		DtoAccount dtoAccount = new DtoAccount();

		BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);

		dtoCustomer.setAccount(dtoAccount);

		DtoAddress dtoAddress = new DtoAddress();

		BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);

		dtoCustomer.setAddress(dtoAddress);

		return dtoCustomer;
	}

}
