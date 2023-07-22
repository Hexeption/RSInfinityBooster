package uk.co.hexeption.rsinfinitybooster.item;

import com.refinedmods.refinedstorage.RS;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * DimensionCard
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 01/03/2021 - 04:33 pm
 */
public class DimensionCard extends Item {
	public DimensionCard() {
		super(new Item.Properties().durability(0));
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return true;
	}
}
