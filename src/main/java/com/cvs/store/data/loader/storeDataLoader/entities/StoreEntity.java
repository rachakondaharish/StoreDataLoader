package com.cvs.store.data.loader.storeDataLoader.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "Harish_Store")
public class StoreEntity {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	int storeId;
	String STR_NBR;
    String ABBR_NAME;
    String STAT_CD;
    String STAT_DSC;
    String STREET_ADDR1;
    String CITY_NAME;
    String STATE_CD;
    String ZIP_CD;
    String COUNTY_CD;
    String COUNTY_CD_DSC;
    String OPCO_DSC;
    String BUS_SEGMENT;
    String FACILITY_TYP_CD;
    String FACILITY_TYP_DSC;
    String DIV_NAME;
    String FS_AREA_NBR;
    String FS_REGION_NBR;
    String FS_DISTRICT_NBR;
    String RX_AREA_NBR;
    String RX_REGION_NBR;
    String RX_DISTRICT_NBR;
    String LATITUDE;
    String LONGITUDE;
    String RX_PHONE_NBR;
    String DSTR_MGR_FNME;
    String DSTR_MGR_LNME;
    String DSTR_MGR_EMAIL;
    String DIV_CD;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getSTR_NBR() {
		return STR_NBR;
	}
	public void setSTR_NBR(String sTR_NBR) {
		STR_NBR = sTR_NBR;
	}
	public String getABBR_NAME() {
		return ABBR_NAME;
	}
	public void setABBR_NAME(String aBBR_NAME) {
		ABBR_NAME = aBBR_NAME;
	}
	public String getSTAT_CD() {
		return STAT_CD;
	}
	public void setSTAT_CD(String sTAT_CD) {
		STAT_CD = sTAT_CD;
	}
	public String getSTAT_DSC() {
		return STAT_DSC;
	}
	public void setSTAT_DSC(String sTAT_DSC) {
		STAT_DSC = sTAT_DSC;
	}
	public String getSTREET_ADDR1() {
		return STREET_ADDR1;
	}
	public void setSTREET_ADDR1(String sTREET_ADDR1) {
		STREET_ADDR1 = sTREET_ADDR1;
	}
	public String getCITY_NAME() {
		return CITY_NAME;
	}
	public void setCITY_NAME(String cITY_NAME) {
		CITY_NAME = cITY_NAME;
	}
	public String getSTATE_CD() {
		return STATE_CD;
	}
	public void setSTATE_CD(String sTATE_CD) {
		STATE_CD = sTATE_CD;
	}
	public String getZIP_CD() {
		return ZIP_CD;
	}
	public void setZIP_CD(String zIP_CD) {
		ZIP_CD = zIP_CD;
	}
	public String getCOUNTY_CD() {
		return COUNTY_CD;
	}
	public void setCOUNTY_CD(String cOUNTY_CD) {
		COUNTY_CD = cOUNTY_CD;
	}
	public String getCOUNTY_CD_DSC() {
		return COUNTY_CD_DSC;
	}
	public void setCOUNTY_CD_DSC(String cOUNTY_CD_DSC) {
		COUNTY_CD_DSC = cOUNTY_CD_DSC;
	}
	public String getOPCO_DSC() {
		return OPCO_DSC;
	}
	public void setOPCO_DSC(String oPCO_DSC) {
		OPCO_DSC = oPCO_DSC;
	}
	public String getBUS_SEGMENT() {
		return BUS_SEGMENT;
	}
	public void setBUS_SEGMENT(String bUS_SEGMENT) {
		BUS_SEGMENT = bUS_SEGMENT;
	}
	public String getFACILITY_TYP_CD() {
		return FACILITY_TYP_CD;
	}
	public void setFACILITY_TYP_CD(String fACILITY_TYP_CD) {
		FACILITY_TYP_CD = fACILITY_TYP_CD;
	}
	public String getFACILITY_TYP_DSC() {
		return FACILITY_TYP_DSC;
	}
	public void setFACILITY_TYP_DSC(String fACILITY_TYP_DSC) {
		FACILITY_TYP_DSC = fACILITY_TYP_DSC;
	}
	public String getDIV_NAME() {
		return DIV_NAME;
	}
	public void setDIV_NAME(String dIV_NAME) {
		DIV_NAME = dIV_NAME;
	}
	public String getFS_AREA_NBR() {
		return FS_AREA_NBR;
	}
	public void setFS_AREA_NBR(String fS_AREA_NBR) {
		FS_AREA_NBR = fS_AREA_NBR;
	}
	public String getFS_REGION_NBR() {
		return FS_REGION_NBR;
	}
	public void setFS_REGION_NBR(String fS_REGION_NBR) {
		FS_REGION_NBR = fS_REGION_NBR;
	}
	public String getFS_DISTRICT_NBR() {
		return FS_DISTRICT_NBR;
	}
	public void setFS_DISTRICT_NBR(String fS_DISTRICT_NBR) {
		FS_DISTRICT_NBR = fS_DISTRICT_NBR;
	}
	public String getRX_AREA_NBR() {
		return RX_AREA_NBR;
	}
	public void setRX_AREA_NBR(String rX_AREA_NBR) {
		RX_AREA_NBR = rX_AREA_NBR;
	}
	public String getRX_REGION_NBR() {
		return RX_REGION_NBR;
	}
	public void setRX_REGION_NBR(String rX_REGION_NBR) {
		RX_REGION_NBR = rX_REGION_NBR;
	}
	public String getRX_DISTRICT_NBR() {
		return RX_DISTRICT_NBR;
	}
	public void setRX_DISTRICT_NBR(String rX_DISTRICT_NBR) {
		RX_DISTRICT_NBR = rX_DISTRICT_NBR;
	}
	public String getLATITUDE() {
		return LATITUDE;
	}
	public void setLATITUDE(String lATITUDE) {
		LATITUDE = lATITUDE;
	}
	public String getLONGITUDE() {
		return LONGITUDE;
	}
	public void setLONGITUDE(String lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}
	public String getRX_PHONE_NBR() {
		return RX_PHONE_NBR;
	}
	public void setRX_PHONE_NBR(String rX_PHONE_NBR) {
		RX_PHONE_NBR = rX_PHONE_NBR;
	}
	public String getDSTR_MGR_FNME() {
		return DSTR_MGR_FNME;
	}
	public void setDSTR_MGR_FNME(String dSTR_MGR_FNME) {
		DSTR_MGR_FNME = dSTR_MGR_FNME;
	}
	public String getDSTR_MGR_LNME() {
		return DSTR_MGR_LNME;
	}
	public void setDSTR_MGR_LNME(String dSTR_MGR_LNME) {
		DSTR_MGR_LNME = dSTR_MGR_LNME;
	}
	public String getDSTR_MGR_EMAIL() {
		return DSTR_MGR_EMAIL;
	}
	public void setDSTR_MGR_EMAIL(String dSTR_MGR_EMAIL) {
		DSTR_MGR_EMAIL = dSTR_MGR_EMAIL;
	}
	public String getDIV_CD() {
		return DIV_CD;
	}
	public void setDIV_CD(String dIV_CD) {
		DIV_CD = dIV_CD;
	}
    
    
}
