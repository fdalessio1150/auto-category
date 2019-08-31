package br.com.dalessio.auto.category.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {

	private MessageSourceAccessor accessor;

	@Autowired
	public MessageUtils(ReloadableResourceBundleMessageSource messageSource, @Value("${spring.mvc.locale}") String locale) {
		this.accessor = new MessageSourceAccessor(messageSource, new Locale(locale));
	}
	
	public String getMessage(String code) {
		return accessor.getMessage(code);
	}
	
	public String getMessageAndSubParams(String code, String... args) {
		return accessor.getMessage(code, args);
	}
}
