package com.kemalakcicek.exception;

import lombok.Getter;

@Getter
public enum MessageType {

	NO_RECORD_EXİTS("1001", "kayıt bulunmadı"), USERNAME_NOT_FOUND("3003", "user bulunamadı"),
	NO_REFRESH_TOKEN_INVALİD("5000", "refresh token bulunamadı"), REFRESH_TOKEN_EXPİRED("6006", "token süresi doldu"),
	NO_CUSTOMER_IS_ENOUGH("8888", "müşterinin parası yeterli değil"), CAR_ALREAD_İS_SALED("1234", "araba satılmış"),
	CURRENCY_NO_IS_OCCURED("7007", "currency rates alırken hata oluştur"),
	NO_USER_PASSWORD_INVALID("4004", "user name veya parola hatalı"), TOKEN_IS_EXPİRED("2002", "token süresi doldu"),
	GENERAL_EXCEPTİON("9999", "genel hata");

	private String code;
	private String message;

	MessageType(String code, String message) {
		this.code = code;
		this.message = message;
	}

}
