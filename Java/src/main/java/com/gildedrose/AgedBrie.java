package com.gildedrose;

public class AgedBrie extends ItemCategory {
    void updateQualityOf(Item item) {
        increaseQualityOf(item);
    }

    void updateSellInOf(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    void updateExpired(Item item) {
        increaseQualityOf(item);
    }
}
