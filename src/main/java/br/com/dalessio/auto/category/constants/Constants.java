package br.com.dalessio.auto.category.constants;

public class Constants {

	public static class Routes {
		public Routes() {
		}
		
		public static final String RT_ACCOUNT_AUTO_CATEGORY_ROUTE = "/v1/api/account/{customer_id}/auto_category";
		public static final String RT_CARD_AUTO_CATEGORY_ROUTE = "/v1/api/card/{customer_id}/auto_category";
	}
	
	public static class RoutesTest {
		public RoutesTest() {
		}
		
		public static final String TEST_RT_ACCOUNT_AUTO_CATEGORY_ROUTE = "/v1/api/account/%s/auto_category";
		public static final String TEST_RT_CARD_AUTO_CATEGORY_ROUTE = "/v1/api/card/%s/auto_category";
	}
}
