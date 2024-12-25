package com.devsuperior.dsmeta.projections;

import java.time.LocalDate;

public interface SalesSallerMinProjection {

    Long getId();
    Integer getVisited();
    Integer getDeals();
    Double getAmount();
    LocalDate getDate();
    String getName();
    Long getSeller_id();


}
