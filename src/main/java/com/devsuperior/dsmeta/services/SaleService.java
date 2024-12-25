package com.devsuperior.dsmeta.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.dsmeta.dto.SaleSallerMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
	public Page<SaleMinDTO> searchByNameDates(String name, Date datainicio, Pageable pageable) {
		Page<SaleMinDTO> result = repository.searchByNameDates(name,datainicio,pageable).map(SaleMinDTO::new);
		return result;


	}
	public List<SaleSallerMinDTO> searchByNameDatesString(String name, String datainicio, String datafim ,Pageable pageable) {

		//tratamento das datas conforme requisitos do sistema
		datafim =  datafim.trim().equals("")? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()).toString():datafim;
		LocalDate ldt = LocalDate.parse(datafim);
		datainicio =  datainicio.trim().equals("")?ldt.minusYears(1).toString():datainicio;


		List<SaleSallerMinDTO> result = repository.searchByNameDatesString(name,datainicio,datafim,pageable).stream().map(SaleSallerMinDTO::new).collect(Collectors.toList());

		return result;


	}
	public List<SaleMinDTO> searchByNameDatesStringOld(String name, String datainicio, String datafim ,Pageable pageable) {

		//tratamento das datas conforme requisitos do sistema
		datafim =  datafim.trim().equals("")? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()).toString():datafim;
		LocalDate ldt = LocalDate.parse(datafim);
		datainicio =  datainicio.trim().equals("")?ldt.minusYears(1).toString():datainicio;


		//List<SaleMinDTO> result = repository.searchByNameDatesString(name,datainicio,datafim,pageable).stream().map(SaleMinDTO::new).toList();

		//return result;
		return null;


	}
}
