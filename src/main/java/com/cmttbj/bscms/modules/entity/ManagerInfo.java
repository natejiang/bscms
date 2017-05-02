package com.cmttbj.bscms.modules.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="2")
public class ManagerInfo extends UserInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 48L;
	@Column(name="company",length=50)
	private String company;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
}
