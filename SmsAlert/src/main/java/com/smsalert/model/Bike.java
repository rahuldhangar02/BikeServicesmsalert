package com.smsalert.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="serviceinfo")

public class Bike {

	      @Id
	      @GeneratedValue(strategy = GenerationType.AUTO)
	      @Column(name="id")
	      private int id;
	      @Column(name="name",nullable = false)
	      private String name;
	      @Column(name="addres",nullable = false)
	      private String address;
	      @Column(name="mobileNo",precision = 10)
	      private long mobileNo;
	      @Column(name="vehicle")
	      private String vehicleNo;
	      @Column(name="mecanicName")
	      private String mecanicName;
	      @Column(name="serviceDate")
	      @DateTimeFormat(pattern = "dd/MM/yyyy")
	      private String serviceDate;
	      @Column(name="serviceTime")
	      private String serviceTime;
	      @Column(name="nextServiceDate")
	      @DateTimeFormat(pattern = "yyyy/MM/dd")
	     
	      private String nextServiceDate;
		public Bike() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Bike(int id, String name, String address, long mobileNo, String vehicleNo, String mecanicName,
				String serviceDate, String serviceTime, String nextServiceDate) {
			super();
			this.id = id;
			this.name = name;
			this.address = address;
			this.mobileNo = mobileNo;
			this.vehicleNo = vehicleNo;
			this.mecanicName = mecanicName;
			this.serviceDate = serviceDate;
			this.serviceTime = serviceTime;
			this.nextServiceDate = nextServiceDate;
		}
		public Bike(String name, String address, long mobileNo, String vehicleNo, String mecanicName,
				String serviceDate, String serviceTime, String nextServiceDate) {
			super();
			this.name = name;
			this.address = address;
			this.mobileNo = mobileNo;
			this.vehicleNo = vehicleNo;
			this.mecanicName = mecanicName;
			this.serviceDate = serviceDate;
			this.serviceTime = serviceTime;
			this.nextServiceDate = nextServiceDate;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public long getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(long mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getVehicleNo() {
			return vehicleNo;
		}
		public void setVehicleNo(String vehicleNo) {
			this.vehicleNo = vehicleNo;
		}
		public String getMecanicName() {
			return mecanicName;
		}
		public void setMecanicName(String mecanicName) {
			this.mecanicName = mecanicName;
		}
		public String getServiceDate() {
			return serviceDate;
		}
		public void setServiceDate(String serviceDate) {
			this.serviceDate = serviceDate;
		}
		public String getServiceTime() {
			return serviceTime;
		}
		public void setServiceTime(String serviceTime) {
			this.serviceTime = serviceTime;
		}
		public String getNextServiceDate() {
			return nextServiceDate;
		}
		public void setNextServiceDate(String nextServiceDate) {
			this.nextServiceDate = nextServiceDate;
		}
		@Override
		public String toString() {
			return "BikeService [id=" + id + ", name=" + name + ", address=" + address + ", mobileNo=" + mobileNo
					+ ", vehicleNo=" + vehicleNo + ", mecanicName=" + mecanicName + ", serviceDate=" + serviceDate
					+ ", serviceTime=" + serviceTime + ", nextServiceDate=" + nextServiceDate + "]";
		}
	      
	      
	
}
