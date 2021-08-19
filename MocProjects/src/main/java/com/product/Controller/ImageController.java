package com.product.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.Entity.Image;
import com.product.Entity.Dto.ImageDto;
import com.product.Service.ImageService;

@RestController
@RequestMapping("/images/")
public class ImageController {

	private final ImageService imagesService;
	
	@Autowired
	public ImageController(ImageService imagesService) {
		this.imagesService = imagesService;
	}
	
	@PostMapping
	public ResponseEntity<ImageDto> addImage(@RequestBody final ImageDto imagesDto){
		Image images = imagesService.addImage(imagesDto);
		return new ResponseEntity<>(ImageDto.from(images), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ImageDto>> getImage(){
		List<Image> images = imagesService.getImage();
		List<ImageDto> imagesDto = images.stream().map(ImageDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(imagesDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ImageDto> getImage(@PathVariable final Long id){
		Image images = imagesService.getImage(id);
		return new ResponseEntity<>(ImageDto.from(images), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ImageDto> editImage(@PathVariable final Long id, @RequestBody final ImageDto imagesDto ){
		Image editedimages = imagesService.editImage(id, imagesDto);
		return new ResponseEntity<>(ImageDto.from(editedimages), HttpStatus.OK);

	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteImage(@PathVariable final Long id){
		try {
			imagesService.deleteImage(id);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return new ResponseEntity<>("Delete success", null , HttpStatus.OK);
	}
	
}