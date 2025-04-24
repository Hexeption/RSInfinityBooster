package uk.co.hexeption.rsinfinitybooster.mixins;

import com.refinedmods.refinedstorage.common.api.support.network.item.NetworkItemPlayerValidator;
import com.refinedmods.refinedstorage.common.networking.WirelessTransmitterBlockEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.hexeption.rsinfinitybooster.setup.ModItems;

@Mixin(targets = "com.refinedmods.refinedstorage.common.networking.WirelessTransmitterNetworkNodeContainer", remap = false)
public class MixinWirelessTransmitterNetworkNodeContainer {

    @Shadow
    @Final
    private WirelessTransmitterBlockEntity blockEntity;

    @Inject(method = "isValid", at = @At("HEAD"), cancellable = true)
    private void isValid(NetworkItemPlayerValidator.PlayerCoordinates coordinates, CallbackInfoReturnable<Boolean> cir) {
        if (blockEntity.getUpgrades().stream().anyMatch(upgrade -> upgrade.is(ModItems.DIMENSION_CARD.get()))) {
            cir.setReturnValue(true);
        }

    }

}
