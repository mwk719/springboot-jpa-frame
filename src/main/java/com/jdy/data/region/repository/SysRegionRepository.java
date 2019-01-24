package com.jdy.data.region.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdy.data.region.dto.SysRegion;

@Repository
public interface SysRegionRepository extends JpaRepository<SysRegion, Integer> {

}
