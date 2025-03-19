package com.kemalakcicek.controller;

import com.kemalakcicek.dto.DtoGalleristCar;
import com.kemalakcicek.dto.DtoGalleristCarIU;

public interface IRestGalleristCarController {

	public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
