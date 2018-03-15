package com.cvs.data.loader.batch.PIM.batachJob;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cvs.data.loader.batch.PIM.constants.Constants;
import com.cvs.data.loader.batch.PIM.services.Services;

@Component
public class XmlLoaderBatch {

	@Autowired
	Services services;
	@Autowired
	Constants constants;
	
	@Scheduled(cron = "${store.data.load.scheduler}")
	//@PostConstruct
	public void runBatch() {
		System.out.println("Looking for files: " + new Date());
		try {
			File sourceXml = new File(constants.sourcepath);
			File destinationXML = new File(constants.destinationpath);
			File resourcesXML = new File(constants.resourcespath);
			
			if (sourceXml.exists() && !sourceXml.isDirectory()) {
				System.out.println("File found.\nCopying to resources for processing: " + sourceXml);
				services.copyfile(sourceXml, resourcesXML);
				
				services.xmlToDatabase(resourcesXML);//Read and store to database
				
				services.moveFromTempToStores();
				
				services.copyfile(resourcesXML, destinationXML);
				
				services.cleanup(sourceXml, resourcesXML);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
