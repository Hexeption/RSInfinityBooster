package uk.co.hexeption.rsinfinitybooster.mixins;

import java.util.List;
import java.util.Set;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;

public class ConditionalMixinPlugin implements IMixinConfigPlugin {

    @Override
    public void onLoad(String s) {

    }

    @Override
    public String getRefMapperConfig() {

        return "";
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {

        if("uk.co.hexeption.rsinfinitybooster.mixins.MixinAdvancedWirelessTransmitterNode".equals(mixinClassName)) {
            return RSInfinityBooster.isModLoaded("rebornstorage");
        }

        if("uk.co.hexeption.rsinfinitybooster.mixins.MixinNetworkItemManagerReborn".equals(mixinClassName)) {
            return RSInfinityBooster.isModLoaded("rebornstorage");
        }

        if("uk.co.hexeption.rsinfinitybooster.mixins.MixinNetworkItemManager".equals(mixinClassName)) {
            return !RSInfinityBooster.isModLoaded("rebornstorage");
        }
        return true;
    }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {

    }

    @Override
    public List<String> getMixins() {

        return List.of();
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

}
