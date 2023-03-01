package com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

	private Item[] items;
    private GildedRose gildedRose;

    @Before
    void setUp() {
        items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                // new category of items
                new Item("Conjured Mana Cake", 3, 6)
        };
        gildedRose = new GildedRose(items);
    }

    @Test
    void testUpdateQuality() {
        gildedRose.updateQuality();

        // Check all the items except the legendary one
        for (int i = 0; i < items.length - 1; i++) {
            String itemName = items[i].name;
            int expectedSellIn = items[i].sellIn - 1;
            int expectedQuality = items[i].quality;

            if (!itemName.equals("Sulfuras, Hand of Ragnaros")) {
                expectedQuality--;
            }

            if (itemName.equals("Aged Brie") || itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                expectedQuality++;
                if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (expectedSellIn < 10) {
                        expectedQuality++;
                    }
                    if (expectedSellIn < 5) {
                        expectedQuality++;
                    }
                }
            }

            if (itemName.equals("Conjured Mana Cake")) {
                expectedQuality -= 2;
            }

            expectedQuality = Math.max(0, expectedQuality);
            expectedQuality = Math.min(50, expectedQuality);

            assertEquals(expectedSellIn, items[i].sellIn);
            assertEquals(expectedQuality, items[i].quality);
        }
    }

}
