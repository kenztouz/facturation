package com.ms.billing_service.service;

import com.ms.billing_service.dto.PaymentDTO;
import com.ms.billing_service.entity.Payment;
import com.ms.billing_service.mapper.PaymentMapper;
import com.ms.billing_service.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private final PaymentRepository repo;
    private final PaymentMapper mapper;

    public PaymentService(PaymentRepository repo, PaymentMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public PaymentDTO create(PaymentDTO dto) {
        Payment saved = repo.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }

    public PaymentDTO findById(Long id) {
        return repo.findById(id).map(mapper::toDto).orElse(null);
    }

    public List<PaymentDTO> findAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public PaymentDTO update(Long id, PaymentDTO dto) {
        return repo.findById(id).map(existing -> {
            Payment toUpdate = mapper.toEntity(dto);
            toUpdate.setId(id);
            return mapper.toDto(repo.save(toUpdate));
        }).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
