package uk.co.hexeption.rsinfinitybooster;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.co.hexeption.rsinfinitybooster.config.ServerConfig;
import uk.co.hexeption.rsinfinitybooster.setup.ModItems;
import uk.co.hexeption.rsinfinitybooster.setup.Registration;

import java.lang.reflect.Field;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("rsinfinitybooster")
public class RSInfinityBooster {

    public static final String MODID = "rsinfinitybooster";
    public static final ServerConfig SERVER_CONFIG = new ServerConfig();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> AEBOOSTER_TAB = CREATIVE_MODE_TAB.register("aebooster", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group." + MODID + ".tab"))
            .icon(() -> new ItemStack(ModItems.INFINITY_CARD.get()))
            .displayItems(((pParameters, pOutput) -> {
                for (Field field : ModItems.class.getFields()) {
                    if(field.getType() != DeferredItem.class) continue;

                    try{
                        DeferredItem<Item> item = (DeferredItem<Item>) field.get(null);
                        pOutput.accept(new ItemStack(item.get()));
                    }catch (IllegalAccessException e){

                    }
                }
            }))
            .build());


    public RSInfinityBooster(IEventBus modEventBus, ModContainer modContainer) {

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG.getSpec());

        Registration.register(modEventBus);

        CREATIVE_MODE_TAB.register(modEventBus);

    }



}
