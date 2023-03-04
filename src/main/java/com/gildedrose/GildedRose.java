package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        ItemCategory category = new ItemCategory();
        Arrays.stream(items).forEach(item -> category.update(item));
    }


}
