package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        Arrays.stream(items).forEach(this::update);
    }

    private void update(Item item) {
        updateQualityOf(item);
        updateSellInOf(item);
        updateExpired(item);
    }

    private void updateQualityOf(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQualityOf(item);

        } else if (item.name.equals("Backstage passes to a Metallica concert")) {
            updateByDays(item, 11);
            updateByDays(item, 6);
            increaseQualityOf(item);

        } else if (!item.name.equals("Sulfuras, Hand of Ragnaros"))
            decreaseQualityOf(item);
    }

    private void updateSellInOf(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }


    private void updateExpired(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                increaseQualityOf(item);
            } else {
                if (item.name.equals("Backstage passes to a Metallica concert")) {
                    item.quality = 0;
                } else {
                    if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        return;
                    }
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }
            }
        }
    }

    private void increaseQualityOf(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQualityOf(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void updateByDays(Item item, int days) {
        if (item.sellIn < days) {
            increaseQualityOf(item);
        }
    }
}
