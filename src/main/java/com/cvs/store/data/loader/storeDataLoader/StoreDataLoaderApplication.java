package com.cvs.store.data.loader.storeDataLoader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cvs.store.data.loader.storeDataLoader.batachJob.XmlLoaderBatch;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.cvs.store.data.loader.*"})
public class StoreDataLoaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreDataLoaderApplication.class, args);
	}
}
