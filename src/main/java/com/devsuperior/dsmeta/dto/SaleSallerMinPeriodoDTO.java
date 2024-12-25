package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SalesSallerMinPeriodoProjection;
import com.devsuperior.dsmeta.projections.SalesSallerMinProjection;

import java.time.LocalDate;

public class SaleSallerMinPeriodoDTO {

	private Double amount;
	private String sellerName;

	public SaleSallerMinPeriodoDTO(SalesSallerMinPeriodoProjection salesSallerMinPeriodoProjection) {
		this.amount = salesSallerMinPeriodoProjection.getAmount();
		this.sellerName = salesSallerMinPeriodoProjection.getName();
	}

	public SaleSallerMinPeriodoDTO(Long id, Integer visited, Integer deals, Double amount, LocalDate date, String name, Long seller_id) {
		this.amount = amount;
		this.sellerName = name;
	}

	public SaleSallerMinPeriodoDTO(Long id, Double amount, LocalDate date) {
		this.amount = amount;
	}

	public SaleSallerMinPeriodoDTO(Long id, Double amount, LocalDate date, String nameSeller) {
		this.amount = amount;
		this.sellerName = nameSeller;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public Double getAmount() {
		return amount;
	}

}
