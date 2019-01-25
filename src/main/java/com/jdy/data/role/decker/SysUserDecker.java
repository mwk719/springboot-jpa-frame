package com.jdy.data.role.decker;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdy.data.role.dto.SysUser;
import com.jdy.data.role.repository.SysUserRepository;

@Repository
public class SysUserDecker {

	@Autowired
	SysUserRepository sysUserRepository;

	public SysUser findByUsername(String username) {
		Optional<SysUser> u = sysUserRepository.findByUsername(username);
		return u.isPresent() ? u.get() : null;
	}

	public void save(SysUser u) {
		sysUserRepository.save(u);

	}

	public SysUser findById(Integer adminId) {
		Optional<SysUser> opt = sysUserRepository.findById(adminId);
		return opt.isPresent() ? opt.get() : null;
	}

}
