package com.gildedrose.solucion;

import com.gildedrose.Item;

public class AgedBrieQualityUpdater implements QualityUpdater{

	@Override
	public void updateQuality(Item item) {
		if (item.quality < 50) {
            item.quality++;
        }

        item.sellIn--;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
	}

}
