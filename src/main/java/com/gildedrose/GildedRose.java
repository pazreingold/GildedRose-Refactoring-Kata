package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        ItemCategory category = new ItemCategory();
        Arrays.stream(items).forEach(item -> update(item, category));
    }

    private void update(Item item, ItemCategory category) {
        updateQualityOf(item, category);
        updateSellInOf(item, category);
        if (item.sellIn < 0) {
            updateExpired(item, category);
        }
    }

    private void updateQualityOf(Item item, ItemCategory category) {
        if (item.name.equals("Aged Brie")) {
            increaseQualityOf(item, category);

        } else if (item.name.equals("Backstage passes to a Metallica concert")) {
            updateByDays(item, 11, category);
            updateByDays(item, 6, category);
            increaseQualityOf(item, category);

        } else if (!item.name.equals("Sulfuras, Hand of Ragnaros"))
            decreaseQualityOf(item, category);
    }

    private void updateSellInOf(Item item, ItemCategory category) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateExpired(Item item, ItemCategory category) {
        if (item.name.equals("Aged Brie")) {
            increaseQualityOf(item, category);
        } else if (item.name.equals("Backstage passes to a Metallica concert")) {
            item.quality = 0;
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
        } else decreaseQualityOf(item, category);
    }


    private void increaseQualityOf(Item item, ItemCategory category) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQualityOf(Item item, ItemCategory category) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void updateByDays(Item item, int days, ItemCategory category) {
        if (item.sellIn < days) {
            increaseQualityOf(item, category);
        }
    }
}
