package dev.zetax.nexus.EventListeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

import static dev.zetax.nexus.EventListeners.GUIOpen.running;
import static dev.zetax.nexus.EventListeners.GUIOpen.time;

public class GUIClose implements Listener {

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {

        if(time.containsKey(event.getPlayer().getUniqueId())) {
            if(System.currentTimeMillis() - time.get(event.getPlayer().getUniqueId()) > 10) {
                running.remove(event.getPlayer().getUniqueId());
            }
        }

    }

}
