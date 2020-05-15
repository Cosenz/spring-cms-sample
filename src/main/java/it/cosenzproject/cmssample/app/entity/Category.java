package it.cosenzproject.cmssample.app.entity;

import javax.persistence.Entity;

import it.cosenzproject.cmssample.core.entity.AppEntity;
import it.cosenzproject.cmssample.core.entity.BaseEntity;

@Entity
public class Category extends BaseEntity implements AppEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9089853493733771256L;

	private String name;

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

//	/**
//	 * @return the subCategories
//	 */
//	public Set<SubCategory> getSubCategories() {
//		return subCategories;
//	}
//
//	/**
//	 * @param subCategories the subCategories to set
//	 */
//	public void setSubCategories(Set<SubCategory> subCategories) {
//		this.subCategories = subCategories;
//	}

}
