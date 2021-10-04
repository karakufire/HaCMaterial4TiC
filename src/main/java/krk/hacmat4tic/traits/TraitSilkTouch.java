package krk.hacmat4tic.traits;

import net.minecraft.init.Enchantments;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.modifiers.IToolMod;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolBuilder;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class TraitSilkTouch extends AbstractTrait {

    public TraitSilkTouch() {
        super("krk.silktouch", 0x7D4546);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        super.applyEffect(rootCompound, modifierTag);
        ToolBuilder.addEnchantment(rootCompound, Enchantments.SILK_TOUCH);
    }

    @Override
    public boolean canApplyTogether(IToolMod otherModifier) {
        return !(otherModifier.getIdentifier().equals(TinkerModifiers.modSilktouch.getIdentifier()) ||
                otherModifier.getIdentifier().equals(TinkerModifiers.modLuck.getIdentifier()) ||
                otherModifier.getIdentifier().equals(Traits.screening.getIdentifier()));
    }
}
