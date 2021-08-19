package com.product.Entity.Exception;

import java.text.MessageFormat;

public class ImageNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ImageNotFoundException(final Long id) {
		super(MessageFormat.format("khong tim thay id" , id));
	}
}
