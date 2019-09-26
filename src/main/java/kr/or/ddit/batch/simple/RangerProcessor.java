package kr.or.ddit.batch.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


						//reader 로 부터 들어오는 타입
						//processor에서 처리하면 writer로 넘기는 타입
public class RangerProcessor implements ItemProcessor<String, String>{
		private static final Logger logger = LoggerFactory.getLogger(RangerProcessor.class);

		//메소드 인자 item : reader를 통해 받은 배치 처리 대상
	    //리턴 : processor에서 처리한 값 (writer로 넘길 값)
		@Override
		public String process(String item) throws Exception {
			logger.debug("item - {}", item);
			
			String itemProcessor = item + "_modified";
			logger.debug("itemProcessor - {}", itemProcessor);
			return itemProcessor;
		}
	
}
