package krk.hacmat4tic.traits;

import defeatedcrow.hac.api.recipe.ICrusherRecipeRegister;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import defeatedcrow.hac.machine.MachineInit;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.modifiers.IToolMod;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.tools.TinkerModifiers;

import java.util.*;

public class TraitScreening extends AbstractTrait {
    public static final ItemStack screenTitan = new ItemStack(MachineInit.rotaryBlade, 1, 2);

    public TraitScreening() {
        super("krk.screening", 0x473334);
    }

    @Override
    public boolean canApplyTogether(IToolMod otherModifier) {
        return !(otherModifier.getIdentifier().equals(TinkerModifiers.modSilktouch.getIdentifier()) ||
                otherModifier.getIdentifier().equals(TinkerModifiers.modLuck.getIdentifier()) ||
                otherModifier.getIdentifier().equals(Traits.silktouch.getIdentifier()));
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        super.blockHarvestDrops(tool, event);
        if (!ToolHelper.isToolEffective2(tool, event.getState())) return;
        List<ItemStack> drop = event.getDrops();
        List<ItemStack> additional = new ArrayList<>();
        ICrusherRecipeRegister register = RecipeAPI.registerCrushers;
        for (ItemStack item : new ArrayList<>(drop)) {
            Optional.ofNullable(register.getRecipe(item, screenTitan)).ifPresent(recipe -> {
                List<ItemStack> newDrops = new ArrayList<>();
                Optional.ofNullable(recipe.getOutput()).ifPresent(i -> {
                    if (winChance(event.getWorld().rand, 0.25f, event.getFortuneLevel(), 1)) newDrops.add(i.copy());
                });
                Optional.ofNullable(recipe.getSecondary()).ifPresent(i -> {
                    if (winChance(event.getWorld().rand, 0.075f, event.getFortuneLevel(), 2)) newDrops.add(i.copy());
                });
                Optional.ofNullable(recipe.getTertialy()).ifPresent(i -> {
                    if (winChance(event.getWorld().rand, 0.0075f, event.getFortuneLevel(), 4)) newDrops.add(i.copy());
                });
                if (!newDrops.isEmpty()) {
                    drop.remove(item);
                    additional.addAll(newDrops);
                }
            });
        }
        drop.addAll(additional);
    }

    public boolean winChance(Random random, float chance, int fortune, int factor) {
        if (factor < 1) factor = 1;
        double f = chance * ((double) (1 + fortune) / factor);
        return random.nextInt(100) < (chance * 100);
    }
}
