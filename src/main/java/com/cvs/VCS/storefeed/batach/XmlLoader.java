package com.cvs.vcs.storefeed.batach;

import java.io.File;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cvs.vcs.storefeed.constants.Constants;
import com.cvs.vcs.storefeed.service.stotefeedservice;


@Component
public class XmlLoader {

	@Autowired
	stotefeedservice services;
	@Autowired
	Constants constants;

	 //@Scheduled(cron = "${store.data.load.scheduler}")
	@PostConstruct
	public void runBatch() {
		System.out.println("Looking for files: " + new Date());
		try {
			for(int i = 0; i< 4;i++){
				Thread.sleep(60000);
				File sourceXml = new File(constants.sourcepath);
				File destinationXML = new File(constants.destinationpath);
				File resourcesXML = new File(constants.resourcespath);
	
				if (sourceXml.exists() && !sourceXml.isDirectory()) {
					System.out.println("File found.\nCopying file to resources for processing: " + sourceXml);
					services.copyfile(sourceXml, resourcesXML);
					
					//services.xmlReadUsingJaxBStoreUsingJPA(resourcesXML);// Read and store to database using JPA
					
					services.xmlReadUsingJaxBStoreUsingJDBC(resourcesXML); // Read and store to database using JDBC
					
					//services.moveFromTempToStoresUsingJPA(); // copy records from table 1 to 2 using JPA 100 at a time - Update table 2
					
					//services.moveFromTempToStoresUsingJDBC();
					
	
					services.copyfile(resourcesXML, destinationXML);
	
					services.cleanup(sourceXml, resourcesXML);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
