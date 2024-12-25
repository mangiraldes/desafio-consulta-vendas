package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SaleSallerMinDTO;
import com.devsuperior.dsmeta.dto.SaleSallerMinPeriodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<List<SaleSallerMinPeriodoDTO>> getSummary(@RequestParam(name="minDate",defaultValue = "")String minDate,
																	@RequestParam(name="maxDate",defaultValue = "")String maxDate,
																	Pageable pageable){

		return ResponseEntity.ok(service.searchBySumPeriod(minDate,maxDate,pageable));
	}


	@GetMapping(value = "/report")
	public ResponseEntity<List<SaleSallerMinDTO>> getReport(@RequestParam(name="name",defaultValue = "")String name,
															@RequestParam(name="minDate",defaultValue = "")String minDate,
															@RequestParam(name="maxDate",defaultValue = "")String maxDate,
															Pageable pageable){

		return ResponseEntity.ok(service.searchByNameDatesString(name,minDate,maxDate, pageable));
	}


}
