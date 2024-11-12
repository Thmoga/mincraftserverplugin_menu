package gui.mainmenu;

import gui.mainclass;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class menuGUI_Command implements CommandExecutor {
    private mainclass menu;
    public menuGUI_Command(mainclass menu){
        this.menu = menu;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        //메뉴창 만들기
        Inventory menu = Bukkit.createInventory(null, 54, ChatColor.WHITE + "\uEBBB\uEBBB\uEBBB\uEBBB\uEBBB\uEBBB\uEBBB\uEAAA");



        if(args.length == 0){
            p.openInventory(menu);
        }
        else{
            p.sendMessage(ChatColor.WHITE + "명령어의 올바른 사용법은 '/메뉴' 입니다.");
        }
        return true;
    }
}
