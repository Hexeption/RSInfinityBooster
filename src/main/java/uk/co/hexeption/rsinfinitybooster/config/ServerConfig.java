package uk.co.hexeption.rsinfinitybooster.config;

import net.minecraftforge.common.ForgeConfigSpec;

/**
 * ServerConfig
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 05:53 pm
 */
public class ServerConfig {

	private ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
	private ForgeConfigSpec spec;
	private InfinityCard infinityCard;
	private DimensionCard dimensionCard;

	public ServerConfig() {
		infinityCard = new InfinityCard();
		dimensionCard = new DimensionCard();

		spec = builder.build();
	}

	public InfinityCard getInfinityCard() {
		return infinityCard;
	}

	public DimensionCard getDimensionCard() {
		return dimensionCard;
	}

	public ForgeConfigSpec getSpec() {
		return spec;
	}

	public class InfinityCard {
		private final ForgeConfigSpec.IntValue energyUsage;

		public InfinityCard() {
			builder.push("infinityCard");

			energyUsage = builder.comment("The energy need to run the Infinity Card").defineInRange("energyUsage", 8000, 0, Integer.MAX_VALUE);

			builder.pop();
		}

		public int getEnergyUsage() {
			return energyUsage.get();
		}
	}

	public class DimensionCard {
		private final ForgeConfigSpec.IntValue energyUsage;

		public DimensionCard() {
			builder.push("dimensionCard");

			energyUsage = builder.comment("The energy need to run the Dimension Card").defineInRange("energyUsage", 16000, 0, Integer.MAX_VALUE);

			builder.pop();
		}

		public int getEnergyUsage() {
			return energyUsage.get();
		}
	}
}
