package com.zensar.olx.advertises.bean;

import java.util.Objects;

public class AdvertisementPostRequest {

	private int id;
	private String title;
	private int categoryId;
	private String description;
	private double price;
	private int statusId;
	
	public AdvertisementPostRequest() {
		super();
	}

	public AdvertisementPostRequest(int id, String title, int categoryId, String description, double price,
			int statusId) {
		super();
		this.id = id;
		this.title = title;
		this.categoryId = categoryId;
		this.description = description;
		this.price = price;
		this.statusId = statusId;
	}

	public AdvertisementPostRequest(String title, int categoryId, String description, double price, int statusId) {
		super();
		this.title = title;
		this.categoryId = categoryId;
		this.description = description;
		this.price = price;
		this.statusId = statusId;
	}

	public AdvertisementPostRequest(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "AdvertisementPostRequest [id=" + id + ", title=" + title + ", categoryId=" + categoryId
				+ ", description=" + description + ", price=" + price + ", statusId=" + statusId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdvertisementPostRequest other = (AdvertisementPostRequest) obj;
		return id == other.id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	
	
	
}
