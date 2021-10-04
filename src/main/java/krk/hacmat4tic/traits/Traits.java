package krk.hacmat4tic.traits;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.tools.traits.TraitMagnetic;

import java.util.Objects;

public class Traits {
    public static final AbstractTrait magnetic3;
    public static final AbstractTrait disassemble = new TraitScreening();
    public static final AbstractTrait silktouch = new TraitSilkTouch();
    public static final AbstractTrait magical1 = new TraitMagical(1);
    public static final AbstractTrait magical2 = new TraitMagical(2);
    public static final AbstractTrait magical3 = new TraitMagical(3);

    static {
        ITrait t_mag3 = TinkerRegistry.getTrait("magnetic3");
        if (Objects.nonNull(t_mag3) && t_mag3 instanceof AbstractTrait) {
            magnetic3 = (AbstractTrait) t_mag3;
        } else {
            magnetic3 = new TraitMagnetic(3);
        }
    }
}
