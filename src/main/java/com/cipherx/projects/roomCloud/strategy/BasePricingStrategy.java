package com.cipherx.projects.roomCloud.strategy;

import com.cipherx.projects.roomCloud.entity.Inventory;

import java.math.BigDecimal;

public class BasePricingStrategy implements PricingStrategy{

    @Override
    public BigDecimal calculatePrice(Inventory inventory){
        return inventory.getRoom().getBasePrice();
    }
}
