package com.cvs.store.data.loader.storeDataLoader.services;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.cvs.store.data.loader.storeDataLoader.entities.StoreEntity;
import com.cvs.store.data.loader.storeDataLoader.jpa.StoreRepository;


@Component
public class Services {
	@Autowired
	StoreRepository storeRepository;
	
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
					StoreEntity store = new StoreEntity();
					store.setStoreId(Integer.parseInt(eElement.getAttribute("Id")));
					store.setSTR_NBR(eElement.getElementsByTagName("tns:STR_NBR").item(0).getTextContent());
					store.setABBR_NAME(eElement.getElementsByTagName("tns:ABBR_NAME").item(0).getTextContent());
					store.setSTAT_CD(eElement.getElementsByTagName("tns:STAT_CD").item(0).getTextContent());
					store.setSTAT_DSC(eElement.getElementsByTagName("tns:STAT_DSC").item(0).getTextContent());
					store.setSTREET_ADDR1(eElement.getElementsByTagName("tns:STREET_ADDR1").item(0).getTextContent());
					store.setCITY_NAME(eElement.getElementsByTagName("tns:CITY_NAME").item(0).getTextContent());
					store.setSTATE_CD(eElement.getElementsByTagName("tns:STATE_CD").item(0).getTextContent());
					store.setZIP_CD(eElement.getElementsByTagName("tns:ZIP_CD").item(0).getTextContent());
					store.setCOUNTY_CD(eElement.getElementsByTagName("tns:COUNTY_CD").item(0).getTextContent());
					store.setCOUNTY_CD_DSC(eElement.getElementsByTagName("tns:COUNTY_CD_DSC").item(0).getTextContent());
					store.setOPCO_DSC(eElement.getElementsByTagName("tns:OPCO_DSC").item(0).getTextContent());
					store.setBUS_SEGMENT(eElement.getElementsByTagName("tns:BUS_SEGMENT").item(0).getTextContent());
					store.setFACILITY_TYP_CD(eElement.getElementsByTagName("tns:FACILITY_TYP_CD").item(0).getTextContent());
					store.setFACILITY_TYP_DSC(eElement.getElementsByTagName("tns:FACILITY_TYP_DSC").item(0).getTextContent());
					store.setDIV_NAME(eElement.getElementsByTagName("tns:DIV_NAME").item(0).getTextContent());
					store.setFS_AREA_NBR(eElement.getElementsByTagName("tns:FS_AREA_NBR").item(0).getTextContent());
					store.setFS_REGION_NBR(eElement.getElementsByTagName("tns:FS_REGION_NBR").item(0).getTextContent());
					store.setFS_DISTRICT_NBR(eElement.getElementsByTagName("tns:FS_DISTRICT_NBR").item(0).getTextContent());
					store.setRX_AREA_NBR(eElement.getElementsByTagName("tns:RX_AREA_NBR").item(0).getTextContent());
					store.setRX_REGION_NBR(eElement.getElementsByTagName("tns:RX_REGION_NBR").item(0).getTextContent());
					store.setRX_DISTRICT_NBR(eElement.getElementsByTagName("tns:RX_DISTRICT_NBR").item(0).getTextContent());
					store.setLATITUDE(eElement.getElementsByTagName("tns:LATITUDE").item(0).getTextContent());
					store.setLONGITUDE(eElement.getElementsByTagName("tns:LONGITUDE").item(0).getTextContent());
					store.setRX_PHONE_NBR(eElement.getElementsByTagName("tns:RX_PHONE_NBR").item(0).getTextContent());
					store.setDSTR_MGR_FNME(eElement.getElementsByTagName("tns:DSTR_MGR_FNME").item(0).getTextContent());
					store.setDSTR_MGR_LNME(eElement.getElementsByTagName("tns:DSTR_MGR_LNME").item(0).getTextContent());
					store.setDSTR_MGR_EMAIL(eElement.getElementsByTagName("tns:DSTR_MGR_EMAIL").item(0).getTextContent());
					store.setDIV_CD(eElement.getElementsByTagName("tns:DIV_CD").item(0).getTextContent());
					storeRepository.saveAndFlush(store);
				}
			}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	
		
	}
	
	
	
}
