package com.reorg.repository;

import com.reorg.model.Tenant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TenantRepository {

    private final List<Tenant> tenants = new ArrayList<>();

    public List<Tenant> findAll() {
        return tenants;
    }

    public void save(Tenant tenant) {
        tenants.add(tenant);
    }
}
