package com.cvs.data.loader.batch.PIM.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cvs.data.loader.batch.PIM.entities.StoreTempEntity;


@Service
public interface StoreTempRepository extends JpaRepository<StoreTempEntity, String> {

	List<StoreTempEntity> findAll();
}
