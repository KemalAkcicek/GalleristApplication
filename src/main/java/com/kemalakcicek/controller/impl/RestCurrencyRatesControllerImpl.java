package com.kemalakcicek.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kemalakcicek.controller.IRestCurrencyRatesController;
import com.kemalakcicek.controller.RootEntity;
import com.kemalakcicek.dto.CurrencyRatesResponse;
import com.kemalakcicek.service.ICurrencyRatesService;

@RestController
@RequestMapping("/rest/api/")
public class RestCurrencyRatesControllerImpl extends RestBaseController implements IRestCurrencyRatesController {

	@Autowired
	private ICurrencyRatesService iCurrencyRatesService;

	@Override
	@GetMapping("/currency-rates")
	public RootEntity<CurrencyRatesResponse> getCurrencyResponse(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {

		return ok(iCurrencyRatesService.get(startDate, endDate));
	}

}
