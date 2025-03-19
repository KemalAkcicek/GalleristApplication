package com.kemalakcicek.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // burada 1 id galeri 3 id arabayı satsın ama bir daha aynı değerler yan yana
		// olmasın
@Table(name = "gallerist_car", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "gallerist_id,", "car_id" }, name = "uq_gallerist_car") })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GalleristCar extends BaseEntity {

	@ManyToOne
	private Gallerist gallerist;// Bir gallerist birden fazla gallerist car olabilir

	@ManyToOne
	private Car car;

}
