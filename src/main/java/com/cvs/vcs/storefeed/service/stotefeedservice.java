package com.cvs.vcs.storefeed.service;

import java.io.File;

public interface stotefeedservice {
	
	
	public void xmlReadUsingJaxBStoreUsingJPA(File fXmlFile);
	public void xmlReadUsingJaxBStoreUsingJDBC(File fXmlFile);
	public void moveFromTempToStoresUsingJDBC();
	public void moveFromTempToStoresUsingJPA();
	public void cleanup(File file1, File file2) ;
	public void copyfile(File source, File destination);
	
	
}
