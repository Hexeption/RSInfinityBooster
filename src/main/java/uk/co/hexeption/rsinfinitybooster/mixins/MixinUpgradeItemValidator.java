package uk.co.hexeption.rsinfinitybooster.mixins;

import com.refinedmods.refinedstorage.inventory.item.validator.UpgradeItemValidator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.hexeption.rsinfinitybooster.item.InfinityCard;

import net.minecraft.item.ItemStack;

/**
 * MixinUpgradeItemValidator
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 22/02/2021 - 08:02 pm
 */
@Mixin(value = UpgradeItemValidator.class, remap = false)
public class MixinUpgradeItemValidator {

	@Inject(method = "test", at = @At("HEAD"), cancellable = true)
	private void test(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {

		cir.setReturnValue(stack.getItem() instanceof InfinityCard);
	}
}
