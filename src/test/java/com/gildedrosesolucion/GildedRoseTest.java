package com.gildedrosesolucion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.Item;
import com.gildedrose.solucion.GildedRose;

public class GildedRoseTest {

	private Item[] items;
    private GildedRose gildedRose;

    @BeforeEach
    void setUp() {
        items = new Item[] { new Item("foo", 1, 5) };
        gildedRose = new GildedRose(items);
    }

    @Test
    void testUpdateQualitySellInPositive() {
        gildedRose.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(9, items[0].quality);
    }

    @Test
    void testUpdateQualitySellInNegative() {
        items[0].sellIn = -1;
        gildedRose.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    void testUpdateQualityQualityZero() {
        items[0].quality = 0;
        gildedRose.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test
    void testUpdateQualityQualityFifty() {
        items[0].quality = 50;
        gildedRose.updateQuality();
        assertEquals(49, items[0].quality);
    }

    @Test
    void testUpdateQualityAgedBrie() {
        items[0] = new Item("Aged Brie", 2, 0);
        gildedRose.updateQuality();
        assertEquals(1, items[0].sellIn);
        assertEquals(1, items[0].quality);
    }

    @Test
    void testUpdateQualityBackstagePasses() {
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10);
        gildedRose.updateQuality();
        assertEquals(10, items[0].sellIn);
        assertEquals(11, items[0].quality);

        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        gildedRose.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(12, items[0].quality);

        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
        gildedRose.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(13, items[0].quality);

        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        gildedRose.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testUpdateQualitySulfuras() {
        items[0] = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        gildedRose.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(78, items[0].quality);
    }
    
    @BeforeEach
    void beforeEach() {
        items = new Item[] { new Item("New Item 1", 5, 10),
                             new Item("New Item 2", 0, 5),
                             new Item("New Item 3", 5, 50),
                             new Item("New Item 4", -1, 30) };
        gildedRose = new GildedRose(items);
    }

    @Test
    void testUpdateQualityForNewCategory() {
    	gildedRose.updateQualityForNewCategory(items);

        assertEquals(10, items[0].quality);
        assertEquals(5, items[1].quality);
        assertEquals(50, items[2].quality);
        assertEquals(30, items[3].quality);

        assertEquals(5, items[0].sellIn);
        assertEquals(0, items[1].sellIn);
        assertEquals(5, items[2].sellIn);
        assertEquals(-1, items[3].sellIn);
    }
}
