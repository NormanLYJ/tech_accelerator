package com.ust.esdemo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "crime_data")
public class Crime {
	@Id
	private String crimeId;

	@Field(type = FieldType.Text, name = "caseNumber")
	private String caseNumber;

	//@Field(type = FieldType.Date, name = "date")
	@Field(type = FieldType.Date, name = "date")
	private Date date;

	@Field(type = FieldType.Text, name = "block")
	private String block;

	@Field(type = FieldType.Text, name = "IUCR")
	private String IUCR;

	@Field(type = FieldType.Text, name = "primaryType")
	private String primaryType;

	@Field(type = FieldType.Text, name = "description")
	private String description;

	@Field(type = FieldType.Text, name = "locationDescription")
	private String locationDescription;

	@Field(type = FieldType.Text, name = "arrest")
	private String arrest;

	@Field(type = FieldType.Text, name = "domestic")
	private String domestic;

	@Field(type = FieldType.Integer, name = "beat")
	private Integer beat;

	@Field(type = FieldType.Integer, name = "district")
	private Integer district;

	@Field(type = FieldType.Integer, name = "ward")
	private Integer ward;

	@Field(type = FieldType.Integer, name = "communityArea")
	private Integer communityArea;

	@Field(type = FieldType.Text, name = "fbiCode")
	private String fbiCode;

	@Field(type = FieldType.Integer, name = "xCoordinate")
	private Integer xCoordinate;

	@Field(type = FieldType.Integer, name = "yCoordinate")
	private Integer yCoordinate;

	@Field(type = FieldType.Date, name = "year")
	private Integer year;

	//use these both as a properties "pattern = "MM/dd/yyyy hh:mm:ss a" ,format = DateFormat.custom
	@Field(type = FieldType.Date, name = "updatedOn")
	private Date updatedOn;

	@Field(type = FieldType.Double, name = "latitude")
	private Double latitude;

	@Field(type = FieldType.Double, name = "longitude")
	private Double longitude;

	@Field(type = FieldType.Integer, name = "location")
	private String location;

	public String getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(String crimeId) {
		this.crimeId = crimeId;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getIUCR() {
		return IUCR;
	}

	public void setIUCR(String iUCR) {
		IUCR = iUCR;
	}

	public String getPrimaryType() {
		return primaryType;
	}

	public void setPrimaryType(String primaryType) {
		this.primaryType = primaryType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getArrest() {
		return arrest;
	}

	public void setArrest(String arrest) {
		this.arrest = arrest;
	}

	public String getDomestic() {
		return domestic;
	}

	public void setDomestic(String domestic) {
		this.domestic = domestic;
	}

	public Integer getBeat() {
		return beat;
	}

	public void setBeat(Integer beat) {
		this.beat = beat;
	}

	public Integer getDistrict() {
		return district;
	}

	public void setDistrict(Integer district) {
		this.district = district;
	}

	public Integer getWard() {
		return ward;
	}

	public void setWard(Integer ward) {
		this.ward = ward;
	}

	public Integer getCommunityArea() {
		return communityArea;
	}

	public void setCommunityArea(Integer communityArea) {
		this.communityArea = communityArea;
	}

	public String getFbiCode() {
		return fbiCode;
	}

	public void setFbiCode(String fbiCode) {
		this.fbiCode = fbiCode;
	}

	public Integer getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Integer getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(Integer yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
