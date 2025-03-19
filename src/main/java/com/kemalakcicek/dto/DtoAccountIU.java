package com.kemalakcicek.dto;

import java.math.BigDecimal;

import com.kemalakcicek.enums.CurrencyType;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAccountIU {

	@NotEmpty
	private String accountNo;

	@NotEmpty
	private String iban;

	@NotNull
	private BigDecimal amount;

	private CurrencyType currencyType;

}
