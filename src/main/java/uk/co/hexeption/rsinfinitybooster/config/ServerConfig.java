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

	public ServerConfig() {
		infinityCard = new InfinityCard();

		spec = builder.build();
	}

	public InfinityCard getInfinityCard() {
		return infinityCard;
	}

	public ForgeConfigSpec getSpec() {
		return spec;
	}

	public class InfinityCard {
		private final ForgeConfigSpec.IntValue energyUsage;

		public InfinityCard() {
			builder.push("infinityCard");

			energyUsage = builder.comment("The energy need to run the InfinityCard").defineInRange("energyUsage", 16000, 0, Integer.MAX_VALUE);

			builder.pop();
		}

		public int getEnergyUsage() {
			return energyUsage.get();
		}
	}
}
