package krk.hacmat4tic.materials;

import defeatedcrow.hac.main.MainInit;
import krk.hacmat4tic.traits.Traits;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class HaCMaterial {

    public static final Material CHALCEDONY = new Material("chalcedony", 0x52FFEE);
    public static final Material NICKEL_SILVER = new Material("nickelsilver", 0xA9E1DC);
    public static final Material MAGNET = new Material("magnet", 0x656565);
    public static final Material STAINLESS_STEEL = new Material("stainless_steel", 0xDDE1EB);
    public static final Material TITANIUM_ALLOY = new Material("titanium_alloy", 0xE6D6B9);
    public static final Material TOOL_STEEL = new Material("tool_steel", 0xD9E6DD);
    public static final Material MANGALLOY = new Material("mangalloy", 0x7D4546);

    public static final Fluid MOLTEN_NICKEL_SILVER = new FluidMolten("nickelsilver", 0xA9E1DC);
    public static final Fluid MOLTEN_MAGNET = new FluidMolten("magnet", 0x656565);
    public static final Fluid MOLTEN_STAINLESS_STEEL = new FluidMolten("stainless_steel", 0xDDE1EB);
    public static final Fluid MOLTEN_TITANIUM_ALLOY = new FluidMolten("titanium_alloy", 0xE6D6B9);
    public static final Fluid MOLTEN_TOOL_STEEL = new FluidMolten("tool_steel", 0xD9E6DD);
    public static final Fluid MOLTEN_MANGALLOY = new FluidMolten("mangalloy", 0x7D4546);

    public static void registerMaterial() {
        TinkerRegistry.addMaterial(CHALCEDONY);
        TinkerRegistry.addMaterialStats(CHALCEDONY,
                new HeadMaterialStats(36, 10.0f, 10f, HarvestLevels.COBALT),
                new HandleMaterialStats(1.0f, 24),
                new ExtraMaterialStats(12));
        TinkerRegistry.addMaterialStats(NICKEL_SILVER,
                new HeadMaterialStats(1000, 1.2f, 8f, HarvestLevels.DIAMOND),
                new HandleMaterialStats(1.1f, 301),
                new ExtraMaterialStats(300),
                new BowMaterialStats(1.0f, 1.5f, 1.6f));
        TinkerRegistry.addMaterialStats(MAGNET,
                new HeadMaterialStats(450, 7.0f, 6f, HarvestLevels.DIAMOND),
                new HandleMaterialStats(0.9f, 75),
                new ExtraMaterialStats(12));
        TinkerRegistry.addMaterialStats(STAINLESS_STEEL,
                new HeadMaterialStats(1888, 5.5f, 11f, HarvestLevels.COBALT),
                new HandleMaterialStats(1.8f, 720),
                new ExtraMaterialStats(242),
                new BowMaterialStats(0.9f, 2.1f, 5.5f));
        TinkerRegistry.addMaterialStats(TITANIUM_ALLOY,
                new HeadMaterialStats(1980, 4.1f, 21f, 5),
                new HandleMaterialStats(2.8f, 500),
                new ExtraMaterialStats(311),
                new BowMaterialStats(0.6f, 2.5f, 5.5f));
        TinkerRegistry.addMaterialStats(TOOL_STEEL,
                new HeadMaterialStats(600, 9.5f, 20f, 5),
                new HandleMaterialStats(1.7f, 450),
                new ExtraMaterialStats(310),
                new BowMaterialStats(1.0f, 3.5f, 4.9f));
        TinkerRegistry.addMaterialStats(MANGALLOY,
                new HeadMaterialStats(600, 3.8f, 17.8f, 5),
                new HandleMaterialStats(1.6f, 400),
                new ExtraMaterialStats(221),
                new BowMaterialStats(0.3f, 1.1f, -0.8f));

//        try {
//            TinkerRegistry.integrate(CHALCEDONY, "gemChalcedony").preInit();
//        } catch (Exception e) {
//            FMLLog.log.error("[HaCMat4TiC] " + e.getMessage());
//        }
        try {
            TinkerRegistry.integrate(NICKEL_SILVER, MOLTEN_NICKEL_SILVER, "Nickelsilver").toolforge().preInit();
        } catch (Exception e) {
            FMLLog.log.error("[HaCMat4TiC] " + e.getMessage());
        }
        try {
            TinkerRegistry.integrate(MAGNET, MOLTEN_MAGNET, "Magnet").toolforge().preInit();
        } catch (Exception e) {
            FMLLog.log.error("[HaCMat4TiC] " + e.getMessage());
        }
        try {
            TinkerRegistry.integrate(STAINLESS_STEEL, MOLTEN_STAINLESS_STEEL, "StainlessSteel").toolforge().preInit();
        } catch (Exception e) {
            FMLLog.log.error("[HaCMat4TiC] " + e.getMessage());
        }
        try {
            TinkerRegistry.integrate(TITANIUM_ALLOY, MOLTEN_TITANIUM_ALLOY, "TitaniumAlloy").toolforge().preInit();
        } catch (Exception e) {
            FMLLog.log.error("[HaCMat4TiC] " + e.getMessage());
        }
        try {
            TinkerRegistry.integrate(TOOL_STEEL, MOLTEN_TOOL_STEEL, "ToolSteel").toolforge().preInit();
        } catch (Exception e) {
            FMLLog.log.error("[HaCMat4TiC] " + e.getMessage());
        }
        try {
            TinkerRegistry.integrate(MANGALLOY, MOLTEN_MANGALLOY, "Mangalloy").toolforge().preInit();
        } catch (Exception e) {
            FMLLog.log.error("[HaCMat4TiC] " + e.getMessage());
        }
    }

    public static void registerFluid() {
        FluidRegistry.registerFluid(MOLTEN_NICKEL_SILVER);
        FluidRegistry.registerFluid(MOLTEN_MAGNET);
        FluidRegistry.registerFluid(MOLTEN_STAINLESS_STEEL);
        FluidRegistry.registerFluid(MOLTEN_TITANIUM_ALLOY);
        FluidRegistry.registerFluid(MOLTEN_TOOL_STEEL);
        FluidRegistry.registerFluid(MOLTEN_MANGALLOY);
    }

    public static void initMaterial() {
        CHALCEDONY.setCraftable(true);
        CHALCEDONY.addItemIngot("gemChalcedony");
        CHALCEDONY.addItem("blockChalcedonyRed", 1, Material.VALUE_Ingot * 4);
        CHALCEDONY.addItem("blockChalcedonyBlue", 1, Material.VALUE_Ingot * 4);
        CHALCEDONY.addItem("blockChalcedonyWhite", 1, Material.VALUE_Ingot * 4);
        CHALCEDONY.addItem("blockChalcedony", 1, Material.VALUE_Ingot * 4);
        CHALCEDONY.addItem(new ItemStack(MainInit.gemBlock, 1, 8), 1, Material.VALUE_Ingot * 8);
        CHALCEDONY.setRepresentativeItem(new ItemStack(MainInit.gems_blue, 1, 0));
        CHALCEDONY.addTrait(TinkerTraits.breakable);

        NICKEL_SILVER.setCastable(true);
        NICKEL_SILVER.setCraftable(false);
        NICKEL_SILVER.addItem("ingotNickelsilver", 1, Material.VALUE_Ingot);
        NICKEL_SILVER.addItem("blockNickelsilver", 1, Material.VALUE_Block);
        NICKEL_SILVER.addItem("nuggetNickelsilver", 1, Material.VALUE_Nugget);
        NICKEL_SILVER.addItem("gearNickelsilver", 1, Material.VALUE_Ingot * 4);
        NICKEL_SILVER.setRepresentativeItem("ingotNickelsilver");
        NICKEL_SILVER.addTrait(Traits.magical1, MaterialTypes.HEAD);
        NICKEL_SILVER.addTrait(TinkerTraits.established, MaterialTypes.HEAD);
        NICKEL_SILVER.addTrait(Traits.magical1);

        MAGNET.setCastable(true);
        MAGNET.setCraftable(false);
        MAGNET.addItem("ingotMagnet", 1, Material.VALUE_Ingot);
        MAGNET.addItem("blockMagnet", 1, Material.VALUE_Block);
        MAGNET.addItem("nuggetMagnet", 1, Material.VALUE_Nugget);
        MAGNET.addItem("gearMagnet", 1, Material.VALUE_Ingot * 4);
        MAGNET.setRepresentativeItem("ingotMagnet");
        MAGNET.addTrait(Traits.magnetic3, MaterialTypes.HEAD);
        MAGNET.addTrait(TinkerTraits.magnetic2);

        STAINLESS_STEEL.setCastable(true);
        STAINLESS_STEEL.setCraftable(false);
        STAINLESS_STEEL.addItem("ingotStainlessSteel", 1, Material.VALUE_Ingot);
        STAINLESS_STEEL.addItem("blockStainlessSteel", 1, Material.VALUE_Block);
        STAINLESS_STEEL.addItem("nuggetStainlessSteel", 1, Material.VALUE_Nugget);
        STAINLESS_STEEL.addItem("gearStainlessSteel", 1, Material.VALUE_Ingot * 4);
        STAINLESS_STEEL.setRepresentativeItem("ingotStainlessSteel");
        STAINLESS_STEEL.addTrait(TinkerTraits.heavy);
        STAINLESS_STEEL.addTrait(TinkerTraits.dense);
        STAINLESS_STEEL.addTrait(TinkerTraits.sharp, MaterialTypes.HEAD);
        STAINLESS_STEEL.addTrait(TinkerTraits.heavy, MaterialTypes.HEAD);

        TITANIUM_ALLOY.setCastable(true);
        TITANIUM_ALLOY.setCraftable(false);
        TITANIUM_ALLOY.addItem("ingotTitaniumAlloy", 1, Material.VALUE_Ingot);
        TITANIUM_ALLOY.addItem("blockTitaniumAlloy", 1, Material.VALUE_Block);
        TITANIUM_ALLOY.addTrait(TinkerTraits.lightweight);
        TITANIUM_ALLOY.addTrait(Traits.screening, MaterialTypes.HEAD);
        TITANIUM_ALLOY.addTrait(TinkerTraits.lightweight, MaterialTypes.HEAD);

        TOOL_STEEL.setCastable(true);
        TOOL_STEEL.setCraftable(false);
        TOOL_STEEL.addItem("ingotToolSteel", 1, Material.VALUE_Ingot);
        TOOL_STEEL.addItem("blockTitaniumAlloy", 1, Material.VALUE_Block);
        TOOL_STEEL.setRepresentativeItem("ingotToolSteel");
        TOOL_STEEL.addTrait(TinkerTraits.dense);
        TOOL_STEEL.addTrait(TinkerTraits.momentum, MaterialTypes.HANDLE);
        TOOL_STEEL.addTrait(TinkerTraits.dense, MaterialTypes.HANDLE);

        MANGALLOY.setCastable(true);
        MANGALLOY.setCraftable(false);
        MANGALLOY.addItem("ingotMangalloy", 1, Material.VALUE_Ingot);
        MANGALLOY.addItem("blockMangalloy", 1, Material.VALUE_Block);
        MANGALLOY.addTrait(TinkerTraits.dense);
        MANGALLOY.addTrait(Traits.silktouch, MaterialTypes.HEAD);
        MANGALLOY.addTrait(TinkerTraits.dense, MaterialTypes.HEAD);
    }

    public static void integrateFluid() {

        integrateSmeltery("nickelsilver", MOLTEN_NICKEL_SILVER);
        integrateSmeltery("magnet", MOLTEN_MAGNET);
        integrateSmeltery("stainless_steel", MOLTEN_STAINLESS_STEEL);
        integrateSmeltery("titanium_alloy", MOLTEN_TITANIUM_ALLOY);
        integrateSmeltery("tool_steel", MOLTEN_TOOL_STEEL);
        integrateSmeltery("mangalloy", MOLTEN_MANGALLOY);
    }

    public static void integrateSmeltery(String ore, Fluid fluid) {
        integrateSmeltery(ore, fluid, true);
    }

    public static void integrateSmeltery(String ore, Fluid fluid, boolean canUseForge) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("fluid", fluid.getName());
        tag.setString("ore", ore);
        tag.setBoolean("toolforge", canUseForge);
        FMLInterModComms.sendMessage("tconstruct", "integrateSmeletery", tag);
    }
}
