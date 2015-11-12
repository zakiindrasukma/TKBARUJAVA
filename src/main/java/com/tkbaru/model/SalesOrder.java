package com.tkbaru.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="tb_so")
@SuppressWarnings("unchecked")
public class SalesOrder implements Serializable {
	private static final long serialVersionUID = -906634449231153892L;

	public SalesOrder() {
		
	}

	@Id
	@Column(name="so_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int salesId;	
	@Column(name="so_code")
	private String salesCode;
	@Column(name="so_created")
	private Date salesCreatedDate;
	@Column(name="shipping_date")
	private Date shippingDate;
	@Column(name="walk_in_cust_det")
	private String walkInCustDetail;
	@Column(name="remarks")
	private String salesRemarks;
	@Column(name="created_by")
	private int createdBy;
	@Column(name="created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name="updated_by")
	private int updatedBy;
	@Column(name="updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="tb_so_items", 
				joinColumns={@JoinColumn(name="so_id", referencedColumnName="so_id")},
				inverseJoinColumns={@JoinColumn(name="items_id", referencedColumnName="items_id")})
	private List<Items> itemsList = LazyList.decorate(new ArrayList<Items>(), FactoryUtils.instantiateFactory(Items.class));

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="tb_so_payment", 
				joinColumns={@JoinColumn(name="so_id", referencedColumnName="so_id")},
				inverseJoinColumns={@JoinColumn(name="payment_id", referencedColumnName="payment_id")})
	private List<Payment> paymentList = LazyList.decorate(new ArrayList<Payment>(), FactoryUtils.instantiateFactory(Payment.class));

	@ManyToOne
	@JoinColumn(name="customer_id")
	@NotFound(action=NotFoundAction.IGNORE)
	private Customer customerEntity;

	@ManyToOne
	@JoinColumn(name="store_id")
	private Lookup salesStoreEntity;

	@ManyToOne
	@JoinColumn(name="status", referencedColumnName="lookup_key")
	private Lookup salesStatusLookup;
	
	@ManyToOne
	@JoinColumn(name="so_type", referencedColumnName="lookup_key")
	private Lookup salesTypeLookup;

	@Transient
	private String customerSearchQuery;
	@Transient
	private List<Customer> customerSearchResults;

	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	public String getSalesCode() {
		return salesCode;
	}
	public void setSalesCode(String salesCode) {
		this.salesCode = salesCode;
	}
	public Date getSalesCreatedDate() {
		return salesCreatedDate;
	}
	public void setSalesCreatedDate(Date salesCreatedDate) {
		this.salesCreatedDate = salesCreatedDate;
	}
	public Date getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	public String getWalkInCustDetail() {
		return walkInCustDetail;
	}
	public void setWalkInCustDetail(String walkInCustDetail) {
		this.walkInCustDetail = walkInCustDetail;
	}
	public String getSalesRemarks() {
		return salesRemarks;
	}
	public void setSalesRemarks(String salesRemarks) {
		this.salesRemarks = salesRemarks;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public List<Items> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}
	public List<Payment> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}
	public Customer getCustomerEntity() {
		return customerEntity;
	}
	public void setCustomerEntity(Customer customerEntity) {
		this.customerEntity = customerEntity;
	}
	public Lookup getSalesStoreEntity() {
		return salesStoreEntity;
	}
	public void setSalesStoreEntity(Lookup salesStoreEntity) {
		this.salesStoreEntity = salesStoreEntity;
	}
	public Lookup getSalesStatusLookup() {
		return salesStatusLookup;
	}
	public void setSalesStatusLookup(Lookup salesStatusLookup) {
		this.salesStatusLookup = salesStatusLookup;
	}
	public Lookup getSalesTypeLookup() {
		return salesTypeLookup;
	}
	public void setSalesTypeLookup(Lookup salesTypeLookup) {
		this.salesTypeLookup = salesTypeLookup;
	}
	public String getCustomerSearchQuery() {
		return customerSearchQuery;
	}
	public void setCustomerSearchQuery(String customerSearchQuery) {
		this.customerSearchQuery = customerSearchQuery;
	}
	public List<Customer> getCustomerSearchResults() {
		return customerSearchResults;
	}
	public void setCustomerSearchResults(List<Customer> customerSearchResults) {
		this.customerSearchResults = customerSearchResults;
	}
	@Override
	public String toString() {
		return "SalesOrder [salesId=" + salesId + ", salesCode=" + salesCode + ", salesCreatedDate=" + salesCreatedDate
				+ ", shippingDate=" + shippingDate + ", walkInCustDetail=" + walkInCustDetail + ", salesRemarks="
				+ salesRemarks + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + ", itemsList=" + itemsList + ", paymentList="
				+ paymentList + ", customerEntity=" + customerEntity + ", salesStoreEntity=" + salesStoreEntity
				+ ", salesStatusLookup=" + salesStatusLookup + ", salesTypeLookup=" + salesTypeLookup
				+ ", customerSearchQuery=" + customerSearchQuery + ", customerSearchResults=" + customerSearchResults
				+ "]";
	}

}
