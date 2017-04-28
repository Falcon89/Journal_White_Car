package com.internet.journalwhitecar.ua.model;

import java.sql.Timestamp;

public class Periodicals {

	private Integer id;
	private String name;
	private String description;
	private String image;
	private Integer priceForPublishment;
	private Timestamp lastModified;
	private Integer periodicity;
	private Boolean isDeleted;

	public Periodicals() {
		super();
	}

	public Periodicals(String periodicalName, String periodicalDescription, String periodicalImage,
			Integer priceForMonth, Timestamp periodicalLastModified, Integer periodicity, Boolean isDelete) {
		super();
		this.name = periodicalName;
		this.description = periodicalDescription;
		this.image = periodicalImage;
		this.priceForPublishment = priceForMonth;
		this.lastModified = periodicalLastModified;
		this.periodicity = periodicity;
		this.isDeleted = isDelete;
	}

	public Periodicals(Integer periodicalId, String periodicalName, String periodicalDescription,
			String periodicalImage, Integer priceForMonth, Timestamp periodicalLastModified, Integer periodicity,
			Boolean isDelete) {
		super();
		this.id = periodicalId;
		this.name = periodicalName;
		this.description = periodicalDescription;
		this.image = periodicalImage;
		this.priceForPublishment = priceForMonth;
		this.lastModified = periodicalLastModified;
		this.periodicity = periodicity;
		this.isDeleted = isDelete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getPriceForPublishment() {
		return priceForPublishment;
	}

	public void setPriceForPublishment(Integer priceForPublishment) {
		this.priceForPublishment = priceForPublishment;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public Integer getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Integer periodicity) {
		this.periodicity = periodicity;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Periodicals [periodicalId=" + id + ", periodicalName=" + name + ", periodicalDescription=" + description
				+ ", periodicalImage=" + image + ", priceForMonth=" + priceForPublishment + ", periodicalLastModified="
				+ lastModified + ", periodicity=" + periodicity + ", isDelete=" + isDeleted + "]";
	}

}
