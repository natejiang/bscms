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
@Table(name="door_to_door")
public class DoorToDoor implements java.io.Serializable{

	private static final long serialVersionUID = 48L;
	/**
	 * 上门日报表 持久化类
	 * @author Jiangnan
	 * @since 2017-04-07
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="installed_quantity",length=10)
	private Integer installedQuantity;
	@Column(name="repaired_quantity",length=10)
	private Integer repairedQuantity;
	@ManyToOne(targetEntity=ServiceCentre.class)
	@JoinColumn(name="service_centre_id")
	private ServiceCentre serviceCentre;
	@Temporal(TemporalType.DATE)
	private Date date = new Date();
	public DoorToDoor() {
	}
	public DoorToDoor(Integer id, Integer installedQuantity, Integer repairedQuantity,
			ServiceCentre serviceCentre, Date date) {
		super();
		this.id = id;
		this.installedQuantity = installedQuantity;
		this.repairedQuantity = repairedQuantity;
		this.serviceCentre = serviceCentre;
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getInstalledQuantity() {
		return installedQuantity;
	}
	public void setInstalledQuantity(Integer installedQuantity) {
		this.installedQuantity = installedQuantity;
	}
	public Integer getRepairedQuantity() {
		return repairedQuantity;
	}
	public void setRepairedQuantity(Integer repairedQuantity) {
		this.repairedQuantity = repairedQuantity;
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
