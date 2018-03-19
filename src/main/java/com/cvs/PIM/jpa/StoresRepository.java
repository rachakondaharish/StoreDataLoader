package com.cvs.PIM.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cvs.PIM.entities.StoresEntity;


@Service
public interface StoresRepository extends JpaRepository<StoresEntity, String> {

	
}
