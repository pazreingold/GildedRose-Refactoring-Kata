package com.gildedrose;

public class ItemCategory {
    public static final int MAX_QUALITY = 50;
    public static final int MINIMUM_QUALITY = 0;

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
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    void decreaseQualityOf(Item item) {
        if (item.quality > MINIMUM_QUALITY) {
            item.quality = item.quality - 1;
        }
    }
}
