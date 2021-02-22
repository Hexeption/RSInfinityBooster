package uk.co.hexeption.rsinfinitybooster.datagen;

import java.util.function.Consumer;

import com.refinedmods.refinedstorage.RSItems;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;
import uk.co.hexeption.rsinfinitybooster.setup.ModItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;

/**
 * RecipeGenerator
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 06:35 pm
 */
public class RecipeGenerator extends RecipeProvider {

	public RecipeGenerator(DataGenerator generatorIn) {
		super(generatorIn);
	}


	@Override
	public String getName() {
		return "Hex - Recipes";
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(ModItems.INFINITY_CARD.get())
				.patternLine("ERE").patternLine("RSR").patternLine("NNN")
				.key('E', Items.ENDER_EYE)
				.key('R', RSItems.RANGE_UPGRADE)
				.key('S', Items.NETHER_STAR)
				.key('N', Items.DIAMOND)
				.addCriterion("has_item", hasItem(Items.DIAMOND))
				.build(consumer, new ResourceLocation(RSInfinityBooster.ID, "infinity_card"));
	}
}
