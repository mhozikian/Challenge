package com.quasar.challenge.infraestructure.delivery.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuasarResponse<T> implements Serializable {

	private int status;
	private String message;
	private T data;

	private static final long serialVersionUID = 7302319210373510173L;
}
