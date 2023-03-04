package com.gildedrose;

public class Backstage extends ItemCategory {
    void updateQualityOf(Item item) {
        updateByDays(item, 11);
        updateByDays(item, 6);
        increaseQualityOf(item);

    }

    void updateExpired(Item item) {
        item.quality = 0;
    }
}
