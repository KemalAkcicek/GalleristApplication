package com.kemalakcicek.service;

import com.kemalakcicek.dto.DtoAddress;
import com.kemalakcicek.dto.DtoAddressIU;

public interface IAddressService {

	public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);

}
