package uk.co.hexeption.rsinfinitybooster.item;

import com.refinedmods.refinedstorage.RS;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * DimensionCard
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 01/03/2021 - 03:48 pm
 */
public class DimensionCard extends Item {
	public DimensionCard() {
		super((new Properties()).group(RS.MAIN_GROUP));
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
