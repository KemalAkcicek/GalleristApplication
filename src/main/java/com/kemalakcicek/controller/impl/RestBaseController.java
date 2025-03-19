package com.kemalakcicek.controller.impl;

import com.kemalakcicek.controller.RootEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestBaseController {

	public <T> RootEntity<T> ok(T payload) {

		return RootEntity.ok(payload);
	}

	public <T> RootEntity<T> errorMessage(String errorMessage) {

		return RootEntity.error(errorMessage);
	}

}
