package uk.co.hexeption.rsinfinitybooster.utils;

import com.refinedmods.refinedstorage.inventory.item.BaseItemHandler;
import uk.co.hexeption.rsinfinitybooster.item.DimensionCard;
import uk.co.hexeption.rsinfinitybooster.item.InfinityCard;

import net.minecraft.world.item.ItemStack;

/**
 * CardUtil
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 01/03/2021 - 04:34 pm
 */
public class CardUtil {

	public static boolean isDimensionCard(BaseItemHandler upgrades) {
		for (int i = 0; i < upgrades.getSlots(); ++i) {
			ItemStack slot = upgrades.getStackInSlot(i);
			if (slot.getItem() instanceof DimensionCard) {
				return true;
			}
		}
		return false;
	}


	public static boolean isInfinityCard(BaseItemHandler upgrades) {
		for (int i = 0; i < upgrades.getSlots(); ++i) {
			ItemStack slot = upgrades.getStackInSlot(i);
			if (slot.getItem() instanceof InfinityCard) {
				return true;
			}
		}
		return false;
	}

	public static boolean isBothCards(BaseItemHandler upgrades) {
		int j = 0;
		for (int i = 0; i < upgrades.getSlots(); ++i) {
			ItemStack slot = upgrades.getStackInSlot(i);
			if (slot.getItem() instanceof InfinityCard) {
				j++;
			}
			if (slot.getItem() instanceof DimensionCard) {
				j++;
			}
		}
		return j > 1;
	}

}
