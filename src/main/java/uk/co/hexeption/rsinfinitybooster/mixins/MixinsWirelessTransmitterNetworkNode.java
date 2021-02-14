package uk.co.hexeption.rsinfinitybooster.mixins;

import com.refinedmods.refinedstorage.RS;
import com.refinedmods.refinedstorage.apiimpl.network.node.WirelessTransmitterNetworkNode;
import com.refinedmods.refinedstorage.inventory.item.UpgradeItemHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;
import uk.co.hexeption.rsinfinitybooster.item.InfinityCard;

import net.minecraft.item.ItemStack;

/**
 * MixinsWirelessTransmitterNetworkNode
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 05:07 pm
 */
@Mixin(value = WirelessTransmitterNetworkNode.class, remap = false)
public class MixinsWirelessTransmitterNetworkNode {

	@Shadow
	@Final
	private UpgradeItemHandler upgrades;

	@Inject(method = "getRange", at = @At("HEAD"), cancellable = true)
	private void getRange(CallbackInfoReturnable<Integer> cir) {

		if (isInfinityCard()) {
			cir.setReturnValue(Integer.MAX_VALUE);
		}
	}

	@Inject(method = "getEnergyUsage", at = @At("HEAD"), cancellable = true)
	private void getEnergyUsage(CallbackInfoReturnable<Integer> cir) {

		if (isInfinityCard()) {
			cir.setReturnValue(RS.SERVER_CONFIG.getWirelessTransmitter().getUsage() + RSInfinityBooster.SERVER_CONFIG.getInfinityCard().getEnergyUsage());
		}
	}

	private boolean isInfinityCard() {
		for (int i = 0; i < this.upgrades.getSlots(); ++i) {
			ItemStack slot = this.upgrades.getStackInSlot(i);
			if (slot.getItem() instanceof InfinityCard) {
				return true;
			}
		}
		return false;
	}
}

