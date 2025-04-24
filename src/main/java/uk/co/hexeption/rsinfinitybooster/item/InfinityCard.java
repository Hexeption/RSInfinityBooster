package uk.co.hexeption.rsinfinitybooster.item;

import com.refinedmods.refinedstorage.common.api.upgrade.AbstractUpgradeItem;
import com.refinedmods.refinedstorage.common.api.upgrade.UpgradeItem;
import com.refinedmods.refinedstorage.common.api.upgrade.UpgradeMapping;
import com.refinedmods.refinedstorage.common.api.upgrade.UpgradeRegistry;
import static com.refinedmods.refinedstorage.common.util.IdentifierUtil.createTranslation;
import java.util.Optional;
import java.util.Set;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;

/**
 * InfinityCard
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 05:15 pm
 */
public class InfinityCard extends AbstractUpgradeItem {

    private static final Component HELP = Component.translatable("item." + RSInfinityBooster.MODID + ".tooltip.infinity_card.help");

    public InfinityCard(final UpgradeRegistry registry) {

        super(new Item.Properties(), registry, HELP);
    }

    @Override
    public boolean isFoil(ItemStack stack) {

        return true;
    }

    @Override
    public long getEnergyUsage() {

        return RSInfinityBooster.SERVER_CONFIG.getInfinityCard().getEnergyUsage();
    }

}
