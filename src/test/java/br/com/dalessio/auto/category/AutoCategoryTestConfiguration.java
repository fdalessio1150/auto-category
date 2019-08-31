package br.com.dalessio.auto.category;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.test.context.TestPropertySource;

import br.com.dalessio.auto.category.utils.LogUtils;
import br.com.dalessio.auto.category.utils.MessageUtils;

@TestPropertySource(locations ="classpath:/application-test.properties")
public class AutoCategoryTestConfiguration {

	@Bean
	public MessageUtils provideMessageSource(@Value("${spring.mvc.locale}") String locale) {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:/messages");
		messageSource.setDefaultEncoding("UTF-8");
		
		MessageUtils messageUtils = new MessageUtils(messageSource, locale);
		
		return messageUtils;
	}
	
	@Bean
	public LogUtils provideLogUtils() {
		return new LogUtils();
	}
}
