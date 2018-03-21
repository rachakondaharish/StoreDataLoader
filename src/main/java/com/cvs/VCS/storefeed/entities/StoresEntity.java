package com.cvs.vcs.storefeed.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cvs.vcs.storefeed.auditing.Auditable;


@Table
@Entity(name = "Store")
public class StoresEntity extends Auditable<String>  {
	
	
	@Id
	@Column(name="STORE_nbr")
	int STR_NBR;
	@Column(name="STATUS")
    String STAT_CD;
	@Column(name="Address_line_1")
    String STREET_ADDR1;
	@Column(name="City")
    String CITY_NAME;
	@Column(name="State_CD")
    String STATE_CD;
	@Column(name="ZIP_CD")
    String ZIP_CD;
	@Column(name="COUNTY_CD")
    String COUNTY_CD;
	@Column(name="COUNTY_CD_DSC")
    String COUNTY_CD_DSC;
	@Column(name="OPCO_DSC")
    String OPCO_DSC;
	@Column(name="BUS_SEGMENT")
    String BUS_SEGMENT;
	@Column(name="FACILITY_TYP_CD")
    String FACILITY_TYP_CD;
	@Column(name="FACILITY_TYP_DSC")
    String FACILITY_TYP_DSC;
	@Column(name="Division_Name")
    String DIV_NAME;
	@Column(name="FS_AREA_NBR")
    String FS_AREA_NBR;
	@Column(name="FS_REGION_NBR")
    String FS_REGION_NBR;
	@Column(name="FS_DISTRICT_NBR")
    String FS_DISTRICT_NBR;
	@Column(name="RX_AREA_NBR")
    String RX_AREA_NBR;
	@Column(name="RX_REGION_NBR")
    String RX_REGION_NBR;
	@Column(name="RX_DISTRICT_NBR")
    String RX_DISTRICT_NBR;
	@Column(name="LATITUDE")
    String LATITUDE;
	@Column(name="LONGITUDE")
    String LONGITUDE;
	@Column(name="RX_PHONE_NBR")
    String RX_PHONE_NBR;
	@Column(name="DSTR_MGR_First_Name")
    String DSTR_MGR_FNME;
	@Column(name="DSTR_MGR_Last_Name")
    String DSTR_MGR_LNME;
	@Column(name="DSTR_MGR_Phone_nbr")
    String DSTR_MGR_Phone_nbr;
	@Column(name="DSTR_MGR_EMAIL")
    String DSTR_MGR_EMAIL;
	
	

	public int getSTR_NBR() {
		return STR_NBR;
	}

	public void setSTR_NBR(int sTR_NBR) {
		STR_NBR = sTR_NBR;
	}

	
	public String getSTAT_CD() {
		return STAT_CD;
	}

	public void setSTAT_CD(String sTAT_CD) {
		STAT_CD = sTAT_CD;
	}

	
	public String getDSTR_MGR_Phone_nbr() {
		return DSTR_MGR_Phone_nbr;
	}

	public void setDSTR_MGR_Phone_nbr(String dSTR_MGR_Phone_nbr) {
		DSTR_MGR_Phone_nbr = dSTR_MGR_Phone_nbr;
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

	


    
}
