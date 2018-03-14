package com.cvs.store.data.loader.storeDataLoader.batachJob;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cvs.store.data.loader.storeDataLoader.services.Services;

@Component
public class XmlLoaderBatch {

	@Autowired
	Services services;
	// @Scheduled(cron = "${batch.status.update.scheduler}")
	@Scheduled(cron = "0/5 * * ?  * *")
	public void runBatch() {
		System.out.println("Looking for files: " + new Date());
		try {
			File sourceXml = new File("src/main/resources/Source/cvs.xml");
			File destinationXML = new File("src/main/resources/destination/cvs.xml");
			File resourcesXML = new File("src/main/resources/cvs.xml");
			
			if (sourceXml.exists() && !sourceXml.isDirectory()) {
				System.out.println("File found.\nCopying to resources for processing: " + sourceXml);
				FileUtils.copyFile(sourceXml, resourcesXML);
				services.xmlToDatabase(resourcesXML);//Read and store to database
				
				
				System.out.println("Copying to destination: " + destinationXML);
				FileUtils.copyFile(resourcesXML, destinationXML);
				
				if(sourceXml.delete()&&resourcesXML.delete())
		        {
		            System.out.println("Source File and Resources temp files are deleted successfully");
		        }
		        else
		        {
		            System.out.println("Failed to delete Source file and Resources temp file");
		        }
			}
		}catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
