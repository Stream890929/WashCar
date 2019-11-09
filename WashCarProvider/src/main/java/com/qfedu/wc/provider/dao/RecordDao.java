package com.qfedu.wc.provider.dao;

import com.qfedu.wc.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordDao extends JpaRepository<Record,Integer> {
}
