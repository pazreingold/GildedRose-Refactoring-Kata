package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void qualityAndSellInBehaveAsExpected() {
        Item[] items = createItems();
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertTheFollowing("Antique table", items[0].name, 9, items[0].sellIn, 19, items[0].quality);
        assertTheFollowing("Antique chair", items[1].name, 9, items[1].sellIn, 0, items[1].quality);
        assertTheFollowing("Antique chair", items[2].name, -1, items[2].sellIn, 0, items[2].quality);
        assertTheFollowing("Aged Brie", items[3].name, 1, items[3].sellIn, 1, items[3].quality);
        assertTheFollowing("Aged Brie", items[4].name, -1, items[4].sellIn, 2, items[4].quality);
        assertTheFollowing("Sulfuras, Hand of Ragnaros", items[5].name, 0, items[5].sellIn, 50, items[5].quality);
        assertTheFollowing("Backstage passes to a Metallica concert", items[6].name, 14, items[6].sellIn, 21, items[6].quality);
        assertTheFollowing("Backstage passes to a Metallica concert", items[7].name, 9, items[7].sellIn, 50, items[7].quality);
        assertTheFollowing("Backstage passes to a Metallica concert", items[8].name, 4, items[8].sellIn, 50, items[8].quality);
        assertTheFollowing("Backstage passes to a Metallica concert", items[9].name, -1, items[9].sellIn, 0, items[9].quality);
    }

    private Item[] createItems() {
        return new Item[]{
                new Item("Antique table", 10, 20),
                new Item("Antique chair", 10, 0),
                new Item("Antique chair", 0, 2),
                new Item("Aged Brie", 2, 0),
                new Item("Aged Brie", 0, 0),
                new Item("Sulfuras, Hand of Ragnaros", 0, 50),
                new Item("Backstage passes to a Metallica concert", 15, 20),
                new Item("Backstage passes to a Metallica concert", 10, 48),
                new Item("Backstage passes to a Metallica concert", 5, 47),
                new Item("Backstage passes to a Metallica concert", 0, 15)
        };
    }

    private void assertTheFollowing(String expectedName, String name, int expectedSellIn, int sellIn, int expectedQuality, int quality) {
        assertEquals(expectedName, name);
        assertEquals(expectedSellIn, sellIn);
        assertEquals(expectedQuality, quality);
    }
}
