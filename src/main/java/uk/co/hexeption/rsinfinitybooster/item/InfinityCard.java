package uk.co.hexeption.rsinfinitybooster.item;

import com.refinedmods.refinedstorage.item.UpgradeItem;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import com.refinedmods.refinedstorage.item.UpgradeItem.Type;

import java.util.Collection;

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
	public boolean isFoil(ItemStack stack) {
		return true;
	}
}
