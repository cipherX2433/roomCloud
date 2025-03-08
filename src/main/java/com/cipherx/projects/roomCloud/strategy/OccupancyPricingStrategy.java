package com.cipherx.projects.roomCloud.strategy;

import com.cipherx.projects.roomCloud.entity.Inventory;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class OccupancyPricingStrategy implements PricingStrategy{

    private final PricingStrategy wrapped;

    @Override
    public BigDecimal calculatePrice(Inventory inventory){
        BigDecimal price = wrapped.calculatePrice(inventory);
        double ocuupancyRate = (double) inventory.getBookedCount() / inventory.getTotalCount();
        if(ocuupancyRate > 0.8){
            price = price.multiply(BigDecimal.valueOf(1.2));
        }

        return price;
    }
}
