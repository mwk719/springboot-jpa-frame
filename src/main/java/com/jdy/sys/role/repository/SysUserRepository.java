package com.jdy.sys.role.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdy.sys.role.dto.SysUser;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {

	Optional<SysUser> findByUsername(String username);

}
