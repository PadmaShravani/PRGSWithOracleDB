package com.prgs.PublicRaiseGovernamentSolve.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TicktDetails")
public class TicketDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int Id;
	@Basic
	@Column(name="ticketType",length=50,nullable=false)
	private String ticketType;
	@Basic
	@Column(name="userId")
	private int userId;
	@Basic
	@Column(name="complaintType",nullable=false)
	private String complaintType;
	@Basic
	@Column(name="description",nullable=false)
	private String description;
	@Basic
	@Column(name="geoLocation")
	private String geoLocation;
	@Basic
	@Column(name="photo")
	private String photo;
	@Basic
	@Column(name="city",length=50)
	private String city;
	@Basic
	@Column(name="street",length=50)
	private String street;
	@Basic
	@Column(name="zipCode",length=10)
	private int zipCode;
	@Basic
	@Column(name="status",length=20)
	private String status;
	@Basic
	@Column(name="serviceId")
	private int serviceId;

	//Constructors
	public TicketDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TicketDetails(int ticketId, String ticketType, int userId, String complaintType, String description,
			String geoLocation, String photo, String status) {
		super();
		this.Id = ticketId;
		this.ticketType = ticketType;
		this.userId = userId;
		this.complaintType = complaintType;
		this.description = description;
		this.geoLocation = geoLocation;
		this.photo = photo;
		this.status = status;
	}

	public TicketDetails(int ticketId, String ticketType, int userId, String complaintType, String description,
			String geoLocation, String photo, String city, String street, int zipCode, String status, int serviceId) {
		super();
		this.Id = ticketId;
		this.ticketType = ticketType;
		this.userId = userId;
		this.complaintType = complaintType;
		this.description = description;
		this.geoLocation = geoLocation;
		this.photo = photo;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.status = status;
	}

	//Getters and Setters
	public int getId() {
		return Id;
	}

	public String getTicketType() {
		return ticketType;
	}

	public int getUserId() {
		return userId;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public String getDescription() {
		return description;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public String getPhoto() {
		return photo;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public int getZipCode() {
		return zipCode;
	}

	public String getStatus() {
		return status;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setId(int id) {
		Id = id;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

}

