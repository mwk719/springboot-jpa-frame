package com.jdy.data.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdy.data.role.dto.SysRolePermission;

@Repository
public interface SysRolePermissionRepository extends JpaRepository<SysRolePermission, Integer> {

	List<SysRolePermission> findByRoleId(Integer roleId);

}
