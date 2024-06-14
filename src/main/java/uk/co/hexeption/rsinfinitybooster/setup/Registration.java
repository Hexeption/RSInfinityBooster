package uk.co.hexeption.rsinfinitybooster.setup;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;

/**
 * Registration
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 07:27 pm
 */
public class Registration {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RSInfinityBooster.MODID);

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);

		ModItems.register();
	}

}
