package uk.co.hexeption.rsinfinitybooster.setup;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import uk.co.hexeption.rsinfinitybooster.item.DimensionCard;
import uk.co.hexeption.rsinfinitybooster.item.InfinityCard;

/**
 * ModItems
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 07:26 pm
 */
public class ModItems {

	public static final RegistryObject<Item> INFINITY_CARD = Registration.ITEMS.register("infinity_card", InfinityCard::new);
	public static final RegistryObject<Item> DIMENSION_CARD = Registration.ITEMS.register("dimension_card", DimensionCard::new);

	static void register() {
	}

}
