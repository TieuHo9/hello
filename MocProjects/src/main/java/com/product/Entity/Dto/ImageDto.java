package com.product.Entity.Dto;

import java.util.Objects;

import com.product.Entity.Image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDto {
		private Long id;
		private String images;
	private Long productsId;
	
	private PlainImageDto plainImageDto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Long getProductsId() {
		return productsId;
	}

	public void setProductsId(Long productsId) {
		this.productsId = productsId;
	}

	public PlainImageDto getPlainImageDto() {
		return plainImageDto;
	}

	public void setPlainImageDto(PlainImageDto plainImageDto) {
		this.plainImageDto = plainImageDto;
	}
	
	public static ImageDto from(Image images) {
		ImageDto imagesDto = new ImageDto();
		imagesDto.setId(images.getId());
		imagesDto.setImages(images.getImage());
		if (Objects.nonNull(images.getProducts())){
			imagesDto.setPlainImageDto(PlainImageDto.from(images));
		}
		return imagesDto;
	}
	
}
