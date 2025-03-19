package com.kemalakcicek.controller;

import com.kemalakcicek.dto.DtoSaledCar;
import com.kemalakcicek.dto.DtoSaledCarIU;

public interface IRestSaledCarController {

	public RootEntity<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU);

}
