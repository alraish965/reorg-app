package com.reorg.controller;

import com.reorg.model.Tenant;
import com.reorg.service.TenantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    // جلب جميع المستأجرين
    @GetMapping
    public List<Tenant> getAllTenants() {
        return tenantService.getAllTenants();
    }

    // إضافة مستأجر جديد
    @PostMapping
    public void addTenant(@RequestBody Tenant tenant) {
        tenantService.addTenant(tenant);
    }
}
