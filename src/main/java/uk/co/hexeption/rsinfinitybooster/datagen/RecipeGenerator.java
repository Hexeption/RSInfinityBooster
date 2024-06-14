package uk.co.hexeption.rsinfinitybooster.datagen;

import com.refinedmods.refinedstorage.RSItems;
import com.refinedmods.refinedstorage.item.UpgradeItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;
import uk.co.hexeption.rsinfinitybooster.setup.ModItems;

import java.util.concurrent.CompletableFuture;

/**
 * RecipeGenerator
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 06:35 pm
 */
public class RecipeGenerator extends RecipeProvider {

	public RecipeGenerator(PackOutput pOutput) {

		super(pOutput);
	}

	@Override
	protected void buildRecipes(RecipeOutput pRecipeOutput) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INFINITY_CARD.get())
				.pattern("ERE").pattern("RSR").pattern("NNN")
				.define('E', Items.ENDER_EYE)
				.define('R', RSItems.UPGRADE_ITEMS.get(UpgradeItem.Type.RANGE).get())
				.define('S', Items.NETHER_STAR)
				.define('N', Items.NETHERITE_INGOT)
				.unlockedBy("has_item", has(Items.NETHERITE_INGOT))
				.save(pRecipeOutput, new ResourceLocation(RSInfinityBooster.MODID, "infinity_card"));
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIMENSION_CARD.get())
				.pattern("RNR").pattern("NEN").pattern("RNR")
				.define('R', ModItems.INFINITY_CARD.get())
				.define('E', Items.ENDER_EYE)
				.define('N', Items.NETHER_STAR)
				.unlockedBy("has_item", has(ModItems.INFINITY_CARD.get()))
				.save(pRecipeOutput, new ResourceLocation(RSInfinityBooster.MODID, "dimension_card"));
	}

}
