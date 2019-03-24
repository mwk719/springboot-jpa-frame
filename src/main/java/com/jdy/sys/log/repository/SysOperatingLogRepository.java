package com.jdy.sys.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdy.sys.log.dto.SysOperatingLog;

@Repository
public interface SysOperatingLogRepository extends JpaRepository<SysOperatingLog, Integer> {

}
