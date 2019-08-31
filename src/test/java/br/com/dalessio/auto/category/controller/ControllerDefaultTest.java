package br.com.dalessio.auto.category.controller;

import static br.com.dalessio.auto.category.constants.Constants.RoutesTest.TEST_RT_ACCOUNT_AUTO_CATEGORY_ROUTE;
import static java.lang.String.format;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.dalessio.auto.category.AutoCategoryExceptionHandler;
import br.com.dalessio.auto.category.AutoCategoryTestConfiguration;
import br.com.dalessio.auto.category.utils.LogUtils;
import br.com.dalessio.auto.category.utils.MessageUtils;

@WebMvcTest
@TestInstance(Lifecycle.PER_CLASS)
@Import(AutoCategoryTestConfiguration.class)
@TestPropertySource(locations ="classpath:/application-test.properties")
public class ControllerDefaultTest {

	@Autowired
	private AccountController controller;

	@Autowired
	private MessageUtils messageUtils;

	@Autowired
	private LogUtils logUtils;

	@Autowired
	private MockMvc mvc;

	@BeforeAll
	public void setup() {
		MockMvcBuilders.standaloneSetup(controller)
				.setControllerAdvice(new AutoCategoryExceptionHandler(logUtils, messageUtils))
				.build();
	}

	@Test
	public void should_validade_query_parameter_from_date_is_not_present() throws Exception {
		String customerId = "59186047078";
		mvc.perform(post(format(TEST_RT_ACCOUNT_AUTO_CATEGORY_ROUTE, customerId)))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Parâmetro obrigatório from_date não está presente."));
	}

}
