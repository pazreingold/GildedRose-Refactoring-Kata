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
        if (item.name.equals("Aged Brie")) {
            increaseQualityOf(item);

        } else if (item.name.equals("Backstage passes to a Metallica concert")) {
            updateByDays(item, 11);
            updateByDays(item, 6);
            increaseQualityOf(item);

        } else {
            decreaseQualityOf(item);
        }
    }

    void updateSellInOf(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    void updateExpired(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQualityOf(item);
        } else if (item.name.equals("Backstage passes to a Metallica concert")) {
            item.quality = 0;
        } else decreaseQualityOf(item);
    }

    void updateByDays(Item item, int days) {
        if (item.sellIn < days) {
            increaseQualityOf(item);
        }
    }

    void increaseQualityOf(Item item) {
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
