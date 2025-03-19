package com.kemalakcicek.service;

import com.kemalakcicek.dto.AuthRequest;
import com.kemalakcicek.dto.AuthResponse;
import com.kemalakcicek.dto.DtoUser;
import com.kemalakcicek.dto.RefrehTokenRequest;

public interface IAuthenticationService {

	public DtoUser register(AuthRequest input);

	public AuthResponse authentication(AuthRequest request);

	public AuthResponse refreshToken(RefrehTokenRequest input);

}
