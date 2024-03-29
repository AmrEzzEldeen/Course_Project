package com.course.facilitiesreservation.controller;

import com.course.facilitiesreservation.dto.TenantDTO;
import com.course.facilitiesreservation.entity.Tenant;
import com.course.facilitiesreservation.service.TenantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping
    public ResponseEntity<List<Tenant>> getAllTenants() {
        return tenantService.getAllTenants();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Tenant>> getTenantsByUserName(@RequestParam("name") String tenantName) {
        return new ResponseEntity<>(tenantService.getTenantsByUserName(tenantName), HttpStatus.OK);
    }

    @PostMapping("/{unitId}")
    public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant, @PathVariable Long unitId) {
        return new ResponseEntity<>(tenantService.createTenant(tenant, unitId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{tenantID}")
    public ResponseEntity<String> deleteTenantById(@PathVariable Long tenantID) {
        tenantService.deleteTenantById(tenantID);
        return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{tenantID}")
    public ResponseEntity<Tenant> updateById(@PathVariable Long tenantID,@RequestBody Tenant tenant, @RequestParam Long unitId) {
        return new ResponseEntity<>(tenantService.updateById(tenantID, tenant, unitId), HttpStatus.OK);
    }
}
