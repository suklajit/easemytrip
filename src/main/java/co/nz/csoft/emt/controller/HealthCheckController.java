package co.nz.csoft.emt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mmt")
public class HealthCheckController {
	private final static Logger logger = LoggerFactory.getLogger(HealthCheckController.class);

	@RequestMapping(value = "/healthCheck", method = RequestMethod.GET)
	public String welcome() {
		logger.info(" ***** Welcome to BookOne-MMT API****");
		logger.warn(" ***** No Warning ***");
//		logger.info("Time With Zone "+new java.util.Date());
		return " **** Welcome To BookOne-MMT-Integration API! ***** ";
	}
}
