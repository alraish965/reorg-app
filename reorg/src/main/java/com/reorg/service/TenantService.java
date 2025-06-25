package com.reorg.service;

import com.reorg.model.Tenant;
import com.reorg.repository.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {

    private final TenantRepository tenantRepository;

    // Constructor injection
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public void addTenant(Tenant tenant) {
        tenantRepository.save(tenant);
    }
}
