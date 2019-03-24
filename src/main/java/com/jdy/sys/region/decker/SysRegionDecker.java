package com.jdy.sys.region.decker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdy.sys.region.repository.SysRegionRepository;

@Repository
public class SysRegionDecker {

	@Autowired
	SysRegionRepository sysRegionRepository;
}
