package com.cvs.data.loader.batch.PIM.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cvs.data.loader.batch.PIM.entities.StoresEntity;


@Service
public interface StoresRepository extends JpaRepository<StoresEntity, String> {

	
}
