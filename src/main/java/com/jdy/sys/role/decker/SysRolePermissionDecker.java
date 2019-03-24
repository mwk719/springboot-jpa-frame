package com.jdy.sys.role.decker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdy.common.util.StringUtils;
import com.jdy.sys.role.dto.SysRolePermission;
import com.jdy.sys.role.repository.SysRolePermissionRepository;

@Repository
public class SysRolePermissionDecker {

	@Autowired
	SysRolePermissionRepository sysRolePermissionRepository;

	@Autowired
	SysPermissionDecker sysPermissionDecker;

	public List<SysRolePermission> findByRoleId(Integer roleId) {
		List<SysRolePermission> list = sysRolePermissionRepository.findByRoleId(roleId);
		
		System.out.println(list.toString());
		if (StringUtils.listIsBlank(list)) {
			return null;
		}
		return list;
	}

	/**
	 * 获取权限数组
	 * @param roleId
	 * @return
	 */
	public String[] findPermissionUrlByRoleId(Integer roleId) {
		List<SysRolePermission> list = findByRoleId(roleId);
		if (list == null) {
			return null;
		}
		String[] url = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			url[i]=sysPermissionDecker.findById(list.get(i).getPId()).getUrl();
		}
		return url;
	}

}
