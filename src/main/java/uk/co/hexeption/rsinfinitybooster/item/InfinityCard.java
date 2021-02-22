package uk.co.hexeption.rsinfinitybooster.item;

import com.refinedmods.refinedstorage.RS;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * InfinityCard
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 05:15 pm
 */
public class InfinityCard extends Item {
	public InfinityCard() {
		super((new Properties()).group(RS.MAIN_GROUP));
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
