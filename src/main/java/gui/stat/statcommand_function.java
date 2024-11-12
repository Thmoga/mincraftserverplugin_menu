package gui.stat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class statcommand_function{
    private stat stat;

    public statcommand_function(stat stat) { // 생성자를 통해 stat 객체 전달
        this.stat = stat;
    }

    public void Stat_add(int index, Player player){
        stat.addpoint(index);
        player.sendMessage(player.getName() + "님에게 스텟 '" + index +"' 만큼 지급했습니다.");
    }

    public void Stat_tpyeadd(String stattype, int index, Player playername) {
        if(stattype.equals("힘")) {
            stat.addpower(index);
            playername.sendMessage(playername.getName() + "님의" + stattype + " 스텟이 " + index +"만큼 증가하였습니다.");
        } else if (stattype.equals("체력")) {
            stat.addstrength(index);
            playername.sendMessage(playername.getName() + "님의" + stattype + " 스텟이 " + index +"만큼 증가하였습니다.");
        } else if (stattype.equals("민첩")) {
            stat.addquickness(index);
            playername.sendMessage(playername.getName() + "님의" + stattype + " 스텟이 " + index +"만큼 증가하였습니다.");
        } else if (stattype.equals("내구력")) {
            stat.adddurability(index);
            playername.sendMessage(playername.getName() + "님의" + stattype + " 스텟이 " + index +"만큼 증가하였습니다.");
        } else if (stattype.equals("정신력")) {
            stat.addmental(index);
            playername.sendMessage(playername.getName() + "님의" + stattype + " 스텟이 " + index +"만큼 증가하였습니다.");
        } else if (stattype.equals("감각")) {
            stat.addsense(index);
            playername.sendMessage(playername.getName() + "님의" + stattype + " 스텟이 " + index +"만큼 증가하였습니다.");
        } else if (stattype.equals("행운")) {
            stat.addluck(index);
            playername.sendMessage(playername.getName() + "님의" + stattype + " 스텟이 " + index +"만큼 증가하였습니다.");
        } else if (stattype.equals("기술")) {
            stat.addskill(index);
            playername.sendMessage(playername.getName() + "님의" + stattype + " 스텟이 " + index +"만큼 증가하였습니다.");
        } else {
            playername.sendMessage(ChatColor.RED + "타입을 올바르게 적어주세요.");
        }
    }

    public void Stat_Initialization(Player playername) {
        stat.setpower(0);
        stat.setstrength(0);
        stat.setquickness(0);
        stat.setdurability(0);
        stat.setmental(0);
        stat.setsense(0);
        stat.setluck(0);
        stat.setskill(0);
        stat.setpoint(0);
        playername.sendMessage(playername.getName() + "님의 스텟이 정상적으로 초기화 되었습니다.");
    }

    public void Stat_paper(int index, Player p) {
        ItemStack paper = new ItemStack(Material.PAPER);
        ItemMeta paper_meta = paper.getItemMeta();
        paper_meta.setDisplayName("보너스 스텟 포인트");
        List<String> lore = new ArrayList<>();
        lore.add("우클릭시 " + index + "만큼 보너스 스텟을 획득합니다.");
        paper_meta.setLore(lore); // lore 설정
        paper.setItemMeta(paper_meta);
        p.getInventory().addItem(paper);
        p.sendMessage("스텟을 " + index + "만큼 올려주는 아이템을 생성하였습니다.");
    }

    public void Stat_Check(Player playername, Player p) {
        Inventory targetstat = Bukkit.createInventory(null, 54, playername.getName() + "의 스텟창");
        p.openInventory(targetstat);
    }
}
