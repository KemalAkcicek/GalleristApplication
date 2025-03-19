package com.kemalakcicek.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalakcicek.dto.DtoAddress;
import com.kemalakcicek.dto.DtoCar;
import com.kemalakcicek.dto.DtoGallerist;
import com.kemalakcicek.dto.DtoGalleristCar;
import com.kemalakcicek.dto.DtoGalleristCarIU;
import com.kemalakcicek.exception.BaseException;
import com.kemalakcicek.exception.ErrorMessage;
import com.kemalakcicek.exception.MessageType;
import com.kemalakcicek.model.Car;
import com.kemalakcicek.model.Gallerist;
import com.kemalakcicek.model.GalleristCar;
import com.kemalakcicek.repository.CarRepository;
import com.kemalakcicek.repository.GalleristCarRepository;
import com.kemalakcicek.repository.GalleristRepository;
import com.kemalakcicek.service.IGalleristCarServicce;

@Service
public class GalleristCarService implements IGalleristCarServicce {

	@Autowired
	private GalleristCarRepository galleristCarRepository;

	@Autowired
	private GalleristRepository galleristRepository;

	@Autowired
	private CarRepository carRepository;

	private GalleristCar createGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {

		GalleristCar galleristCar = new GalleristCar();

		Optional<Gallerist> optionalGallerist = galleristRepository.findById(dtoGalleristCarIU.getGalleristId());

		if (optionalGallerist.isEmpty()) {

			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXİTS, ""));

		}
		galleristCar.setGallerist(optionalGallerist.get());

		Optional<Car> optionalCar = carRepository.findById(dtoGalleristCarIU.getCarId());

		if (optionalCar.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXİTS, ""));

		}
		galleristCar.setCar(optionalCar.get());

		galleristCar.setDate(new Date());

		return galleristCar;
	}

	@Override
	public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {

		DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
		DtoGallerist dtoGallerist = new DtoGallerist();
		DtoCar dtoCar = new DtoCar();

		GalleristCar savedGalleristCar = galleristCarRepository.save(createGalleristCar(dtoGalleristCarIU));

		BeanUtils.copyProperties(savedGalleristCar, dtoGalleristCar);

		BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
		BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);

		DtoAddress dtoAddress = new DtoAddress();

		BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(), dtoAddress);

		dtoGallerist.setAddress(dtoAddress);

		dtoGalleristCar.setGallerist(dtoGallerist);
		dtoGalleristCar.setCar(dtoCar);

		return dtoGalleristCar;
	}

}
