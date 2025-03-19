package com.kemalakcicek.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalakcicek.dto.CurrencyRatesResponse;
import com.kemalakcicek.dto.DtoCar;
import com.kemalakcicek.dto.DtoCustomer;
import com.kemalakcicek.dto.DtoGallerist;
import com.kemalakcicek.dto.DtoSaledCar;
import com.kemalakcicek.dto.DtoSaledCarIU;
import com.kemalakcicek.enums.CarStatustType;
import com.kemalakcicek.exception.BaseException;
import com.kemalakcicek.exception.ErrorMessage;
import com.kemalakcicek.exception.MessageType;
import com.kemalakcicek.model.Car;
import com.kemalakcicek.model.Customer;
import com.kemalakcicek.model.SaledCar;
import com.kemalakcicek.repository.CarRepository;
import com.kemalakcicek.repository.CustomerRepository;
import com.kemalakcicek.repository.GalleristRepository;
import com.kemalakcicek.repository.SaledCarRepository;
import com.kemalakcicek.service.ICurrencyRatesService;
import com.kemalakcicek.service.ISaledCarService;
import com.kemalakcicek.utils.DateUtils;

@Service
public class SaledCarServiceImpl implements ISaledCarService {

	@Autowired
	private SaledCarRepository saledCarRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private GalleristRepository galleristRepository;

	@Autowired
	private ICurrencyRatesService currencyRatesService;

	public BigDecimal remainingCustomerAmount(Customer customer, Car car) {

		BigDecimal convertCustomerAmountToUSD = convertCustomerAmountToUSD(customer);
		BigDecimal remainingCustomerUSD = convertCustomerAmountToUSD.subtract(car.getPrice());

		CurrencyRatesResponse currencyRatesResponse = currencyRatesService
				.get(DateUtils.convertDateToString(new Date()), DateUtils.convertDateToString(new Date()));

		BigDecimal remainingCustomerTL = remainingCustomerUSD
				.multiply(new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd()));

		return remainingCustomerTL;
	}

	private BigDecimal convertCustomerAmountToUSD(Customer customer) {

		CurrencyRatesResponse currencyRatesResponse = currencyRatesService
				.get(DateUtils.convertDateToString(new Date()), DateUtils.convertDateToString(new Date()));

		BigDecimal usd = new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd());

		BigDecimal customerUSDAmount = customer.getAccount().getAmount().divide(usd, 2, RoundingMode.HALF_UP);

		return customerUSDAmount;
	}

	private boolean checkAmount(DtoSaledCarIU dtoSaledCarIU) {

		Optional<Car> optCar = carRepository.findById(dtoSaledCarIU.getCarId());

		if (optCar.isEmpty()) {

			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXİTS, dtoSaledCarIU.getCarId().toString()));
		}

		Optional<Customer> optCustomer = customerRepository.findById(dtoSaledCarIU.getCustomerId());

		if (optCustomer.isEmpty()) {

			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXİTS, dtoSaledCarIU.getCustomerId().toString()));

		}

		BigDecimal convertCustomerAmountToUSD = convertCustomerAmountToUSD(optCustomer.get());

		// 0,1,-1
		if (convertCustomerAmountToUSD.compareTo(optCar.get().getPrice()) == 0
				|| convertCustomerAmountToUSD.compareTo(optCar.get().getPrice()) > 0) {

			return true;

		}

		return false;
	}

	public boolean checkCarStatus(Long id) {

		Optional<Car> optCar = carRepository.findById(id);

		if (optCar.isPresent() && optCar.get().getCarStatustType().name().equals(CarStatustType.SALED.name())) {
			return false;
		}

		return true;

	}

	public SaledCar createSaledCar(DtoSaledCarIU dtoSaledCarIU) {

		SaledCar saledCar = new SaledCar();
		saledCar.setDate(new Date());

		saledCar.setCustomer(customerRepository.findById(dtoSaledCarIU.getCustomerId()).orElse(null));
		saledCar.setGallerist(galleristRepository.findById(dtoSaledCarIU.getGalleristId()).orElse(null));
		saledCar.setCar(carRepository.findById(dtoSaledCarIU.getCarId()).orElse(null));

		return saledCar;

	}

	@Override
	public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU) {

		if (!checkAmount(dtoSaledCarIU)) {

			throw new BaseException(new ErrorMessage(MessageType.NO_CUSTOMER_IS_ENOUGH, ""));

		}
		if (!checkCarStatus(dtoSaledCarIU.getCarId())) {
			throw new BaseException(
					new ErrorMessage(MessageType.CAR_ALREAD_İS_SALED, dtoSaledCarIU.getCarId().toString()));
		}

		SaledCar savedSaledCar = saledCarRepository.save(createSaledCar(dtoSaledCarIU));

		Car car = savedSaledCar.getCar();

		car.setCarStatustType(CarStatustType.SALED);
		carRepository.save(car);

		Customer customer = savedSaledCar.getCustomer();

		customer.getAccount().setAmount(remainingCustomerAmount(customer, car));

		customerRepository.save(customer);

		return toDto(savedSaledCar);
	}

	public DtoSaledCar toDto(SaledCar saledCar) {

		DtoSaledCar dtoSaledCar = new DtoSaledCar();
		DtoCar dtoCar = new DtoCar();
		DtoGallerist dtoGallerist = new DtoGallerist();
		DtoCustomer dtoCustomer = new DtoCustomer();

		BeanUtils.copyProperties(saledCar, dtoSaledCar);
		BeanUtils.copyProperties(saledCar.getCar(), dtoCar);
		BeanUtils.copyProperties(saledCar.getCustomer(), dtoCustomer);
		BeanUtils.copyProperties(saledCar.getGallerist(), dtoGallerist);

		dtoSaledCar.setDtoCar(dtoCar);
		dtoSaledCar.setDtoCustomer(dtoCustomer);
		dtoSaledCar.setDtoGallerist(dtoGallerist);

		return dtoSaledCar;

	}

}
