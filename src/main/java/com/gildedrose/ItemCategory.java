package com.gildedrose;

public class ItemCategory {
    void update(Item item) {
        updateQualityOf(item);
        updateSellInOf(item);
        if (item.sellIn < 0) {
            updateExpired(item);
        }
    }

    void updateQualityOf(Item item) {
        decreaseQualityOf(item);
    }

    void updateSellInOf(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    void updateExpired(Item item) {
        decreaseQualityOf(item);
    }

    void updateByDays(Item item, int days) {
        if (item.sellIn < days) {
            increaseQualityOf(item);
        }
    }

    protected void increaseQualityOf(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    void decreaseQualityOf(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
