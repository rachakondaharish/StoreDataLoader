package com.cvs.data.loader.batch.PIM.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.catalina.Store;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.cvs.data.loader.batch.PIM.entities.StoreTempEntity;
import com.cvs.data.loader.batch.PIM.entities.StoresEntity;
import com.cvs.data.loader.batch.PIM.jpa.StoreTempRepository;
import com.cvs.data.loader.batch.PIM.jpa.StoresRepository;
import com.cvs.data.loader.batch.parseXml.STORE;
import com.cvs.data.loader.batch.parseXml.STORES;

@Component
public class Services {
	@Autowired
	StoreTempRepository storeRepository;
	@Autowired
	StoresRepository storesRepository;

	
	public void xmlToDatabaseUsingJAXB(File fXmlFile) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(STORES.class);

			Unmarshaller unmarshaller = jc.createUnmarshaller();
			STORES stores = (STORES) unmarshaller
					.unmarshal(fXmlFile);

			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			for(int i=0; i<stores.getSTORE().size(); i++ ){
				STORE xmlStore = stores.getSTORE().get(i);
				StoreTempEntity store = new StoreTempEntity();

				store.setStoreId(xmlStore.getSTATCD());
				store.setSTR_NBR(Integer.parseInt(xmlStore.getSTRNBR()));
				store.setSTAT_CD(xmlStore.getSTATCD().toString());
				store.setSTREET_ADDR1(xmlStore.getSTREETADDR1());
				store.setCITY_NAME(xmlStore.getCITYNAME());
				store.setSTATE_CD(xmlStore.getSTATECD());
				store.setZIP_CD(xmlStore.getZIPCD());
				store.setCOUNTY_CD(xmlStore.getCOUNTYCD());
				store.setCOUNTY_CD_DSC(xmlStore.getCOUNTYCDDSC());
				store.setOPCO_DSC(xmlStore.getOPCODSC());
				store.setBUS_SEGMENT(xmlStore.getBUSSEGMENT());
				store.setFACILITY_TYP_CD(xmlStore.getFACILITYTYPCD());
				store.setFACILITY_TYP_DSC(xmlStore.getFACILITYTYPDSC());
				store.setDIV_NAME(xmlStore.getDIVNAME());
				store.setFS_AREA_NBR(xmlStore.getFSAREANBR());
				store.setFS_REGION_NBR(xmlStore.getFSREGIONNBR());
				store.setFS_DISTRICT_NBR(xmlStore.getFSDISTRICTNBR());
				store.setRX_AREA_NBR(xmlStore.getRXAREANBR());
				store.setRX_REGION_NBR(xmlStore.getRXREGIONNBR());
				store.setRX_DISTRICT_NBR(xmlStore.getRXDISTRICTNBR());
				store.setLATITUDE(xmlStore.getLATITUDE());
				store.setLONGITUDE(xmlStore.getLONGITUDE());
				store.setRX_PHONE_NBR(xmlStore.getRXAREANBR());
				store.setDSTR_MGR_FNME(xmlStore.getDSTRMGRFNME());
				store.setDSTR_MGR_LNME(xmlStore.getDSTRMGRLNME());
				store.setDSTR_MGR_EMAIL(xmlStore.getDSTRMGREMAIL());

				storeRepository.saveAndFlush(store);
				if (i % 10 == 0) {
				     System.out.println("Inserted to temp table: "+i+" records.");
				}
				
			}
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void moveFromTempToStores() {
		List<StoreTempEntity> tempList = storeRepository.findAll();
		System.out.println("Records list: " + tempList.size());
		for (int i = 0; i < tempList.size(); i++) {
			StoreTempEntity storeTempEntity = tempList.get(i);
			StoresEntity storesEntity = new StoresEntity();
			storesEntity.setStoreId(storeTempEntity.getStoreId());

			storesEntity.setSTR_NBR(storeTempEntity.getSTR_NBR());
			storesEntity.setSTAT_CD(storeTempEntity.getSTAT_CD());
			storesEntity.setSTREET_ADDR1(storeTempEntity.getSTREET_ADDR1());
			storesEntity.setCITY_NAME(storeTempEntity.getCITY_NAME());
			storesEntity.setSTATE_CD(storeTempEntity.getSTATE_CD());
			storesEntity.setZIP_CD(storeTempEntity.getZIP_CD());
			storesEntity.setCOUNTY_CD(storeTempEntity.getCOUNTY_CD());
			storesEntity.setCOUNTY_CD_DSC(storeTempEntity.getCOUNTY_CD_DSC());
			storesEntity.setOPCO_DSC(storeTempEntity.getOPCO_DSC());
			storesEntity.setBUS_SEGMENT(storeTempEntity.getBUS_SEGMENT());
			storesEntity.setFACILITY_TYP_CD(storeTempEntity.getFACILITY_TYP_CD());
			storesEntity.setFACILITY_TYP_DSC(storeTempEntity.getFACILITY_TYP_DSC());
			storesEntity.setDIV_NAME(storeTempEntity.getDIV_NAME());
			storesEntity.setFS_AREA_NBR(storeTempEntity.getFS_AREA_NBR());
			storesEntity.setFS_REGION_NBR(storeTempEntity.getFS_REGION_NBR());
			storesEntity.setFS_DISTRICT_NBR(storeTempEntity.getFS_DISTRICT_NBR());
			storesEntity.setRX_AREA_NBR(storeTempEntity.getRX_AREA_NBR());
			storesEntity.setRX_REGION_NBR(storeTempEntity.getRX_REGION_NBR());
			storesEntity.setRX_DISTRICT_NBR(storeTempEntity.getRX_DISTRICT_NBR());
			storesEntity.setLATITUDE(storeTempEntity.getLATITUDE());
			storesEntity.setLONGITUDE(storeTempEntity.getLONGITUDE());
			storesEntity.setRX_PHONE_NBR(storeTempEntity.getRX_PHONE_NBR());
			storesEntity.setDSTR_MGR_FNME(storeTempEntity.getDSTR_MGR_FNME());
			storesEntity.setDSTR_MGR_LNME(storeTempEntity.getDSTR_MGR_LNME());
			storesEntity.setDSTR_MGR_EMAIL(storeTempEntity.getDSTR_MGR_EMAIL());

			try {
				storesRepository.saveAndFlush(storesEntity);
				storeTempEntity.setDeleteStatus(true);
				storeRepository.saveAndFlush(storeTempEntity);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (i % 10 == 0) {
			     System.out.println("Records moved to final table: "+i);
			}
		}

	}

	public void cleanup(File file1, File file2) {
		if (file1.delete() && file2.delete()) {
			System.out.println("Source File and Resources temp files are deleted successfully");
		} else {
			System.out.println("Failed to delete Source file and Resources temp file");
		}
	}

	public void copyfile(File source, File destination) {
		System.out.println("copying file from " + source + " to " + destination);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
