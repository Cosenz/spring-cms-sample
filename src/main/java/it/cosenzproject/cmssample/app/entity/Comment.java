package it.cosenzproject.cmssample.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import it.cosenzproject.cmssample.core.entity.AppEntity;
import it.cosenzproject.cmssample.core.entity.BaseEntity;

@Entity
public class Comment extends BaseEntity implements AppEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1160968465052444329L;
	private String message;
	private LocalDateTime date;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@Column(name = "parent_comment_id")
	private Integer parentCommentId;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the parentCommentId
	 */
	public Integer getParentCommentId() {
		return parentCommentId;
	}

	/**
	 * @param parentCommentId the parentCommentId to set
	 */
	public void setParentCommentId(Integer parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

}
