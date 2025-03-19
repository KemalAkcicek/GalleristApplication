package com.kemalakcicek.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalakcicek.dto.DtoAddress;
import com.kemalakcicek.dto.DtoAddressIU;
import com.kemalakcicek.model.Address;
import com.kemalakcicek.repository.AddressRepository;
import com.kemalakcicek.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressRepository addressRepository;

	public Address createAddress(DtoAddressIU dtoAddressIU) {

		Address address = new Address();

		address.setDate(new Date());
		BeanUtils.copyProperties(dtoAddressIU, address);

		return address;

	}

	@Override
	public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {

		Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));

		DtoAddress dtoAddress = new DtoAddress();

		BeanUtils.copyProperties(savedAddress, dtoAddress);

		return dtoAddress;
	}

}
