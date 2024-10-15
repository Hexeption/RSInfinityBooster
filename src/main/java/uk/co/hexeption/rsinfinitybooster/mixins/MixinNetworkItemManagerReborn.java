package uk.co.hexeption.rsinfinitybooster.mixins;

import com.refinedmods.refinedstorage.api.network.INetwork;
import com.refinedmods.refinedstorage.api.network.item.INetworkItem;
import com.refinedmods.refinedstorage.api.network.item.INetworkItemManager;
import com.refinedmods.refinedstorage.api.network.item.INetworkItemProvider;
import com.refinedmods.refinedstorage.api.network.node.INetworkNode;
import com.refinedmods.refinedstorage.apiimpl.network.item.NetworkItemManager;
import com.refinedmods.refinedstorage.apiimpl.network.node.WirelessTransmitterNetworkNode;
import com.refinedmods.refinedstorage.inventory.item.BaseItemHandler;
import com.refinedmods.refinedstorage.inventory.player.PlayerSlot;
import java.util.Map;
import net.gigabit101.rebornstorage.nodes.AdvancedWirelessTransmitterNode;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;
import uk.co.hexeption.rsinfinitybooster.utils.CardUtil;

/**
 * MixinNetworkItemManager
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 01/03/2021 - 04:34 pm
 */
@Mixin(value = NetworkItemManager.class, remap = false)
public abstract class MixinNetworkItemManagerReborn implements INetworkItemManager {

    @Shadow
    @Final
    private INetwork network;

    @Shadow
    @Final
    private Map<Player, INetworkItem> items;


    @Unique
    private void rSInfinityBooster$handleTransmitterOpen(Player player, ItemStack itemStack, PlayerSlot playerSlot, INetworkNode node, BaseItemHandler upgrades, CallbackInfo ci) {
        if (!node.isActive()) {
            return;
        }
        if (CardUtil.isDimensionCard(upgrades)) {
            INetworkItem item = ((INetworkItemProvider) itemStack.getItem()).provide(this, player, itemStack, playerSlot);
            if (item.onOpen(this.network)) {
                this.items.put(player, item);
            }
            ci.cancel();
        }
    }


    @Inject(method = "open", at = @At("HEAD"), cancellable = true)
    private void onOpen(Player player, ItemStack itemStack, PlayerSlot playerSlot, CallbackInfo ci) {
        network.getNodeGraph().all().forEach(iNetworkNode -> {
            INetworkNode node = iNetworkNode.getNode();
            if (node instanceof WirelessTransmitterNetworkNode transmitter) {
                rSInfinityBooster$handleTransmitterOpen(player, itemStack, playerSlot, node, transmitter.getUpgrades(), ci);
            }

            if(RSInfinityBooster.isModLoaded("rebornstorage")) {
                if (node instanceof AdvancedWirelessTransmitterNode transmitter) {
                    rSInfinityBooster$handleTransmitterOpen(player, itemStack, playerSlot, node, transmitter.getUpgrades(), ci);
                }
            }
        });
    }


}
