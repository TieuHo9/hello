package com.product.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Entity.Image;
import com.product.Entity.Dto.ImageDto;
import com.product.Entity.Exception.ImageNotFoundException;
import com.product.Repository.ImageRepository;
import com.product.Repository.ProductsRepository;

@Service
public class ImageService {
	private final ProductsRepository productsRepository;
	private final ImageRepository imagesRepository;
	
	@Autowired
	public ImageService(ProductsRepository productsRepository, ImageRepository imagesRepository) {
		this.productsRepository = productsRepository;
		this.imagesRepository = imagesRepository;
	}
	
	public Image addImage(ImageDto imagesDto) {
		Image images = new Image();
		images.setImage(imagesDto.getImages());
		images.setProducts(productsRepository.findById(imagesDto.getProductsId()).get());
		return imagesRepository.save(images);
	}
	
	public List<Image> getImage(){
		return StreamSupport
				.stream(imagesRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Image getImage(Long id) {
		return imagesRepository.findById(id)
				.orElseThrow(() -> new ImageNotFoundException(id));
	}
	
	@Transactional
	public void deleteImage(Long id) throws Exception{
		imagesRepository.findById(id).orElseThrow(() -> new Exception("this image not found"));
		imagesRepository.deleteById(id);
	}
	
	@Transactional
	public Image editImage(Long id, ImageDto images) {
		Image imageToEdit = getImage(id);
		imageToEdit.setImage(images.getImages());
		imageToEdit.setProducts(productsRepository.findById(images.getProductsId()).get());
		return imagesRepository.save(imageToEdit);
		
	}
}
