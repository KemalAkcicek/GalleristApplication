package com.kemalakcicek.service;

import com.kemalakcicek.dto.DtoSaledCar;
import com.kemalakcicek.dto.DtoSaledCarIU;

public interface ISaledCarService {

	public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);

}
