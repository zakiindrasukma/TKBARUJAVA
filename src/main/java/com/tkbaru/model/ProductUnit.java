package com.tkbaru.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_product_unit")
public class ProductUnit {
	public ProductUnit() {
		
	}
	
	@Id
	@Column(name="prod_unit_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productUnitId;
	@Column(name="unit_code")
	private String unitCode;
	@Column(name="conversion_val")
	private Long conversionValue;
	@Column(name="remarks")
	private String unitRemarks;
	@Column(name="created_by")
	private int createdBy;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_by")
	private int updatedBy;
	@Column(name="updated_date")
	private Date updatedDate;

	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product productEntity;

	@ManyToOne
	@JoinColumn(name="unit_code", referencedColumnName="lookup_key", unique=true, insertable=false, updatable=false)
	private Lookup unitCodeLookup;

	public int getProductUnitId() {
		return productUnitId;
	}

	public void setProductUnitId(int productUnitId) {
		this.productUnitId = productUnitId;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public Long getConversionValue() {
		return conversionValue;
	}

	public void setConversionValue(Long conversionValue) {
		this.conversionValue = conversionValue;
	}

	public String getUnitRemarks() {
		return unitRemarks;
	}

	public void setUnitRemarks(String unitRemarks) {
		this.unitRemarks = unitRemarks;
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

	public Product getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(Product productEntity) {
		this.productEntity = productEntity;
	}
	
	public Lookup getUnitCodeLookup() {
		return unitCodeLookup;
	}

	public void setUnitCodeLookup(Lookup unitCodeLookup) {
		this.unitCodeLookup = unitCodeLookup;
	}

	@Override
	public String toString() {
		return "ProductUnit [productUnitId=" + productUnitId + ", unitCode="
				+ unitCode + ", conversionValue=" + conversionValue
				+ ", unitRemarks=" + unitRemarks + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + "]";
	}

}