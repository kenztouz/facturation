package com.ms.billing_service.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {
    private Long id;
    private Long invoiceId;
    private BigDecimal amount;
    private String status;
    private String method;
}
