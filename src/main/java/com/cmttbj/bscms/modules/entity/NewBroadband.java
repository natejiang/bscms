package com.cmttbj.bscms.modules.entity;

import java.io.Serializable;
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
@Table(name="new_broadband")
public class NewBroadband implements Serializable{

	private static final long serialVersionUID = 48L;
	/**
	 * 新装宽带日报表 持久化类
	 * @author Jiangnan
	 * @since 2017-04-07
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="ihome_broadband_quantity_20",length=10)
	private Integer ihomeBroadbandQuantity20;
	@Column(name="ihome_broadband_quantity_30",length=10)
	private Integer ihomeBroadbandQuantity30;
	@Column(name="ihome_broadband_quantity_50",length=10)
	private Integer ihomeBroadbandQuantity50;
	@Column(name="ihome_broadband_quantity_100",length=10)
	private Integer ihomeBroadbandQuantity100;
	@Column(name="only_broadband_quantity_20",length=10)
	private Integer onlyBroadbandQuantity20;
	@Column(name="only_broadband_quantity_30",length=10)
	private Integer onlyBroadbandQuantity30;
	@Column(name="only_broadband_quantity_50",length=10)
	private Integer onlyBroadbandQuantity50;
	@Column(name="only_broadband_quantity_100",length=10)
	private Integer onlyBroadbandQuantity100;
	@ManyToOne(targetEntity=ServiceCentre.class)
	@JoinColumn(name="service_centre_id")
	private ServiceCentre serviceCentre;
	@Temporal(TemporalType.DATE)
	private Date date = new Date();
	
	public NewBroadband() {
	}
	
	public NewBroadband(Integer id, Integer ihomeBroadbandQuantity20, Integer ihomeBroadbandQuantity30,
			Integer ihomeBroadbandQuantity50, Integer ihomeBroadbandQuantity100, Integer onlyBroadbandQuantity20,
			Integer onlyBroadbandQuantity30, Integer onlyBroadbandQuantity50, Integer onlyBroadbandQuantity100,
			ServiceCentre serviceCentre, Date date) {
		super();
		this.id = id;
		this.ihomeBroadbandQuantity20 = ihomeBroadbandQuantity20;
		this.ihomeBroadbandQuantity30 = ihomeBroadbandQuantity30;
		this.ihomeBroadbandQuantity50 = ihomeBroadbandQuantity50;
		this.ihomeBroadbandQuantity100 = ihomeBroadbandQuantity100;
		this.onlyBroadbandQuantity20 = onlyBroadbandQuantity20;
		this.onlyBroadbandQuantity30 = onlyBroadbandQuantity30;
		this.onlyBroadbandQuantity50 = onlyBroadbandQuantity50;
		this.onlyBroadbandQuantity100 = onlyBroadbandQuantity100;
		this.serviceCentre = serviceCentre;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIhomeBroadbandQuantity20() {
		return ihomeBroadbandQuantity20;
	}
	public void setIhomeBroadbandQuantity20(Integer ihomeBroadbandQuantity20) {
		this.ihomeBroadbandQuantity20 = ihomeBroadbandQuantity20;
	}
	public Integer getIhomeBroadbandQuantity30() {
		return ihomeBroadbandQuantity30;
	}
	public void setIhomeBroadbandQuantity30(Integer ihomeBroadbandQuantity30) {
		this.ihomeBroadbandQuantity30 = ihomeBroadbandQuantity30;
	}
	public Integer getIhomeBroadbandQuantity50() {
		return ihomeBroadbandQuantity50;
	}
	public void setIhomeBroadbandQuantity50(Integer ihomeBroadbandQuantity50) {
		this.ihomeBroadbandQuantity50 = ihomeBroadbandQuantity50;
	}
	public Integer getIhomeBroadbandQuantity100() {
		return ihomeBroadbandQuantity100;
	}
	public void setIhomeBroadbandQuantity100(Integer ihomeBroadbandQuantity100) {
		this.ihomeBroadbandQuantity100 = ihomeBroadbandQuantity100;
	}
	public Integer getOnlyBroadbandQuantity20() {
		return onlyBroadbandQuantity20;
	}
	public void setOnlyBroadbandQuantity20(Integer onlyBroadbandQuantity20) {
		this.onlyBroadbandQuantity20 = onlyBroadbandQuantity20;
	}
	public Integer getOnlyBroadbandQuantity30() {
		return onlyBroadbandQuantity30;
	}
	public void setOnlyBroadbandQuantity30(Integer onlyBroadbandQuantity30) {
		this.onlyBroadbandQuantity30 = onlyBroadbandQuantity30;
	}
	public Integer getOnlyBroadbandQuantity50() {
		return onlyBroadbandQuantity50;
	}
	public void setOnlyBroadbandQuantity50(Integer onlyBroadbandQuantity50) {
		this.onlyBroadbandQuantity50 = onlyBroadbandQuantity50;
	}
	public Integer getOnlyBroadbandQuantity100() {
		return onlyBroadbandQuantity100;
	}
	public void setOnlyBroadbandQuantity100(Integer onlyBroadbandQuantity100) {
		this.onlyBroadbandQuantity100 = onlyBroadbandQuantity100;
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
