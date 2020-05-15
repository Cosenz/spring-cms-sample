package it.cosenzproject.cmssample.app.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.cosenzproject.cmssample.core.entity.AppEntity;
import it.cosenzproject.cmssample.core.entity.BaseEntity;

@Entity
@Table(name = "sub_category")
public class SubCategory extends BaseEntity implements AppEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9168128277709624815L;
	private String name;
	@Column(name = "id_category")
	private Integer categoryId;
//  Hibernate method	
//	@ManyToOne
//	@JoinColumn(name = "id_category")
//	@JsonIgnore
//	private Category category;

	@ManyToMany(mappedBy = "subcategories")
	@JsonIgnore
	private Set<Product> products;

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
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	// Hibernate method
//	/**
//	 * @return the category
//	 */
//	public Category getCategory() {
//		return category;
//	}
//
//	/**
//	 * @param category the category to set
//	 */
//	public void setCategory(Category category) {
//		this.category = category;
//	}

}
