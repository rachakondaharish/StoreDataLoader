package com.cvs.vcs.storefeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cvs.vcs.storefeed.entities.StoresEntity;




@Service
public interface StoresRepository extends JpaRepository<StoresEntity, String> {

	
}
