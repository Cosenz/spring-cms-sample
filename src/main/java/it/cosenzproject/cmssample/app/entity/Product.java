package it.cosenzproject.cmssample.app.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import it.cosenzproject.cmssample.core.entity.AppEntity;
import it.cosenzproject.cmssample.core.entity.BaseEntity;

@Entity
public class Product extends BaseEntity implements AppEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3202572228032169913L;

	private String name;
	private String brand;
	private BigDecimal price;
	private String description;
	@Column(name = "url_image")
	private String urlImage;
	private Boolean available;
	private BigDecimal packingWeight;
	private String packingSize;

	@ManyToMany
	@JoinTable(
	        name = "product_subcategory", joinColumns = @JoinColumn(name = "id_product"), inverseJoinColumns = @JoinColumn(name = "id_subcategory")
	)
	private Set<SubCategory> subcategories;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the urlImage
	 */
	public String getUrlImage() {
		return urlImage;
	}

	/**
	 * @param urlImage the urlImage to set
	 */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	/**
	 * @return the available
	 */
	public Boolean getAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(Boolean available) {
		this.available = available;
	}

	/**
	 * @return the packingWeight
	 */
	public BigDecimal getPackingWeight() {
		return packingWeight;
	}

	/**
	 * @param packingWeight the packingWeight to set
	 */
	public void setPackingWeight(BigDecimal packingWeight) {
		this.packingWeight = packingWeight;
	}

	/**
	 * @return the packingSize
	 */
	public String getPackingSize() {
		return packingSize;
	}

	/**
	 * @param packingSize the packingSize to set
	 */
	public void setPackingSize(String packingSize) {
		this.packingSize = packingSize;
	}

	/**
	 * @return the subcategories
	 */
	public Set<SubCategory> getSubcategories() {
		return subcategories;
	}

	/**
	 * @param subcategories the subcategories to set
	 */
	public void setSubcategories(Set<SubCategory> subcategories) {
		this.subcategories = subcategories;
	}

}
