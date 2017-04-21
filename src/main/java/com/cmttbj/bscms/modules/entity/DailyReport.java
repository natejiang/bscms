package com.cmttbj.bscms.modules.entity;

public class DailyReport implements java.io.Serializable {

	private static final long serialVersionUID = 48L;
	/**
	 * 个人汇总实体类
	 * @author Jiangnan
	 * @date 2017-04-08
	 */
	
	public DailyReport() {}
	private Customer customer;
	private DoorToDoor doorToDoor;
	private MobileProduct mobileProduct;
	private NewBroadband newBroadband;
	private RenewBroadband renewBroadband;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public DoorToDoor getDoorToDoor() {
		return doorToDoor;
	}
	public void setDoorToDoor(DoorToDoor doorToDoor) {
		this.doorToDoor = doorToDoor;
	}
	public MobileProduct getMobileProduct() {
		return mobileProduct;
	}
	public void setMobileProduct(MobileProduct mobileProduct) {
		this.mobileProduct = mobileProduct;
	}
	public NewBroadband getNewBroadband() {
		return newBroadband;
	}
	public void setNewBroadband(NewBroadband newBroadband) {
		this.newBroadband = newBroadband;
	}
	public RenewBroadband getRenewBroadband() {
		return renewBroadband;
	}
	public void setRenewBroadband(RenewBroadband renewBroadband) {
		this.renewBroadband = renewBroadband;
	}
	
}
