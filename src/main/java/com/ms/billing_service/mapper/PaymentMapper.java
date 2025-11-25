package com.ms.billing_service.mapper;

import com.ms.billing_service.dto.PaymentDTO;
import com.ms.billing_service.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    PaymentDTO toDto(Payment payment);
    Payment toEntity(PaymentDTO dto);
}
