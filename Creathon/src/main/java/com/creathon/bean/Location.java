package com.creathon.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.web.multipart.MultipartFile;

import com.creathon.service.LocationPhotosService;

import javax.persistence.Transient;

@Entity
@Table(name="location")
public class Location {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
	
	
	 @Column(name = "name")
	 private String name;
	 
	 @Column(name = "address")
	 private String address;
	 
	 @Column(name = "type")
	 private String type;
	 
	 @Column(name = "description")
	 private String description;
	 
	 @Transient
	 private List<MultipartFile> locationMultiplePhoto ;

	 

	public void setAddress(String address) {
		this.address = address;
	}

	@Transient
	 private MultipartFile locationPhoto;
	 
	 @Column(name = "photo")
	 private String photo;
	 
	 @Column(name = "quote")
	 private String quote;

	 @Column(name = "price")
	 private Double price;
	 
	 
	@Column(name = "img_description")
	private String imgDescription;
		 
	@JoinColumn(name = "agency_id")
	@OneToOne
	private Agency agencyId;

	   @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
	   private List<LocationPhotos> locationPhotos;
	
	
	public MultipartFile getLocationPhoto() {
		return locationPhoto;
	}

	public void setLocationPhoto(MultipartFile locationPhoto) {
		this.locationPhoto = locationPhoto;
	}

	public List<MultipartFile> getLocationMultiplePhoto() {
		return locationMultiplePhoto;
	}

	public void setLocationMultiplePhoto(List<MultipartFile> locationMultiplePhoto) {
		this.locationMultiplePhoto = locationMultiplePhoto;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddressId(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgDescription() {
		return imgDescription;
	}

	public void setImgDescription(String imgDescription) {
		this.imgDescription = imgDescription;
	}

	public Agency getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Agency agencyId) {
		this.agencyId = agencyId;
	}
	
	

	public List<LocationPhotos> getLocationPhotos() {
		return locationPhotos;
	}

	public void setLocationPhotos(List<LocationPhotos> locationPhotos) {
		this.locationPhotos = locationPhotos;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", type=" + type
				+ ", description=" + description + ", locationPhoto=" + locationPhoto + ", photo=" + photo + ", quote="
				+ quote + ", price=" + price + ", imgDescription=" + imgDescription + ", agencyId=" + agencyId + "]";
	}

	
}
