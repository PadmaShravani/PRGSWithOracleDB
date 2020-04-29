package com.prgs.PublicRaiseGovernamentSolve.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Service")
public class ServiceModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serviceId;
	@Basic
	@Column
	private String description;
	@Basic
	@Column(nullable = false, length = 50)
	private String status;
	@Basic
	@Column(nullable = false, length = 10)
	private int priorityLevel;
	@Basic
	@Column(length = 100)
	private String ticketNumbers;
	@Basic
	@Column
	private int departmentId;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="serviceId",referencedColumnName="serviceId")
	private List<TicketDetails> listOfticket;
	
	 @OneToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name = "departmentId",referencedColumnName="departmentId",insertable = false, updatable = false)
	  private Department department;

	public ServiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceModel(int serviceId, String description, String status, int level, String ticketNumbers, int departmentId,
			List<TicketDetails> listOfticket, Department department) {
		super();
		this.serviceId = serviceId;
		this.description = description;
		this.status = status;
		this.priorityLevel = level;
		this.ticketNumbers = ticketNumbers;
		this.departmentId = departmentId;
		this.listOfticket = listOfticket;
		this.department = department;
	}

	public int getServiceId() {
		return serviceId;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public int getLevel() {
		return priorityLevel;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public List<TicketDetails> getListOfticket() {
		return listOfticket;
	}

	public Department getDepartment() {
		return department;
	}
	
	public String getTicketNumbers() {
		return ticketNumbers;
	}

	public void setTicketNumbers(String ticketNumbers) {
		this.ticketNumbers = ticketNumbers;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setLevel(int level) {
		this.priorityLevel = level;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public void setListOfticket(List<TicketDetails> listOfticket) {
		this.listOfticket = listOfticket;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	
}
