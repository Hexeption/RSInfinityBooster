package uk.co.hexeption.rsinfinitybooster.item;

import com.refinedmods.refinedstorage.item.UpgradeItem;

import net.minecraft.item.ItemStack;

/**
 * InfinityCard
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 05:15 pm
 */
public class InfinityCard extends UpgradeItem {
	public InfinityCard() {
		super(Type.RANGE);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
