package com.example.demo;

import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StirpeConfig {
	
		@Configuration
		public class StripeConfig {

			@Value("${stripe.secretKey}")
			private String secretKey;

	        @Bean
	        public String initStripe() {
		        Stripe.apiKey = secretKey;
		        
		        return Stripe.apiKey;
		    }
		}

}
