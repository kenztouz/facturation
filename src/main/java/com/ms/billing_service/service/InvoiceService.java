package com.ms.billing_service.service;

import com.ms.billing_service.dto.InvoiceDTO;
import com.ms.billing_service.entity.Invoice;
import com.ms.billing_service.mapper.InvoiceMapper;
import com.ms.billing_service.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    private final InvoiceRepository repo;
    private final InvoiceMapper mapper;

    public InvoiceService(InvoiceRepository repo, InvoiceMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public InvoiceDTO create(InvoiceDTO dto) {
        Invoice saved = repo.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }

    public InvoiceDTO findById(Long id) {
        return repo.findById(id).map(mapper::toDto).orElse(null);
    }

    public List<InvoiceDTO> findAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public InvoiceDTO update(Long id, InvoiceDTO dto) {
        return repo.findById(id).map(existing -> {
            Invoice toUpdate = mapper.toEntity(dto);
            toUpdate.setId(id);
            return mapper.toDto(repo.save(toUpdate));
        }).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
