package br.com.dalessio.auto.category.controller;

import static br.com.dalessio.auto.category.constants.Constants.Routes.RT_ACCOUNT_AUTO_CATEGORY_ROUTE;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dalessio.auto.category.annotations.CpfCnpj;
import br.com.dalessio.auto.category.utils.MessageUtils;

@RestController
@Validated
public class AccountController {

	private MessageUtils messageUtils;

	@Autowired
	public AccountController(MessageUtils messageUtils) {
		this.messageUtils = messageUtils;
	}

	@PostMapping(RT_ACCOUNT_AUTO_CATEGORY_ROUTE)
	public String accountAutoCategory(@PathVariable(name = "customer_id") @CpfCnpj String customerId,
			@RequestParam(name = "from_date") @NotBlank String fromDate) {

		return messageUtils.getMessageAndSubParams("teste", customerId);
	}
}
