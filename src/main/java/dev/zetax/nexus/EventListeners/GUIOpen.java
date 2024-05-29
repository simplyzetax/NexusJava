package dev.zetax.nexus.EventListeners;

import dev.zetax.nexus.FolderCloud.AddonsOverviewGUI;
import dev.zetax.nexus.Folders.Folder;
import me.TechsCode.UltraCustomizer.UltraCustomizer;
import me.TechsCode.UltraCustomizer.base.gui.Button;
import me.TechsCode.UltraCustomizer.gui.Overview;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryView;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GUIOpen implements Listener {

    public static final HashMap<UUID, Long> time = new HashMap<>();
    public static Map<UUID, String> running = new HashMap<>();

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        InventoryView inventoryView = event.getView();
        //Nexus.INSTANCE.getLogger().info("Inventory with title " + inventoryView.getTitle() + " has been opened!");
        if (inventoryView.getTitle().equals("Overview > Addons") && event.getInventory().getSize() == (9 * 4) && !running.containsKey(event.getPlayer().getUniqueId())) {

            running.put(event.getPlayer().getUniqueId(), "AddonsOverviewGUI");
            time.put(event.getPlayer().getUniqueId(), System.currentTimeMillis());

            Player player = (Player) event.getPlayer();
            AddonsOverviewGUI gui = new AddonsOverviewGUI(player, UltraCustomizer.getInstance()) {
                @Override
                public void onBack() {
                    new Overview((Player) event.getPlayer(), UltraCustomizer.getInstance());
                    running.remove(event.getPlayer().getUniqueId());
                }

                @Override
                public void construct(Button button, Folder folder) {

                }
            };

        }

    }
}