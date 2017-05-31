package com.cmttbj.bscms.modules.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customer")
public class Customer implements java.io.Serializable{

	private static final long serialVersionUID = 48L;	
	/**
	 * 客流日报表 持久化类
	 * @author Jiangnan
	 * @since 2017-04-08
	 */	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="customer_quantity",length=10,nullable=false,columnDefinition="INT default 0")
	private Integer customerQuantity = 0;
	@ManyToOne(targetEntity=ServiceCentre.class)
	@JoinColumn(name="service_centre_id")
	private ServiceCentre serviceCentre;
	@Temporal(TemporalType.DATE)
	private Date date = new Date();
	
	public Customer()
	{		
	}
	public Customer(Integer id, Integer customerQuantity, ServiceCentre serviceCentre, Date date) {
		super();
		this.id = id;
		this.customerQuantity = customerQuantity;
		this.serviceCentre = serviceCentre;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerQuantity() {
		return customerQuantity;
	}

	public void setCustomerQuantity(Integer customerQuantity) {
		this.customerQuantity = customerQuantity;
	}

	public ServiceCentre getServiceCentre() {
		return serviceCentre;
	}

	public void setServiceCentre(ServiceCentre serviceCentre) {
		this.serviceCentre = serviceCentre;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
