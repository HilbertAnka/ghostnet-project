package com.project;

import java.io.Serializable;
import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Ghostnet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double latitude;
	private Double longitude;
	@PastOrPresent(message = "Das Sichtungsdatum darf nicht in der Zukunft liegen.")
	private LocalDate reportedAt;
	private Integer size;
	 @Enumerated(EnumType.STRING)
	private GhostnetStatus status;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "assigned_to_id")
	private User assignedTo;
	

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

	
	public LocalDate getReportedAt() {
		return reportedAt;
	}
	public void setReportedAt(LocalDate reportedAt) {
		this.reportedAt = reportedAt;
	}


	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}


	public GhostnetStatus getStatus() {
		return status;
	}

	public void setStatus(GhostnetStatus status) {
		this.status = status;
	}
	
	
	public User getAssignedTo() {
		return assignedTo;
	}

	 public void setAssignedTo(User assignedTo) {
		 this.assignedTo = assignedTo;
	}
	
	
	
	
	public Ghostnet(Double latitude, Double longitude, LocalDate reportedAt, Integer size, GhostnetStatus status, User assignedTo) {
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.reportedAt = reportedAt;
		this.size = size;
		this.status = status;
		this.assignedTo = assignedTo;
		
	}
	

}
