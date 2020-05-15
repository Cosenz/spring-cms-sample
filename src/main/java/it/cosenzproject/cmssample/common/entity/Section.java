package it.cosenzproject.cmssample.common.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.cosenzproject.cmssample.core.entity.AppEntity;
import it.cosenzproject.cmssample.core.entity.BaseEntity;

@Entity
@Table(name = "section")
public class Section extends BaseEntity implements AppEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2663263388944208977L;

	private String name;
	@Column(name = "url_logo")
	private String urlLogo;

	@ManyToOne
	@JoinColumn(name = "id_group")
	@JsonIgnore
	private SectionGroup group;

	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "section_link", joinColumns = @JoinColumn(name = "id_section"), inverseJoinColumns = @JoinColumn(name = "id_link"))
	private Set<Link> links;

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
	 * @return the urlLogo
	 */
	public String getUrlLogo() {
		return urlLogo;
	}

	/**
	 * @param urlLogo the urlLogo to set
	 */
	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	/**
	 * @return the links
	 */
	public Set<Link> getLinks() {
		return links;
	}

	/**
	 * @return the group
	 */
	public SectionGroup getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(SectionGroup group) {
		this.group = group;
	}

	/**
	 * @param links the links to set
	 */
	public void setLinks(Set<Link> links) {
		this.links = links;
	}

}
