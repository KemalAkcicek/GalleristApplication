package com.kemalakcicek.service;

import com.kemalakcicek.dto.CurrencyRatesResponse;

public interface ICurrencyRatesService {

	public CurrencyRatesResponse get(String startDate, String endDate);

}
