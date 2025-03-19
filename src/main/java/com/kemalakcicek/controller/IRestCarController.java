package com.kemalakcicek.controller;

import com.kemalakcicek.dto.DtoCar;
import com.kemalakcicek.dto.DtoCarIU;

public interface IRestCarController {

	public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);

}
