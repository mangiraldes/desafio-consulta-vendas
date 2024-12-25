package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SalesSallerMinProjection;

import java.time.LocalDate;

public class SaleSallerMinDTO {

	private Long id;
	private Double amount;
	private LocalDate date;
	private String sellerName;

	public SaleSallerMinDTO(SalesSallerMinProjection salesSallerMinProjection) {
		this.id = salesSallerMinProjection.getId();
		this.amount = salesSallerMinProjection.getAmount();
		this.date = salesSallerMinProjection.getDate();
		this.sellerName = salesSallerMinProjection.getName();

	}

	public SaleSallerMinDTO(Long id, Integer visited, Integer deals, Double amount, LocalDate date, String name, Long seller_id) {
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.sellerName = name;
	}

	public SaleSallerMinDTO(Long id, Double amount, LocalDate date) {
		this.id = id;
		this.amount = amount;
		this.date = date;
	}

	public SaleSallerMinDTO(Sale entity) {
		id = entity.getId();
		amount = entity.getAmount();
		date = entity.getDate();
	}

	public SaleSallerMinDTO(Long id, Double amount, LocalDate date, String nameSeller) {
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.sellerName = nameSeller;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public Long getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}
}
