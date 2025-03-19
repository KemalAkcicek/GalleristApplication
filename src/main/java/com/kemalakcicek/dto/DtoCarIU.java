package com.kemalakcicek.dto;

import java.math.BigDecimal;

import com.kemalakcicek.enums.CarStatustType;
import com.kemalakcicek.enums.CurrencyType;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCarIU {

	@NotNull
	private String plaka;

	@NotNull
	private String brand;

	@NotNull
	private String model;

	@NotNull
	private int productionYear;

	@NotNull
	private BigDecimal price;

	@NotNull
	private CurrencyType currencyType;

	@NotNull
	private BigDecimal damagePrice;

	@NotNull
	private CarStatustType carStatustType;
}
