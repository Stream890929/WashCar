package com.qfedu.wc.provider.dao;

import com.qfedu.wc.entity.Evaluate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluateDao extends JpaRepository<Evaluate, Integer> {

    List<Evaluate> getByOid(int oid);

}
