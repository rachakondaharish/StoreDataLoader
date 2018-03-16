package com.cvs.data.loader.batch.PIM.batachJob;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cvs.data.loader.batch.PIM.constants.Constants;
import com.cvs.data.loader.batch.PIM.services.Services;
import com.cvs.data.loader.batch.parseXml.STORES;

@Component
public class XmlLoaderBatch {

	@Autowired
	Services services;
	@Autowired
	Constants constants;

	 @Scheduled(cron = "${store.data.load.scheduler}")
	// @PostConstruct
	public void runBatch() {
		System.out.println("Looking for files: " + new Date());
		try {
			File sourceXml = new File(constants.sourcepath);
			File destinationXML = new File(constants.destinationpath);
			File resourcesXML = new File(constants.resourcespath);

			if (sourceXml.exists() && !sourceXml.isDirectory()) {
				System.out.println("File found.\nCopying to resources for processing: " + sourceXml);
				services.copyfile(sourceXml, resourcesXML);

				services.xmlToDatabaseUsingJAXB(resourcesXML);// Read and store to
														// database

				services.moveFromTempToStores();

				services.copyfile(resourcesXML, destinationXML);

				services.cleanup(sourceXml, resourcesXML);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//@Scheduled(cron = "${store.data.load.scheduler}")
	public static void marshalXml() throws Exception {
		JAXBContext jc = JAXBContext.newInstance(STORES.class);
		
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		STORES stores = (STORES) unmarshaller.unmarshal(new File("/Users/hrachako/Documents/Personal/files/cvs.xml"));

		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
	}

}
