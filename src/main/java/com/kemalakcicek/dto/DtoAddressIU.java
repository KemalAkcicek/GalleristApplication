package com.kemalakcicek.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAddressIU {

	@NotEmpty
	private String city;

	@NotEmpty
	private String district;

	@NotEmpty
	private String neigborhood;

	@NotEmpty
	private String street;

}
