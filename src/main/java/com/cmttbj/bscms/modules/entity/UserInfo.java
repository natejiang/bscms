package com.cmttbj.bscms.modules.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@DiscriminatorColumn(name="user_type", discriminatorType=DiscriminatorType.INTEGER)
@DiscriminatorValue(value="1")
public class UserInfo implements Serializable{
	/**
	 * 用户持久化类
	 * @author Jiangnan
	 * @since 2017-04-07
	 */
	private static final long serialVersionUID = 48L;
	@Id @Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	@Column(name="username",length=10)
	private String username;
	@Column(name="password",length=50)
	private String password;
	@Column(name="fullname")
	private String fullname;
	//用户归属的服务中心
	@ManyToOne(targetEntity=ServiceCentre.class)
	@JoinColumn(name="service_centre_id")
	private ServiceCentre serviceCentre;
	
	public UserInfo() {		
	}
	
	public UserInfo(Integer userId, String username, String password, String fullname, ServiceCentre serviceCentre) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.serviceCentre = serviceCentre;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public ServiceCentre getServiceCentre() {
		return serviceCentre;
	}

	public void setServiceCentre(ServiceCentre serviceCentre) {
		this.serviceCentre = serviceCentre;
	}
		
}
