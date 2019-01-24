package com.jdy.data.region.decker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdy.data.region.repository.SysRegionRepository;

@Repository
public class SysRegionDecker {

	@Autowired
	SysRegionRepository sysRegionRepository;
}
