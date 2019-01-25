package com.jdy.data.syslog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdy.data.syslog.dto.SysOperatingLog;

@Repository
public interface SysOperatingLogRepository extends JpaRepository<SysOperatingLog, Integer> {

}
