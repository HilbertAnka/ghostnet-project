package com.project;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.inject.Named;


public class Ghostnet implements Serializable {

	private String id;
	private String latitude;
	private String longitude;
	private String reportedAt;
	private String size;
	private String status;
	
	public Ghostnet(String id, String latitude, String longitude, String reportedAt, String size, String status) {
		
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.reportedAt = reportedAt;
		this.size = size;
		this.status = status;
		
	}
	

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getReportedAt() {
		return reportedAt;
	}
	
	public void setReportedAt(String reportedAt) {
		this.reportedAt = reportedAt;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
