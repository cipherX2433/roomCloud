package com.cipherx.projects.roomCloud.strategy;

import com.cipherx.projects.roomCloud.entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);
}
