package com.gildedrose.solucion;

import com.gildedrose.Item;

public class GildedRose {

	Item[] items;
    QualityUpdater[] qualityUpdaters;

    public GildedRose(Item[] items) {
        this.items = items;

        qualityUpdaters = new QualityUpdater[] {
            new DefaultQualityUpdater(),
            new AgedBrieQualityUpdater(),
            new BackstagePassQualityUpdater()
        };
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            QualityUpdater qualityUpdater = null;

            switch (items[i].name) {
                case "Aged Brie":
                    qualityUpdater = qualityUpdaters[1];
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    qualityUpdater = qualityUpdaters[2];
                    break;
                default:
                    qualityUpdater = qualityUpdaters[0];
            }

            qualityUpdater.updateQuality(items[i]);
        }
    }
    
    public void updateQualityForNewCategory(Item[] items) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("New Category Item")) {
                // Actualizar la calidad del item de la nueva categoría
                if (items[i].quality > 0) {
                    items[i].quality = items[i].quality - 1;
                }

                // Actualizar el sellIn del item de la nueva categoría
                items[i].sellIn = items[i].sellIn - 1;

                // Si sellIn es negativo, la calidad disminuye al doble de la velocidad
                if (items[i].sellIn < 0 && items[i].quality > 0) {
                    items[i].quality = items[i].quality - 1;
                }
            }
        }
    }
}
