package cn.swu.edu.javaweb.shoppingcart.dao;

public class CartNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CartNotFoundException(String message) {
		super();
		this.message = message;
	}

	public CartNotFoundException() {
		super();
	}
	
	
}
