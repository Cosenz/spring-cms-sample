package it.cosenzproject.cmssample.common.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import it.cosenzproject.cmssample.core.entity.AppEntity;
import it.cosenzproject.cmssample.core.entity.BaseEntity;

@Entity
@Table(name = "section_group")
public class SectionGroup extends BaseEntity implements AppEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6391857669894835676L;

	private Integer sizeColumn;
	private String name;
	@OneToMany(mappedBy = "group")
	private Set<Section> sections;

	/**
	 * @return the sizeColumn
	 */
	public Integer getSizeColumn() {
		return sizeColumn;
	}

	/**
	 * @param sizeColumn the sizeColumn to set
	 */
	public void setSizeColumn(Integer sizeColumn) {
		this.sizeColumn = sizeColumn;
	}

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
	 * @return the sections
	 */
	public Set<Section> getSections() {
		return sections;
	}

	/**
	 * @param sections the sections to set
	 */
	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

}
