package com.cvs.store.data.loader.storeDataLoader.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cvs.store.data.loader.storeDataLoader.entities.StoreEntity;

@Service
public interface StoreRepository extends JpaRepository<StoreEntity, String> {

	
}
