package uk.co.hexeption.rsinfinitybooster.setup;

import com.refinedmods.refinedstorage.common.RefinedStorageApiImpl;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import uk.co.hexeption.rsinfinitybooster.item.DimensionCard;
import uk.co.hexeption.rsinfinitybooster.item.InfinityCard;

/**
 * ModItems
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 07:26 pm
 */
public class ModItems {

	public static final DeferredItem<Item> INFINITY_CARD = Registration.ITEMS.register("infinity_card", resourceLocation -> new InfinityCard(RefinedStorageApiImpl.INSTANCE.getUpgradeRegistry()));
	public static final DeferredItem<Item> DIMENSION_CARD = Registration.ITEMS.register("dimension_card", resourceLocation -> new DimensionCard(RefinedStorageApiImpl.INSTANCE.getUpgradeRegistry()));

	static void register() {
	}

}
