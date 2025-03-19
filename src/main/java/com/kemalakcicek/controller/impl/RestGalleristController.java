package com.kemalakcicek.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalakcicek.controller.IRestGalleristController;
import com.kemalakcicek.controller.RootEntity;
import com.kemalakcicek.dto.DtoGallerist;
import com.kemalakcicek.dto.DtoGalleristIU;
import com.kemalakcicek.service.IGalleristService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/rest/api/gallerist")
public class RestGalleristController  extends RestBaseController implements IRestGalleristController{

	@Autowired
	private IGalleristService iGalleristService;
	
	@Override
	@PostMapping(path = "/save")
	public RootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody DtoGalleristIU dtoGalleristIU) {
		
		return ok(iGalleristService.saveGallerist(dtoGalleristIU));
	}

}
