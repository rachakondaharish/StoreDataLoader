package com.cvs.data.loader.batch.PIM.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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


@Component
public class Services {
	@Autowired
	StoreTempRepository storeRepository;
	@Autowired
	StoresRepository storesRepository;
	
	public void xmlToDatabase(File fXmlFile){
		try {
	    	System.out.println("Storing XML: "+fXmlFile.getPath()+" to database.");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("tns:STORE");
			System.out.println("Store records found: "+nList.getLength());
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					StoreTempEntity store = new StoreTempEntity();
					store.setStoreId(Integer.parseInt(eElement.getAttribute("Id")));
					
					store.setSTR_NBR(Integer.parseInt(eElement.getElementsByTagName("tns:STR_NBR").item(0).getTextContent()));
					if(eElement.getElementsByTagName("tns:STAT_CD").getLength()>0)
						store.setSTAT_CD(eElement.getElementsByTagName("tns:STAT_CD").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:STREET_ADDR1").getLength()>0)
						store.setSTREET_ADDR1(eElement.getElementsByTagName("tns:STREET_ADDR1").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:CITY_NAME").getLength()>0)
						store.setCITY_NAME(eElement.getElementsByTagName("tns:CITY_NAME").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:STATE_CD").getLength()>0)
						store.setSTATE_CD(eElement.getElementsByTagName("tns:STATE_CD").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:ZIP_CD").getLength()>0)
						store.setZIP_CD(eElement.getElementsByTagName("tns:ZIP_CD").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:COUNTY_CD").getLength()>0)
						store.setCOUNTY_CD(eElement.getElementsByTagName("tns:COUNTY_CD").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:COUNTY_CD_DSC").getLength()>0)
						store.setCOUNTY_CD_DSC(eElement.getElementsByTagName("tns:COUNTY_CD_DSC").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:OPCO_DSC").getLength()>0)
						store.setOPCO_DSC(eElement.getElementsByTagName("tns:OPCO_DSC").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:BUS_SEGMENT").getLength()>0)
						store.setBUS_SEGMENT(eElement.getElementsByTagName("tns:BUS_SEGMENT").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:FACILITY_TYP_CD").getLength()>0)
						store.setFACILITY_TYP_CD(eElement.getElementsByTagName("tns:FACILITY_TYP_CD").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:FACILITY_TYP_DSC").getLength()>0)
						store.setFACILITY_TYP_DSC(eElement.getElementsByTagName("tns:FACILITY_TYP_DSC").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:DIV_NAME").getLength()>0)
						store.setDIV_NAME(eElement.getElementsByTagName("tns:DIV_NAME").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:FS_AREA_NBR").getLength()>0)
						store.setFS_AREA_NBR(eElement.getElementsByTagName("tns:FS_AREA_NBR").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:FS_REGION_NBR").getLength()>0)
						store.setFS_REGION_NBR(eElement.getElementsByTagName("tns:FS_REGION_NBR").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:FS_DISTRICT_NBR").getLength()>0)
						store.setFS_DISTRICT_NBR(eElement.getElementsByTagName("tns:FS_DISTRICT_NBR").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:RX_AREA_NBR").getLength()>0)
						store.setRX_AREA_NBR(eElement.getElementsByTagName("tns:RX_AREA_NBR").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:RX_REGION_NBR").getLength()>0)
						store.setRX_REGION_NBR(eElement.getElementsByTagName("tns:RX_REGION_NBR").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:RX_DISTRICT_NBR").getLength()>0)
						store.setRX_DISTRICT_NBR(eElement.getElementsByTagName("tns:RX_DISTRICT_NBR").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:LATITUDE").getLength()>0)
						store.setLATITUDE(eElement.getElementsByTagName("tns:LATITUDE").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:LONGITUDE").getLength()>0)
						store.setLONGITUDE(eElement.getElementsByTagName("tns:LONGITUDE").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:RX_PHONE_NBR").getLength()>0)
						store.setRX_PHONE_NBR(eElement.getElementsByTagName("tns:RX_PHONE_NBR").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:DSTR_MGR_FNME").getLength()>0)
						store.setDSTR_MGR_FNME(eElement.getElementsByTagName("tns:DSTR_MGR_FNME").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:DSTR_MGR_LNME").getLength()>0)
						store.setDSTR_MGR_LNME(eElement.getElementsByTagName("tns:DSTR_MGR_LNME").item(0).getTextContent());
					if(eElement.getElementsByTagName("tns:DSTR_MGR_EMAIL").getLength()>0)
						store.setDSTR_MGR_EMAIL(eElement.getElementsByTagName("tns:DSTR_MGR_EMAIL").item(0).getTextContent());
					
					storeRepository.saveAndFlush(store);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void moveFromTempToStores(){
		List<StoreTempEntity> tempList = storeRepository.findAll();
		System.out.println("Records list: "+tempList.size());
		for(int i=0;i<tempList.size(); i++ ){
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
			
			
			try{
				storesRepository.saveAndFlush(storesEntity);
				storeTempEntity.setDeleteStatus(true);
				storeRepository.saveAndFlush(storeTempEntity);
			}catch(Exception e){
				e.printStackTrace();
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
