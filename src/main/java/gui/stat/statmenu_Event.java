package gui.stat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class statmenu_Event implements Listener {
    @EventHandler
    public void statmenu_click(InventoryClickEvent e){
        String statmenu_name = ChatColor.stripColor(e.getView().getTitle());
        Player p = (Player) e.getWhoClicked();

        if(statmenu_name.equals(p.getName() + "의 스텟창")){
            e.setCancelled(true);
        }
    }
}
