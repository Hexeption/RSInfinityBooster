package uk.co.hexeption.rsinfinitybooster.item.group;

import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

/**
 * MainItemGroup
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 04:48 pm
 */
public class MainItemGroup extends ItemGroup {

	public MainItemGroup() {
		super(RSInfinityBooster.ID);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(Items.CHAIN);
	}
}
