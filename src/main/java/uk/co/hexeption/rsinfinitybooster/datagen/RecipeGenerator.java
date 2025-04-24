package uk.co.hexeption.rsinfinitybooster.datagen;

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

	public RecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {

		super(output, registries);
	}

	@Override
	protected void buildRecipes(RecipeOutput pRecipeOutput) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INFINITY_CARD.get())
				.pattern("ERE").pattern("RSR").pattern("NNN")
				.define('E', Items.ENDER_EYE)
				.define('R', com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getRangeUpgrade())
				.define('S', Items.NETHER_STAR)
				.define('N', Items.NETHERITE_INGOT)
				.unlockedBy("has_item", has(Items.NETHERITE_INGOT))
				.save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(RSInfinityBooster.MODID, "infinity_card"));
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIMENSION_CARD.get())
				.pattern("RNR").pattern("NEN").pattern("RNR")
				.define('R', ModItems.INFINITY_CARD.get())
				.define('E', Items.ENDER_EYE)
				.define('N', Items.NETHER_STAR)
				.unlockedBy("has_item", has(ModItems.INFINITY_CARD.get()))
				.save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(RSInfinityBooster.MODID, "dimension_card"));
	}

}
