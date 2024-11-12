package gui.mainmenu;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class menuGUI_Event implements Listener {

    @EventHandler
    public void menu_click(InventoryClickEvent e){
        String menu_name = e.getView().getTitle();

        if(menu_name.equals("ChatColor.WHITE + \uEBBB\uEAAA")){
            e.setCancelled(true);
        }
    }
}
