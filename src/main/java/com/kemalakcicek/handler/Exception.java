package com.kemalakcicek.handler;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exception<E> {

	private String path;

	private Date createTime;

	private String host;

	private E message;

}
