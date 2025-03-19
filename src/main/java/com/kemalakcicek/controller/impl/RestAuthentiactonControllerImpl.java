package com.kemalakcicek.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kemalakcicek.controller.IRestAuthenticationController;
import com.kemalakcicek.controller.RootEntity;
import com.kemalakcicek.dto.AuthRequest;
import com.kemalakcicek.dto.AuthResponse;
import com.kemalakcicek.dto.DtoUser;
import com.kemalakcicek.dto.RefrehTokenRequest;
import com.kemalakcicek.service.IAuthenticationService;

import jakarta.validation.Valid;

@RestController
public class RestAuthentiactonControllerImpl extends RestBaseController implements IRestAuthenticationController {

	@Autowired
	private IAuthenticationService iAuthenticationService;

	@Override
	@PostMapping("/register")
	public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {

		return ok(iAuthenticationService.register(input));
	}

	@Override
	@PostMapping(path = "/authenticate")
	public RootEntity<AuthResponse> authentication(@Valid @RequestBody AuthRequest input) {

		return ok(iAuthenticationService.authentication(input));
	}

	@Override
	@PostMapping(path = "/refreshtoken")
	public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefrehTokenRequest input) {

		return ok(iAuthenticationService.refreshToken(input));
	}

}
