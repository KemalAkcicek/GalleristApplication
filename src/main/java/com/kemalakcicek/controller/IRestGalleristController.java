package com.kemalakcicek.controller;

import com.kemalakcicek.dto.DtoGallerist;
import com.kemalakcicek.dto.DtoGalleristIU;

public interface IRestGalleristController {

	public RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);

}
