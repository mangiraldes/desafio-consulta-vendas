package com.devsuperior.dsmeta.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(nativeQuery = true,value="select a.id,a.visited,a.deals,a.amount,a.date,a.seller_id from tb_sales a" +
            " INNER JOIN tb_seller b on a.seller_id = b.id " +
            " WHERE a.date >= :datainicio" +
            " AND UPPER(b.name) like UPPER(CONCAT('%',:name,'%'))")
    Page<Sale> searchByNameDates(String name, Date datainicio, Pageable pageable);

    @Query(nativeQuery = true,value="select tb_sales.id,tb_sales.visited,tb_sales.deals,tb_sales.amount,tb_sales.date,tb_sales.seller_id, tb_seller.name" +
            " from tb_sales " +
            " INNER JOIN tb_seller " +
            " ON tb_sales.seller_id = tb_seller.id " +
            " WHERE tb_sales.date >= CAST('2024-05-18' AS DATE)" )
    List<Sale> searchByNameDatesStringOld(Pageable pageable);



 @Query(nativeQuery = true,value="select a.id,a.visited,a.deals,a.amount,a.date,a.seller_id from tb_sales a" +
            " INNER JOIN tb_seller b on a.seller_id = b.id " +
            " WHERE a.date >= CAST(:datainicio AS DATE)" +
            " AND  a.date <= CAST(:datafim AS DATE)" +
            " AND UPPER(b.name) like UPPER(CONCAT('%',:name,'%'))")
 List<Sale> searchByNameDatesString(String name, String datainicio, String datafim ,Pageable pageable);



}

