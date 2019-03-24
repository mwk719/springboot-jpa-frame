package com.jdy.sys.log.decker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.jdy.common.dto.Pager;
import com.jdy.sys.log.dto.SysOperatingLog;
import com.jdy.sys.log.repository.SysOperatingLogRepository;

@Repository
public class SysOperatingLogDecker {

	@Autowired
	SysOperatingLogRepository sysOperatingLogRepository;

	public void save(SysOperatingLog sysLog) {
		sysOperatingLogRepository.save(sysLog);

	}

	public List<SysOperatingLog> findAll(Pager page) {
		Pageable pageable = PageRequest.of(page.getSysPage(), page.getSize(), Sort.by(Direction.DESC, "createTime"));
		Page<SysOperatingLog> plist = sysOperatingLogRepository.findAll(pageable);

		page.setTotal(plist.getTotalPages());
		page.setCount(plist.getTotalElements());

		return plist.hasContent() ? plist.getContent() : null;
	}
}
