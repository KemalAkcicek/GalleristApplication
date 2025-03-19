package com.kemalakcicek.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalakcicek.dto.DtoAddress;
import com.kemalakcicek.dto.DtoGallerist;
import com.kemalakcicek.dto.DtoGalleristIU;
import com.kemalakcicek.exception.BaseException;
import com.kemalakcicek.exception.ErrorMessage;
import com.kemalakcicek.exception.MessageType;
import com.kemalakcicek.model.Address;
import com.kemalakcicek.model.Gallerist;
import com.kemalakcicek.repository.AddressRepository;
import com.kemalakcicek.repository.GalleristRepository;
import com.kemalakcicek.service.IGalleristService;

@Service
public class GalleristServiceImpl implements IGalleristService {

	@Autowired
	private GalleristRepository galleristRepository;

	@Autowired
	private AddressRepository addressRepository;

	private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {

		Gallerist gallerist = new Gallerist();

		gallerist.setDate(new Date());

		BeanUtils.copyProperties(dtoGalleristIU, gallerist);

		Optional<Address> optional = addressRepository.findById(dtoGalleristIU.getAddressId());

		if (optional.isEmpty()) {

			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXİTS, dtoGalleristIU.getAddressId().toString()));
		}

		gallerist.setAddress(optional.get());

		return gallerist;
	}

	@Override
	public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {

		Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGalleristIU));

		DtoGallerist dtoGallerist = new DtoGallerist();

		BeanUtils.copyProperties(savedGallerist, dtoGallerist);

		DtoAddress dtoAddress = new DtoAddress();

		BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);

		dtoGallerist.setAddress(dtoAddress);

		return dtoGallerist;
	}

}
