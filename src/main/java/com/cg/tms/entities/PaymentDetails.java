package com.cg.tms.entities;

import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PaymentDetails {

	@GeneratedValue
	@Id
	private int paymentId;
	private String paymentMode;
	private String bankName;
	private long cardNo;
	private double netAmount;
	private String paymentStatus;
	private int userId;
	
	@OneToOne
	private Package1 pack;
	
	public PaymentDetails() {

	}
	
	//Constructor without Id and package
	public PaymentDetails(String paymentMode, String bankName, long cardNo, double netAmount, String paymentStatus,
			int userId) {
		this.paymentMode = paymentMode;
		this.bankName = bankName;
		this.cardNo = cardNo;
		this.netAmount = netAmount;
		this.paymentStatus = paymentStatus;
		this.userId = userId;
	}

	public int getPaymentId() {

		return paymentId;
	}

	public void setPaymentId(int paymentId) {

		this.paymentId = paymentId;
	}

	public String getPaymentMode() {

		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {

		this.paymentMode = paymentMode;
	}

	public String getBankName() {

		return bankName;
	}

	public void setBankName(String bankName) {

		this.bankName = bankName;
	}

	public long getCardNo() {

		return cardNo;
	}

	public void setCardNo(long cardNo) {

		this.cardNo = cardNo;
	}

	public double getNetAmount() {

		return netAmount;
	}

	public void setNetAmount(double netAmount) {

		this.netAmount = netAmount;
	}

	public String getPaymentStatus() {

		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {

		this.paymentStatus = paymentStatus;
	}

	public int getUserId() {

		return userId;
	}

	public void setUserId(int userId) {

		this.userId = userId;
	}

	@Override
	public String toString() {

		return "PaymentDetails [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", bankName=" + bankName
				+ ", cardNo=" + cardNo + ", netAmount=" + netAmount + ", paymentStatus=" + paymentStatus + ", userId="
				+ userId + "]";
	}

	//Getter and Setter for package
	public Package1 getPack() {
		return pack;
	}

	public void setPack(Package1 pack) {
		this.pack = pack;
	}
	
	//add method for Package Details
	public void addPackage(Package1 pack)
	{
		pack.setPayment(this);
		this.setPack(pack);
	}
	
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentDetails other = (PaymentDetails) obj;
		if (paymentId != other.paymentId)
			return false;
		return true;
	}

}

