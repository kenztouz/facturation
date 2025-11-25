package com.ms.billing_service.mapper;

import com.ms.billing_service.dto.InvoiceDTO;
import com.ms.billing_service.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    InvoiceDTO toDto(Invoice invoice);
    Invoice toEntity(InvoiceDTO dto);
}
