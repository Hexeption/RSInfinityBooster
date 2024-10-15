package uk.co.hexeption.rsinfinitybooster;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.LoadingModList;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.hexeption.rsinfinitybooster.config.ServerConfig;
import uk.co.hexeption.rsinfinitybooster.setup.ModItems;
import uk.co.hexeption.rsinfinitybooster.setup.Registration;

import java.lang.reflect.Field;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("rsinfinitybooster")
public class RSInfinityBooster {

    public static final String ID = "rsinfinitybooster";
    public static final ServerConfig SERVER_CONFIG = new ServerConfig();

    public RSInfinityBooster() {

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG.getSpec());

        Registration.register();

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener((RegisterEvent event) -> {
            if (event.getRegistryKey() == Registries.CREATIVE_MODE_TAB) {
                registerTab(event.getVanillaRegistry());
            }
        });
    }


    public static void registerTab(Registry<CreativeModeTab> registry) {
        var tab = CreativeModeTab.builder()
                .icon(() -> new ItemStack(ModItems.INFINITY_CARD.get()))
                .displayItems((itemDisplayParameters, output) -> {

                            for (Field field : ModItems.class.getFields()) {
                                if (field.getType() != RegistryObject.class) continue;

                                try {
                                    RegistryObject<Item> item = (RegistryObject<Item>) field.get(null);
                                    output.accept(new ItemStack(item.get()));
                                } catch (IllegalAccessException e) {
                                }
                            }

                        }
                )
                .title(Component.translatable("item_group." + ID + ".tab"))
                .build();
        Registry.register(registry, new ResourceLocation(ID, "aeinfinitybooster"), tab);

    }

    // From AE https://github.com/AppliedEnergistics/Applied-Energistics-2/blob/3552335d5d06dccd4f717510eda8bc7a39937a9e/src/main/java/appeng/mixins/ConfigPlugin.java#L52
    public static boolean isModLoaded(String modId) {
        if (ModList.get() == null) {
            return LoadingModList.get().getMods().stream().map(ModInfo::getModId).anyMatch(modId::equals);
        }
        return ModList.get().isLoaded(modId);
    }
}
