package uk.co.hexeption.rsinfinitybooster.item;

import com.refinedmods.refinedstorage.RS;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * DimensionCard
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 01/03/2021 - 04:33 pm
 */
public class DimensionCard extends Item {
	public DimensionCard() {
		super((new Properties()).tab(RS.MAIN_GROUP));
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return true;
	}
}
