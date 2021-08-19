package com.product.Entity.Dto;

import com.product.Entity.Image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlainImageDto {
	private Long id;
	private String images;
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
	
	public static PlainImageDto from(Image images) {
		PlainImageDto plainImageDto = new PlainImageDto();
		plainImageDto.setId(images.getId());
		plainImageDto.setImages(images.getImage());
		return plainImageDto;
	}
}
