package uk.co.hexeption.rsinfinitybooster.mixins;


import com.refinedmods.refinedstorage.RS;
import com.refinedmods.refinedstorage.apiimpl.network.node.WirelessTransmitterNetworkNode;
import com.refinedmods.refinedstorage.inventory.item.UpgradeItemHandler;
import net.gigabit101.rebornstorage.nodes.AdvancedWirelessTransmitterNode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;
import uk.co.hexeption.rsinfinitybooster.utils.CardUtil;

@Mixin(value = AdvancedWirelessTransmitterNode.class, remap = false)
public class MixinAdvancedWirelessTransmitterNode {

    @Shadow
    @Final
    private UpgradeItemHandler upgrades;


    @Inject(method = "getRange", at = @At("HEAD"), cancellable = true)
    private void getRange(CallbackInfoReturnable<Integer> cir) {

        if (CardUtil.isInfinityCard(upgrades)) {
            cir.setReturnValue(Integer.MAX_VALUE);
        }

        if (CardUtil.isDimensionCard(upgrades)) {
            cir.setReturnValue(Integer.MAX_VALUE);
        }
    }

    @Inject(method = "getEnergyUsage", at = @At("HEAD"), cancellable = true)
    private void getEnergyUsage(CallbackInfoReturnable<Integer> cir) {

        if (CardUtil.isBothCards(upgrades)) {
            cir.setReturnValue(RS.SERVER_CONFIG.getWirelessTransmitter().getUsage() + RSInfinityBooster.SERVER_CONFIG.getInfinityCard().getEnergyUsage() + RSInfinityBooster.SERVER_CONFIG.getDimensionCard().getEnergyUsage());
            return;
        }

        if (CardUtil.isInfinityCard(upgrades)) {
            cir.setReturnValue(RS.SERVER_CONFIG.getWirelessTransmitter().getUsage() + RSInfinityBooster.SERVER_CONFIG.getInfinityCard().getEnergyUsage());
            return;
        }

        if (CardUtil.isDimensionCard(upgrades)) {
            cir.setReturnValue(RS.SERVER_CONFIG.getWirelessTransmitter().getUsage() + RSInfinityBooster.SERVER_CONFIG.getDimensionCard().getEnergyUsage());
            return;
        }

    }
}
