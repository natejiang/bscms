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
@Table(name="mobile_product")
public class MobileProduct implements java.io.Serializable{

	private static final long serialVersionUID = 48L;
	/**
	 * 称动业务日报表 持久化类
	 * @author Jiangnan
	 * @since 2017-04-07
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="sim_quantity",length=10,nullable=false,columnDefinition="INT default 0")
	private Integer simQuantity = 0;
	@Column(name="terminal_quantity",length=10,nullable=false,columnDefinition="INT default 0")
	private Integer terminalQuantity = 0;
	@Column(name="television_quantity",length=10,nullable=false,columnDefinition="INT default 0")
	private Integer televisionQuantity = 0;
	@ManyToOne(targetEntity=ServiceCentre.class)
	@JoinColumn(name="service_centre_id")
	private ServiceCentre serviceCentre;
	@Temporal(TemporalType.DATE)
	private Date date = new Date();
	public MobileProduct() {
	}
	public MobileProduct(Integer id, Integer simQuantity, Integer terminalQuantity, Integer televisionQuantity,
			ServiceCentre serviceCentre, Date date) {
		super();
		this.id = id;
		this.simQuantity = simQuantity;
		this.terminalQuantity = terminalQuantity;
		this.televisionQuantity = televisionQuantity;
		this.serviceCentre = serviceCentre;
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSimQuantity() {
		return simQuantity;
	}
	public void setSimQuantity(Integer simQuantity) {
		this.simQuantity = simQuantity;
	}
	public Integer getTerminalQuantity() {
		return terminalQuantity;
	}
	public void setTerminalQuantity(Integer terminalQuantity) {
		this.terminalQuantity = terminalQuantity;
	}
	public Integer getTelevisionQuantity() {
		return televisionQuantity;
	}
	public void setTelevisionQuantity(Integer televisionQuantity) {
		this.televisionQuantity = televisionQuantity;
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
