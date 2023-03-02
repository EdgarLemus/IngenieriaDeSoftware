package com.gildedrose;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GildedRoseTest{

	private Item[] items;
    private GildedRose gildedRose;

    @BeforeEach
    void setUp() {
        items = new Item[] { new Item("foo", 10, 20), new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Aged Brie", 2, 0) };
        gildedRose = new GildedRose(items);
    }

    @Test
    @DisplayName("Test updateQuality method for normal item")
    void testUpdateQualityForNormalItem() {
        gildedRose.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    @DisplayName("Test updateQuality method for Sulfuras item")
    void testUpdateQualityForSulfurasItem() {
        gildedRose.updateQuality();
        assertEquals(0, items[1].sellIn);
        assertEquals(80, items[1].quality);
    }

    @Test
    @DisplayName("Test updateQuality method for Backstage Passes item with more than 10 days to sell")
    void testUpdateQualityForBackstagePassesItemMoreThan10Days() {
        gildedRose.updateQuality();
        assertEquals(14, items[2].sellIn);
        assertEquals(21, items[2].quality);
    }

    @Test
    @DisplayName("Test updateQuality method for Backstage Passes item with 10 days or less to sell")
    void testUpdateQualityForBackstagePassesItem10DaysOrLess() {
        items[2].sellIn = 10;
        gildedRose.updateQuality();
        assertEquals(9, items[2].sellIn);
        assertEquals(22, items[2].quality);
    }

    @Test
    @DisplayName("Test updateQuality method for Backstage Passes item with 5 days or less to sell")
    void testUpdateQualityForBackstagePassesItem5DaysOrLess() {
        items[2].sellIn = 5;
        gildedRose.updateQuality();
        assertEquals(4, items[2].sellIn);
        assertEquals(23, items[2].quality);
    }

    @Test
    @DisplayName("Test updateQuality method for Backstage Passes item with 0 days to sell")
    void testUpdateQualityForBackstagePassesItem0Days() {
        items[2].sellIn = 0;
        gildedRose.updateQuality();
        assertEquals(-1, items[2].sellIn);
        assertEquals(0, items[2].quality);
    }

    @Test
    @DisplayName("Test updateQuality method for Aged Brie item")
    void testUpdateQualityForAgedBrieItem() {
        gildedRose.updateQuality();
        assertEquals(1, items[3].sellIn);
        assertEquals(1, items[3].quality);
    }
}
