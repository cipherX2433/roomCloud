package com.cipherx.projects.roomCloud.service;

import com.cipherx.projects.roomCloud.entity.Booking;

public interface CheckoutService {

    String getCheckoutSession(Booking booking, String successUrl, String failureUrl);
}
