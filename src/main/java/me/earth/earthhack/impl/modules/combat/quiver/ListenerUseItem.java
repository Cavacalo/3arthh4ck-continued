package me.earth.earthhack.impl.modules.combat.quiver;

import me.earth.earthhack.impl.event.events.misc.RightClickItemEvent;
import me.earth.earthhack.impl.event.listeners.ModuleListener;
import net.minecraft.item.ItemBow;

final class ListenerUseItem extends ModuleListener<Quiver, RightClickItemEvent>
{
    public ListenerUseItem(Quiver module)
    {
        super(module, RightClickItemEvent.class);
    }

    @Override
    public void invoke(RightClickItemEvent event)
    {
        if (mc.player.getHeldItem(event.getHand()).getItem() instanceof ItemBow
            && module.cancelTime.getValue() != 0
            && !module.timer.passed(module.cancelTime.getValue())
            && !(module.preCycle.getValue()
                && !module.fastCancel.getValue()
                && module.fast))
        {
            event.setCancelled(true);
        }
    }

}
