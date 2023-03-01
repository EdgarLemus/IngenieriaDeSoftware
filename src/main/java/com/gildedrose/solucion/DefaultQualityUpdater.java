package com.gildedrose.solucion;

import com.gildedrose.Item;

public class DefaultQualityUpdater implements QualityUpdater{

	@Override
	public void updateQuality(Item item) {
		if (item.quality > 0) {
            item.quality--;
        }

        item.sellIn--;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
	}

}
