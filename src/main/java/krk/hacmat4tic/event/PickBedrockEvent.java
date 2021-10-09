package krk.hacmat4tic.event;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.tools.tools.Pickaxe;

import java.util.Optional;

@Mod.EventBusSubscriber
public class PickBedrockEvent {

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickBlock event) {
        FMLLog.log.info("[HACMAT4TIC] Test: Hey, I am rightclick event running test!");
        EntityPlayer player = event.getEntityPlayer();
        if (player == null) return;

        ItemStack stack = player.getHeldItemMainhand();

        if (!isTiCStoneMiner(stack)) return;

        FMLLog.log.info(stack.getItem());
        FMLLog.log.info(ToolHelper.getHarvestLevelStat(stack));

        if (ToolHelper.getHarvestLevelStat(stack) < 4) return;
        BlockPos pos = event.getPos();
        IBlockState bs = event.getWorld().getBlockState(pos);
        if (!Blocks.BEDROCK.equals(bs.getBlock())) return;
        if (pos.getY() > 0 && player.canPlayerEdit(pos, EnumFacing.UP, stack)) {
            ItemStack newStack = new ItemStack(bs.getBlock(), 1);
            EntityItem droppedItem = new EntityItem(event.getWorld(), pos.getX() + 0.5d, pos.getY() + 0.5d, pos.getZ() + 0.5d, newStack);
            if (!event.getWorld().isRemote) {
                event.getWorld().setBlockToAir(pos);
                event.getWorld().spawnEntity(droppedItem);
                if (!player.isCreative()) ToolHelper.damageTool(stack, 1, event.getEntityLiving());
                event.setUseBlock(Event.Result.ALLOW);
            }
            player.world.playSound(player, player.posX, player.posY, player.posZ,
                    SoundEvents.BLOCK_STONE_BREAK, SoundCategory.PLAYERS,
                    1.5f, 1.0f / (player.world.rand.nextFloat() * 0.4f + 1.2f) + 0.5f
            );
        }
    }

    private static boolean isTiCStoneMiner(ItemStack item) {
        Item itemDef = item.getItem();
        return slimeknights.tconstruct.tools.tools.Pickaxe.class.equals(itemDef.getClass()) ||
                slimeknights.tconstruct.tools.tools.Hammer.class.equals(itemDef.getClass());
    }
}
