package com.jdy.data.role.decker;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdy.data.role.dto.SysRole;
import com.jdy.data.role.repository.SysRoleRepository;

@Repository
public class SysRoleDecker {

	@Autowired
	SysRoleRepository sysRoleRepository;

	public SysRole findById(Integer roleId) {
		Optional<SysRole> opt = sysRoleRepository.findById(roleId);
		return opt.isPresent() ? opt.get() : null;

	}
}
