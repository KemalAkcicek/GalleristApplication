package com.kemalakcicek.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalakcicek.controller.IRestCarController;
import com.kemalakcicek.controller.RootEntity;
import com.kemalakcicek.dto.DtoCar;
import com.kemalakcicek.dto.DtoCarIU;
import com.kemalakcicek.service.ICarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/rest/api/car")
public class RestCarControllerImpl extends RestBaseController implements IRestCarController {

	@Autowired
	private ICarService iCarService;

	@Override
	@PostMapping("/save")
	public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
		
		return ok(iCarService.saveCar(dtoCarIU));
	}

}
