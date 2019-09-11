package kr.or.ddit.type;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomDatePropertyEditor implements PropertyEditorRegistrar{
	private static final Logger logger = LoggerFactory.getLogger(CustomDatePropertyEditor.class);

	
	//문자열을 --> java.util.Date
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		logger.debug("CustomDatePropertyEditor");
		registry.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
}
