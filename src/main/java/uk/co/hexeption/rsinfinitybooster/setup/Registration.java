package uk.co.hexeption.rsinfinitybooster.setup;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;

import net.minecraft.world.item.Item;

/**
 * Registration
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 07:27 pm
 */
public class Registration {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RSInfinityBooster.ID);

	public static void register() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ITEMS.register(modEventBus);

		ModItems.register();
	}

}
