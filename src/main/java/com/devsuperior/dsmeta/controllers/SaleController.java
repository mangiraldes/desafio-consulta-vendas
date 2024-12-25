package com.devsuperior.dsmeta.controllers;

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

	@GetMapping(value = "/reportss")
	public ResponseEntity<Page<SaleMinDTO>> getReports(@RequestParam(name="name",defaultValue = "")String name,
													  @RequestParam("datainicio")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datainicio, Pageable pageable){

		return ResponseEntity.ok(service.searchByNameDates(name,datainicio,pageable));
	}
	@GetMapping(value = "/report")
	public ResponseEntity<List<SaleMinDTO>> getReport(@RequestParam(name="name",defaultValue = "")String name,
													  @RequestParam(name="datainicio",defaultValue = "")String datainicio,
													  @RequestParam(name="datafim",defaultValue = "")String datafim,
													  Pageable pageable){

		return ResponseEntity.ok(service.searchByNameDatesString(name,datainicio,datafim, pageable));
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<?> getSummary() {
		// TODO
		return null;
	}
}
