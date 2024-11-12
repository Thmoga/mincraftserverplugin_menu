package gui.stat;

import gui.mainclass;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class statcommand implements CommandExecutor {

    private mainclass menu;
    private stat stat;

    public statcommand(mainclass menu, stat stat) {
        this.menu = menu;
        this.stat = stat;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "이 명령어는 플레이어만 사용할 수 있습니다.");
            return true;
        }

        Player p = (Player) sender;

        // 메뉴창 만들기
        Inventory statmenu = Bukkit.createInventory(null, 54, p.getName() + "의 스텟창");

        ItemStack pane1 = new ItemStack(Material.GLASS_PANE);
        ItemMeta pane1_meta = pane1.getItemMeta();
        pane1_meta.setDisplayName("힘");
        List<String> lore1 = new ArrayList<>();
        lore1.add("힘 스텟 : " + stat.getpower());
        pane1_meta.setLore(lore1); // lore 설정
        pane1.setItemMeta(pane1_meta); // setItemMeta 호출
        statmenu.setItem(0, pane1);

        ItemStack pane2 = new ItemStack(Material.GLASS_PANE);
        ItemMeta pane2_meta = pane2.getItemMeta();
        pane2_meta.setDisplayName("체력");
        List<String> lore2 = new ArrayList<>();
        lore2.add("체력 스텟 : " + stat.getstrength());
        pane2_meta.setLore(lore2); // lore 설정
        pane2.setItemMeta(pane2_meta);
        statmenu.setItem(1, pane2);

        ItemStack pane3 = new ItemStack(Material.GLASS_PANE);
        ItemMeta pane3_meta = pane3.getItemMeta();
        pane3_meta.setDisplayName("민첩");
        List<String> lore3 = new ArrayList<>();
        lore3.add("민첩 스텟 : " + stat.getquickness());
        pane3_meta.setLore(lore3); // lore 설정
        pane3.setItemMeta(pane3_meta);
        statmenu.setItem(2, pane3);

        ItemStack pane4 = new ItemStack(Material.GLASS_PANE);
        ItemMeta pane4_meta = pane4.getItemMeta();
        pane4_meta.setDisplayName("내구력");
        List<String> lore4 = new ArrayList<>();
        lore4.add("내구력 스텟 : " + stat.getdurability());
        pane4_meta.setLore(lore4); // lore 설정
        pane4.setItemMeta(pane4_meta);
        statmenu.setItem(3, pane4);

        ItemStack pane5 = new ItemStack(Material.GLASS_PANE);
        ItemMeta pane5_meta = pane5.getItemMeta();
        pane5_meta.setDisplayName("정신력");
        List<String> lore5 = new ArrayList<>();
        lore5.add("정신력 스텟 : " + stat.getmental());
        pane5_meta.setLore(lore5); // lore 설정
        pane5.setItemMeta(pane5_meta);
        statmenu.setItem(4, pane5);

        ItemStack pane6 = new ItemStack(Material.GLASS_PANE);
        ItemMeta pane6_meta = pane6.getItemMeta();
        pane6_meta.setDisplayName("감각");
        List<String> lore6 = new ArrayList<>();
        lore6.add("감각 스텟 : " + stat.getsense());
        pane6_meta.setLore(lore6); // lore 설정
        pane6.setItemMeta(pane6_meta);
        statmenu.setItem(5, pane6);

        ItemStack pane7 = new ItemStack(Material.GLASS_PANE);
        ItemMeta pane7_meta = pane7.getItemMeta();
        pane7_meta.setDisplayName("행운");
        List<String> lore7 = new ArrayList<>();
        lore7.add("행운 스텟 : " + stat.getluck());
        pane7_meta.setLore(lore7); // lore 설정
        pane7.setItemMeta(pane7_meta);
        statmenu.setItem(6, pane7);

        ItemStack pane8 = new ItemStack(Material.GLASS_PANE);
        ItemMeta pane8_meta = pane8.getItemMeta();
        pane8_meta.setDisplayName("기술");
        List<String> lore8 = new ArrayList<>();
        lore8.add("기술 스텟 : " + stat.getskill());
        pane8_meta.setLore(lore8); // lore 설정
        pane8.setItemMeta(pane8_meta);
        statmenu.setItem(7, pane8);

        ItemStack pane9 = new ItemStack(Material.GLASS_PANE);
        ItemMeta pane9_meta = pane9.getItemMeta();
        pane9_meta.setDisplayName("포인트");
        List<String> lore9 = new ArrayList<>();
        lore9.add("남은 스텟 포인트 : " + stat.getpoint());
        pane9_meta.setLore(lore9); // lore 설정
        pane9.setItemMeta(pane9_meta);
        statmenu.setItem(8, pane9);

        if (args.length == 0) {
            p.openInventory(statmenu);
        } else {
            p.sendMessage(ChatColor.WHITE + "명령어의 올바른 사용법은 '/스텟' 입니다.");
        }
        return true;
    }
}