package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        Arrays.stream(items).forEach(this::updateItem);
    }

    private void updateItem(Item item) {
        ItemCategory category = new ItemCategory();
        category.update(item);
    }


}
