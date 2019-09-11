package kr.or.ddit.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

//문자열 -> java.util.Date
public class CustomDateConverter implements Converter<String, Date>{
	private static final Logger logger = LoggerFactory.getLogger(CustomDateConverter.class);

	@Override
	public Date convert(String source) {
		logger.debug("CustomDateConverter");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
