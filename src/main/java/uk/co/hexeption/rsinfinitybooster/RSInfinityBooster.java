package uk.co.hexeption.rsinfinitybooster;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.hexeption.rsinfinitybooster.config.ServerConfig;
import uk.co.hexeption.rsinfinitybooster.setup.Registration;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("rsinfinitybooster")
public class RSInfinityBooster {

	// Directly reference a log4j logger.
	public static final Logger LOGGER = LogManager.getLogger();

	public static final String ID = "rsinfinitybooster";
	public static final ServerConfig SERVER_CONFIG = new ServerConfig();



	public RSInfinityBooster() {

		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG.getSpec());

		Registration.register();
	}
}
