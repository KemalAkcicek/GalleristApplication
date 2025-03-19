package com.kemalakcicek.controller;

import com.kemalakcicek.dto.CurrencyRatesResponse;

public interface IRestCurrencyRatesController {

	public RootEntity<CurrencyRatesResponse> getCurrencyResponse(String startDate, String endDate);

}
