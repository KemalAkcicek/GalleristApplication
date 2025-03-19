package com.kemalakcicek.model;

import java.math.BigDecimal;

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
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {

	@Column(name = "account_no")
	private String accountNo;

	@Column(name = "iban")
	private String iban;

	@Column(name = "amount")
	private BigDecimal amount;

	// Burada String olarak verirsek string olarak kaydederek Ordinal verirsek
	// 0,1....diye kaydeder
	@Enumerated(EnumType.STRING)
	@Column(name = "currency_type")
	private CurrencyType currencyType;

}
