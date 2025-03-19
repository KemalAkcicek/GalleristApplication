package com.kemalakcicek.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyRatesItem {

	// Burada dışarıdan Tarih diye bir değer gelecek sen o değeri date ver diyoruz
	@JsonProperty("Tarih")
	private String date;

	@JsonProperty("TP_DK_USD_A")
	private String usd;

}
