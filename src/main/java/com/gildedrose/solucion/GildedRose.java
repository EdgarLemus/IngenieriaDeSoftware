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
}
