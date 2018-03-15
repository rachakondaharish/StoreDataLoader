package com.cvs.data.loader.batch.PIM.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {
	
	@Value("${xml.file.location.destination}")
	public String destinationpath;
	
	@Value("${xml.file.location.resources}")
	public String resourcespath;
	
	@Value("${xml.file.location.sourceFile}")
	public String sourcepath;
}
