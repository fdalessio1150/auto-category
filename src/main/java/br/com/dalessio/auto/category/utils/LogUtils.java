package br.com.dalessio.auto.category.utils;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Component;

@Component
public class LogUtils {
	
	public void logError(String message, Class<?> clazz) {
		LogManager.getLogger(clazz).error(message);
	}
	
	public void logStackTrace(Throwable ex, Class<?> clazz) {
		LogManager.getLogger(clazz).error(ex);
	}
}
