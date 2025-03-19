package com.kemalakcicek.controller;

import com.kemalakcicek.dto.AuthRequest;
import com.kemalakcicek.dto.AuthResponse;
import com.kemalakcicek.dto.DtoUser;
import com.kemalakcicek.dto.RefrehTokenRequest;

public interface IRestAuthenticationController {

	public RootEntity<DtoUser> register(AuthRequest input);

	public RootEntity<AuthResponse> authentication(AuthRequest input);

	public RootEntity<AuthResponse> refreshToken(RefrehTokenRequest input);

}
