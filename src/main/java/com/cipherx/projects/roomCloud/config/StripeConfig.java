package com.cipherx.projects.roomCloud.config;

import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {

    public StripeConfig(@Value("${stripe.secret.key}") String stripeSecretKey){
        Stripe.apiKey = stripeSecretKey;
    }
}
