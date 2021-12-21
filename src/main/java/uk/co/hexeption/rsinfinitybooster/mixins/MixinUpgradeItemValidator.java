package uk.co.hexeption.rsinfinitybooster.mixins;

import com.refinedmods.refinedstorage.inventory.item.validator.UpgradeItemValidator;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.hexeption.rsinfinitybooster.item.DimensionCard;

/**
 * MixinUpgradeItemValidator
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 01/03/2021 - 04:35 pm
 */
@Mixin(value = UpgradeItemValidator.class, remap = false)
public class MixinUpgradeItemValidator {

	@Inject(method = "test", at = @At("HEAD"), cancellable = true)
	private void test(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {

		if (stack.getItem() instanceof DimensionCard) {
			cir.setReturnValue(true);
		}
	}
}
