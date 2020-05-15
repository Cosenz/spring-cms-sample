package it.cosenzproject.cmssample.common.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.cosenzproject.cmssample.core.entity.AppEntity;
import it.cosenzproject.cmssample.core.entity.BaseEntity;

@Entity
@Table(name = "link")
public class Link extends BaseEntity implements AppEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8299040569083399688L;

	private String name;
	@Column(name = "url_icon")
	private String urlIcon;
	private String link;

	@ManyToMany(mappedBy = "links")
	@JsonIgnore
	private Set<Section> sections;

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
	 * @return the urlIcon
	 */
	public String getUrlIcon() {
		return urlIcon;
	}

	/**
	 * @param urlIcon the urlIcon to set
	 */
	public void setUrlIcon(String urlIcon) {
		this.urlIcon = urlIcon;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
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
