package com.kemalakcicek.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kemalakcicek.dto.AuthRequest;
import com.kemalakcicek.dto.AuthResponse;
import com.kemalakcicek.dto.DtoUser;
import com.kemalakcicek.dto.RefrehTokenRequest;
import com.kemalakcicek.exception.BaseException;
import com.kemalakcicek.exception.ErrorMessage;
import com.kemalakcicek.exception.MessageType;
import com.kemalakcicek.jwt.JWTService;
import com.kemalakcicek.model.RefreshToken;
import com.kemalakcicek.model.User;
import com.kemalakcicek.repository.RefreshTokenRepository;
import com.kemalakcicek.repository.UserRepository;
import com.kemalakcicek.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Autowired
	private JWTService jwtService;

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	private User createUser(AuthRequest input) {

		User user = new User();

		user.setDate(new Date());
		user.setUsername(input.getUsername());
		user.setPassword(passwordEncoder.encode(input.getPassword()));

		return user;
	}

	private RefreshToken createRefreshToken(User user) {

		RefreshToken refreshToken = new RefreshToken();

		refreshToken.setDate(new Date());
		refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
		refreshToken.setUser(user);
		refreshToken.setRefreshToken(UUID.randomUUID().toString());

		return refreshToken;

	}

	@Override
	public DtoUser register(AuthRequest input) {

		User savedUser = userRepository.save(createUser(input));

		DtoUser dtoUser = new DtoUser();

		BeanUtils.copyProperties(savedUser, dtoUser);

		return dtoUser;
	}

	@Override
	public AuthResponse authentication(AuthRequest request) {

		try {

			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					request.getUsername(), request.getPassword());

			authenticationProvider.authenticate(authenticationToken);

			Optional<User> optional = userRepository.findByUsername(request.getUsername());

			String accessToken = jwtService.generetadToken(optional.get());

			RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(optional.get()));

			return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());

		} catch (Exception e) {

			throw new BaseException(new ErrorMessage(MessageType.NO_USER_PASSWORD_INVALID, e.getMessage()));

		}

	}

	public boolean isRefreshTokenExpired(Date expireDate) {

		return new Date().before(expireDate);
	}

	@Override
	public AuthResponse refreshToken(RefrehTokenRequest input) {

		Optional<RefreshToken> optional = refreshTokenRepository.findByRefreshToken(input.getRefreshToken());

		if (optional.isEmpty()) {

			throw new BaseException(new ErrorMessage(MessageType.NO_REFRESH_TOKEN_INVALİD, input.getRefreshToken()));
		}

		if (!isRefreshTokenExpired(optional.get().getExpiredDate())) {
			throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_EXPİRED, input.getRefreshToken()));

		}

		String accessToken = jwtService.generetadToken(optional.get().getUser());

		RefreshToken refreshToken = createRefreshToken(optional.get().getUser());

		refreshTokenRepository.save(refreshToken);

		return new AuthResponse(accessToken, refreshToken.getRefreshToken());
	}

}
