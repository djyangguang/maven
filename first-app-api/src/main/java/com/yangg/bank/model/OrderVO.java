package com.yangg.bank.model;



public class OrderVO   implements java.io.Serializable    {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String amount;
	private String  name;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderVO [id=");
		builder.append(id);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
