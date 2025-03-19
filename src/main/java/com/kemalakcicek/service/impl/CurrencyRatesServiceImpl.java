package com.kemalakcicek.service.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kemalakcicek.dto.CurrencyRatesResponse;
import com.kemalakcicek.exception.BaseException;
import com.kemalakcicek.exception.ErrorMessage;
import com.kemalakcicek.exception.MessageType;
import com.kemalakcicek.service.ICurrencyRatesService;

@Service
public class CurrencyRatesServiceImpl implements ICurrencyRatesService {

	@Override
	public CurrencyRatesResponse get(String startDate, String endDate) {

		String rootURL = "https://evds2.tcmb.gov.tr/service/evds/";
		String series = "TP.DK.USD.A";
		String type = "json";

		String endpoint = rootURL + "series=" + series + "&startDate=" + startDate + "&endDate=" + endDate + "&type="
				+ type;

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("key", "lM28IkFxPA");

		HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);

		try {
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<CurrencyRatesResponse> response = restTemplate.exchange(endpoint, HttpMethod.GET, httpEntity,
					new ParameterizedTypeReference<CurrencyRatesResponse>() {
					});

			if (response.getStatusCode().is2xxSuccessful()) {

				return response.getBody();
			}

		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.CURRENCY_NO_IS_OCCURED, e.getMessage()));
		}
		return null;
	}

}
