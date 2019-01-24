package com.jdy.data.role.decker;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdy.data.role.dto.SysPermission;
import com.jdy.data.role.repository.SysPermissionRepository;

@Repository
public class SysPermissionDecker {

	@Autowired
	SysPermissionRepository sysPermissionRepository;

	public SysPermission findById(Integer pId) {
		Optional<SysPermission> opt = sysPermissionRepository.findById(pId);
		return opt.isPresent() ? opt.get() : null;
	}
}
