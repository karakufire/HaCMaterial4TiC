package krk.hacmat4tic;

import krk.hacmat4tic.materials.HaCMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Main.MOD_ID, name = Main.MOD_NAME, version = Main.MOD_VERSION, dependencies = Main.DEPENDENCIES)
@Mod.EventBusSubscriber
public class Main {
    public static final String MOD_ID = "hacmat4tic";
    public static final String MOD_NAME = "HaCMaterial4TiC";
    public static final String MOD_VERSION = "1.11";
    public static final String DEPENDENCIES
            = "required-after:tconstruct;"
            + "required-after:dcs_climate;";

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        HaCMaterial.registerFluid();
        HaCMaterial.registerMaterial();
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        HaCMaterial.initMaterial();
        HaCMaterial.integrateFluid();
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
    }

    @SubscribeEvent
    public static void registerFluids(FluidRegistry.FluidRegisterEvent event) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {

    }
}
