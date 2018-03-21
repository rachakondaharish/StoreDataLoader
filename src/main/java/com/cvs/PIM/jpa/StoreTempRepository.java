package com.cvs.PIM.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cvs.PIM.entities.StoreTempEntity;


@Service
public interface StoreTempRepository extends JpaRepository<StoreTempEntity, String> {

	List<StoreTempEntity> findAll();
	List<StoreTempEntity> findTop100ByDeleteStatus(Boolean status);
}
