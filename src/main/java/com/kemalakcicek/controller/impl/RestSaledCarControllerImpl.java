package com.kemalakcicek.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalakcicek.controller.IRestSaledCarController;
import com.kemalakcicek.controller.RootEntity;
import com.kemalakcicek.dto.DtoSaledCar;
import com.kemalakcicek.dto.DtoSaledCarIU;
import com.kemalakcicek.service.ISaledCarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/saled-car")
public class RestSaledCarControllerImpl extends RestBaseController implements IRestSaledCarController {

	@Autowired
	private ISaledCarService iSaledCarService;

	@Override
	@PostMapping("/save")
	public RootEntity<DtoSaledCar> buyCar(@Valid @RequestBody DtoSaledCarIU dtoSaledCarIU) {

		return ok(iSaledCarService.buyCar(dtoSaledCarIU));
	}

}
