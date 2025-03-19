package com.kemalakcicek.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalakcicek.controller.IRestGalleristCarController;
import com.kemalakcicek.controller.RootEntity;
import com.kemalakcicek.dto.DtoGalleristCar;
import com.kemalakcicek.dto.DtoGalleristCarIU;
import com.kemalakcicek.service.IGalleristCarServicce;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/galleristcar")
public class RestGalleristCarControllerImpl extends RestBaseController implements IRestGalleristCarController {

	@Autowired
	private IGalleristCarServicce iGalleristCarServicce;

	@PostMapping(path = "/save")
	@Override
	public RootEntity<DtoGalleristCar> saveGalleristCar(@Valid @RequestBody DtoGalleristCarIU dtoGalleristCarIU) {
		return ok(iGalleristCarServicce.saveGalleristCar(dtoGalleristCarIU));
	}

}
