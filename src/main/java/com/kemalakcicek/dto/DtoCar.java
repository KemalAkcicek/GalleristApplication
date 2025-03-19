package com.kemalakcicek.dto;

import java.math.BigDecimal;

import com.kemalakcicek.enums.CarStatustType;
import com.kemalakcicek.enums.CurrencyType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCar extends DtoBase {

	private String plaka;

	private String brand;

	private String model;

	private int productionYear;

	private BigDecimal price;

	private CurrencyType currencyType;

	private BigDecimal damagePrice;

	private CarStatustType carStatustType;

}
