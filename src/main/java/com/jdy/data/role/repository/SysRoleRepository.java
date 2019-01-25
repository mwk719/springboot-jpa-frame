package com.jdy.data.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdy.data.role.dto.SysRole;

@Repository
public interface SysRoleRepository extends JpaRepository<SysRole, Integer> {

}
