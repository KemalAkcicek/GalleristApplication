package com.kemalakcicek.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalakcicek.dto.DtoCar;
import com.kemalakcicek.dto.DtoCarIU;
import com.kemalakcicek.model.Car;
import com.kemalakcicek.repository.CarRepository;
import com.kemalakcicek.service.ICarService;

@Service
public class CarServiceImpl implements ICarService {

	@Autowired
	private CarRepository carRepository;

	private Car createCar(DtoCarIU dtoCarIU) {

		Car car = new Car();
		car.setDate(new Date());

		BeanUtils.copyProperties(dtoCarIU, car);

		return car;
	}

	@Override
	public DtoCar saveCar(DtoCarIU dtoCarIU) {

		Car savedCar = carRepository.save(createCar(dtoCarIU));

		DtoCar dtoCar = new DtoCar();

		BeanUtils.copyProperties(savedCar, dtoCar);

		return dtoCar;
	}

}
