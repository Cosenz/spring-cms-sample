package it.cosenzproject.cmssample.app.model.viewmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentViewModel {

	private Integer id;
	private String message;
	private String date;
	private UserViewModel user;
	private Integer productId;
	private Integer parentCommentId;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the user
	 */
	public UserViewModel getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserViewModel user) {
		this.user = user;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
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
