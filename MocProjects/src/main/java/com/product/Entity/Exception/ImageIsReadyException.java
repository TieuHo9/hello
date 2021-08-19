package com.product.Entity.Exception;

import java.text.MessageFormat;

public class ImageIsReadyException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ImageIsReadyException(final Long imagesId, final Long productsId) {
		super(MessageFormat.format("Prodcuts: is ready", imagesId, productsId));
	}
}
