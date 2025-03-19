package com.kemalakcicek.model;

import java.math.BigDecimal;

import com.kemalakcicek.enums.CarStatustType;
import com.kemalakcicek.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity {

	@Column(name = "plaka")
	private String plaka;

	@Column(name = "brand")
	private String brand;

	@Column(name = "model")
	private String model;

	@Column(name = "production_year")
	private int productionYear;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "currency_type")
	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;

	@Column(name = "damagePrice")
	private BigDecimal damagePrice;

	@Enumerated(EnumType.STRING)
	@Column(name = "car_status_type")
	private CarStatustType carStatustType;

}
