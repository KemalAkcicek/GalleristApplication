package com.kemalakcicek.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefrehTokenRequest {

	@NotEmpty
	private String refreshToken;

}
