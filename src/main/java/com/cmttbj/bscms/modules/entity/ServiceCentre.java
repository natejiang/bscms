package com.cmttbj.bscms.modules.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="service_centre")
public class ServiceCentre implements Serializable{

	/**
	 * @author Jiangnan
	 * @date 2017-04-10
	 */
	private static final long serialVersionUID = 48L;
	
	@Id @Column(name="service_centre_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer serviceCentreId;
	@Column(name="service_centre_name", length=50)
	private String serviceCentreName;
	//服务中心对应的分公司
	@Column(name="company", length=50)
	private String company;
	@OneToMany(targetEntity=UserInfo.class,mappedBy="serviceCentre")
	private Set<UserInfo> userInfos = new HashSet<>();
	public ServiceCentre() {
	}

	public ServiceCentre(Integer serviceCentreId, String serviceCentreName, String company) {
		super();
		this.serviceCentreId = serviceCentreId;
		this.serviceCentreName = serviceCentreName;
		this.company = company;
	}

	public Integer getServiceCentreId() {
		return serviceCentreId;
	}

	public void setServiceCentreId(Integer serviceCentreId) {
		this.serviceCentreId = serviceCentreId;
	}

	public String getServiceCentreName() {
		return serviceCentreName;
	}

	public void setServiceCentreName(String serviceCentreName) {
		this.serviceCentreName = serviceCentreName;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public Set<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(Set<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	@Override
	public String toString() {
		return serviceCentreId + " " + serviceCentreName;
	}
}
