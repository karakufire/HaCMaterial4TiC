package krk.hacmat4tic.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;

public class TraitMagical extends AbstractTraitLeveled {
    private final int level;

    public TraitMagical(int level) {
        super("krk.magical", 0x58505E, 3, level);
        this.level = level;
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        super.afterHit(tool, player, target, damageDealt, wasCritical, wasHit);
        DamageSource source = new DamageSource("magic").setDamageBypassesArmor().setMagicDamage();
        target.attackEntityFrom(source, damageDealt * level / 10);
    }
}
