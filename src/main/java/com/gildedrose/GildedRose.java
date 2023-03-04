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
        ItemCategory category = categorize(item);
        category.update(item);
    }

    private ItemCategory categorize(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")){
            return new Sulfuras();
        }
        return new ItemCategory();
    }


}
