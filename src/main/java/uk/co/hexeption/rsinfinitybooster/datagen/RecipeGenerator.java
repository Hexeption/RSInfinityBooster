package uk.co.hexeption.rsinfinitybooster.datagen;

import java.util.function.Consumer;

import com.refinedmods.refinedstorage.RSItems;
import com.refinedmods.refinedstorage.item.UpgradeItem;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;
import uk.co.hexeption.rsinfinitybooster.setup.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.resources.ResourceLocation;

/**
 * RecipeGenerator
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 06:35 pm
 */
public class RecipeGenerator extends RecipeProvider {

	public RecipeGenerator(PackOutput packOutput) {
        super(packOutput);
    }

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> p_176532_) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INFINITY_CARD.get())
				.pattern("ERE").pattern("RSR").pattern("NNN")
				.define('E', Items.ENDER_EYE)
				.define('R', RSItems.UPGRADE_ITEMS.get(UpgradeItem.Type.RANGE).get())
				.define('S', Items.NETHER_STAR)
				.define('N', Items.NETHERITE_INGOT)
				.unlockedBy("has_item", has(Items.NETHERITE_INGOT))
				.save(p_176532_, new ResourceLocation(RSInfinityBooster.ID, "infinity_card"));
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIMENSION_CARD.get())
				.pattern("RNR").pattern("NEN").pattern("RNR")
				.define('R', ModItems.INFINITY_CARD.get())
				.define('E', Items.ENDER_EYE)
				.define('N', Items.NETHER_STAR)
				.unlockedBy("has_item", has(ModItems.INFINITY_CARD.get()))
				.save(p_176532_, new ResourceLocation(RSInfinityBooster.ID, "dimension_card"));
	}
}
