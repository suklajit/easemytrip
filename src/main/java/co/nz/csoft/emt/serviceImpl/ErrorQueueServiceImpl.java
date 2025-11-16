//package co.nz.csoft.emt.serviceImpl;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import co.nz.csoft.emt.dto.ErrorObject;
//
//@Service
//public class ErrorQueueServiceImpl {
//	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
//	@Value("${bookone.API.url}")
//    private String bookoneUrl;
//	RestTemplate restTemplate = new RestTemplate();
//	ObjectMapper objMapper = new ObjectMapper();
//	public void sendErrorToQueue(ErrorObject errorObject) {
//		try {
//            log.info("******Sending Error Message to Q_Error_Reservations.....*****");
//            log.info("******Message....*****:" + objMapper.writeValueAsString(errorObject));
//            restTemplate.postForObject(
//            		bookoneUrl + "/api/website/errorObj", errorObject,
//    				Void.class);
//            log.info("******Sending Error Message to Q_Error_Reservations - DONE*****");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//
//	}
//
//}
//
//
