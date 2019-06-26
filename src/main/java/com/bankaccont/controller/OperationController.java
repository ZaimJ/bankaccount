package com.bankaccont.controller;


import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/operation")
public interface OperationController {

	@RequestMapping(value = "/deposit/{accountId}/{amount}", method = RequestMethod.GET, produces = "application/json")
	Response depositAmount(@PathVariable("accountId") final Long accountId,
			@PathVariable("amount") final float amount) throws Exception;

	@RequestMapping(value = "/withdraw/{accountId}/{amount}", method = RequestMethod.GET,
			produces = "application/json")
	Response withdrawAmount(@PathVariable("accountId") final Long accountId,
			@PathVariable("amount") final float amount) throws Exception;

	@RequestMapping(value = "/transfer/{accountId}/{destinationAccountId}/{amount}", method = RequestMethod.GET,
			produces = "application/json")
	Response transfer(@PathVariable("accountId") final Long accountId,
			@PathVariable("destinationAccountId") final Long destinationAccountId,
			@PathVariable("amount") final float amount,
			@PathVariable("motif") final String motif) throws Exception;

	@RequestMapping(value = "/historyFrom/{accountId}", method = RequestMethod.GET, produces = "application/json")
	Response historyFrom(@PathVariable("accountId") final Long accountId);

	@RequestMapping(value = "/historyTo/{accountId}", method = RequestMethod.GET, produces = "application/json")
	Response historyTo(@PathVariable("accountId") final Long accountId);

}
