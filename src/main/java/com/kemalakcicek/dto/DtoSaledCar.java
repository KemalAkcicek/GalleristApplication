package com.kemalakcicek.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSaledCar extends DtoBase {

	private DtoCustomer dtoCustomer;

	private DtoCar dtoCar;

	private DtoGallerist dtoGallerist;

}
