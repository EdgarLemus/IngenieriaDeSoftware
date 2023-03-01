package com.gildedrosesolucion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.gildedrose.Item;
import com.gildedrose.solucion.GildedRose;

public class GildedRoseTest {

	@Test
    void testUpdateQuality() {
        Item[] items = new Item[] { new Item("foo", 0, 0), 
                                    new Item("Aged Brie", 10, 5), 
                                    new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                                    new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        // Comprobar que los valores de calidad se actualizan correctamente al cabo de un día
        assertEquals(0, items[0].quality);
        assertEquals(6, items[1].quality);
        assertEquals(21, items[2].quality);
        assertEquals(80, items[3].quality);
        
        // Compruebe que los valores de sellIn se actualizan correctamente al cabo de un día
        assertEquals(-1, items[0].sellIn);
        assertEquals(9, items[1].sellIn);
        assertEquals(14, items[2].sellIn);
        assertEquals(0, items[3].sellIn);
        
        // Comprobar que los valores de calidad nunca son negativos
        assertTrue(items[0].quality >= 0);
        assertTrue(items[1].quality >= 0);
        assertTrue(items[2].quality >= 0);
        assertTrue(items[3].quality >= 0);
        
        // Comprueba que los valores de calidad nunca sean superiores al 50
        assertTrue(items[1].quality <= 50);
        assertTrue(items[2].quality <= 50);
    }
}
