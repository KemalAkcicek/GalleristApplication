package com.kemalakcicek.controller;

import com.kemalakcicek.dto.DtoAddress;
import com.kemalakcicek.dto.DtoAddressIU;

public interface IRestAddressController {

	public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);

}
