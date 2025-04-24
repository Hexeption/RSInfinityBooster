package uk.co.hexeption.rsinfinitybooster.item;

import com.refinedmods.refinedstorage.common.api.upgrade.AbstractUpgradeItem;
import com.refinedmods.refinedstorage.common.api.upgrade.UpgradeItem;
import com.refinedmods.refinedstorage.common.api.upgrade.UpgradeRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;

/**
 * DimensionCard
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 01/03/2021 - 04:33 pm
 */
public class DimensionCard extends AbstractUpgradeItem {

    private static final Component HELP = Component.translatable("item." + RSInfinityBooster.MODID + ".tooltip.dimension_card.help");

    public DimensionCard(final UpgradeRegistry registry) {

        super(new Item.Properties(), registry, HELP);
    }

    @Override
    public boolean isFoil(ItemStack stack) {

        return true;
    }

    @Override
    public long getEnergyUsage() {

        return RSInfinityBooster.SERVER_CONFIG.getDimensionCard().getEnergyUsage();
    }

}
