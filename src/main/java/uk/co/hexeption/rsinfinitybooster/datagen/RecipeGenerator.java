package uk.co.hexeption.rsinfinitybooster.datagen;

import java.util.function.Consumer;

import com.refinedmods.refinedstorage.RSItems;
import com.refinedmods.refinedstorage.item.UpgradeItem;
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
				.key('R', RSItems.UPGRADE_ITEMS.get(UpgradeItem.Type.RANGE).get())
				.key('S', Items.NETHER_STAR)
				.key('N', Items.NETHERITE_INGOT)
				.addCriterion("has_item", hasItem(Items.NETHERITE_INGOT))
				.build(consumer, new ResourceLocation(RSInfinityBooster.ID, "infinity_card"));
		ShapedRecipeBuilder.shapedRecipe(ModItems.DIMENSION_CARD.get())
				.patternLine("RNR").patternLine("NEN").patternLine("RNR")
				.key('R', ModItems.INFINITY_CARD.get())
				.key('E', Items.ENDER_EYE)
				.key('N', Items.NETHER_STAR)
				.addCriterion("has_item", hasItem(ModItems.INFINITY_CARD.get()))
				.build(consumer, new ResourceLocation(RSInfinityBooster.ID, "dimension_card"));
	}
}
