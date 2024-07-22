package com.example.demoTTS2.Controller.CRUDAdmin;

import com.example.demoTTS2.Model.RoleEntity;
import com.example.demoTTS2.Model.UserEntity;
import com.example.demoTTS2.Repository.RoleRepo;
import com.example.demoTTS2.Service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class useradminController {
    private RoleRepo roleRepo;
    private final IUserService iUserService;

    public useradminController(RoleRepo roleRepo, IUserService iUserService) {
        this.roleRepo = roleRepo;
        this.iUserService = iUserService;
    }
@PostMapping("setRole/{id}")
public ResponseEntity<?> setRole(@RequestHeader("Authorization") String authHeader, @RequestBody RoleEntity roleEntity, @PathVariable Integer id) {
    try {
        RoleEntity existingRole = roleRepo.findByUif(id);
        if (existingRole == null) {
            return ResponseEntity.notFound().build();
        }

        if (roleEntity.getAddRole() != null) {
            existingRole.setAddRole(roleEntity.getAddRole());
        }
        if (roleEntity.getDeleteRole() != null) {
            existingRole.setDeleteRole(roleEntity.getDeleteRole());
        }
        if (roleEntity.getQueryCustomerRole() != null) {
            existingRole.setQueryCustomerRole(roleEntity.getQueryCustomerRole());
        }
        if (roleEntity.getEditRole() != null) {
            existingRole.setEditRole(roleEntity.getEditRole());
        }
        if (roleEntity.getReadSalaryRole() != null) {
            existingRole.setReadSalaryRole(roleEntity.getReadSalaryRole());
        }

        roleRepo.save(existingRole);
        return ResponseEntity.ok("Thành công");
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Lỗi: " + e.getMessage());
    }
}
}
