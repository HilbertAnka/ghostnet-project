package com.project;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
public class Ghostnet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double latitude;
	private Double longitude;
	private java.util.Date reportedAt;
	private Integer size;
	private String status;
	
	//leerer Konstruktor
	public Ghostnet() {
			
	}
		
	//Getter und Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	
	public java.util.Date getReportedAt() {
		return reportedAt;
	}
	public void setReportedAt(java.util.Date reportedAt) {
		this.reportedAt = reportedAt;
	}


	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	public Ghostnet(Double latitude, Double longitude, java.util.Date reportedAt, Integer size, String status) {
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.reportedAt = reportedAt;
		this.size = size;
		this.status = status;
		
	}
	

}
