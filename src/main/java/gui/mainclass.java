package gui;

import gui.mainmenu.*;
import gui.stat.*;
import gui.mainmenu.menuGUI_Command;
import gui.mainmenu.menuGUI_Event;
import org.bukkit.plugin.java.JavaPlugin;

public final class mainclass extends JavaPlugin {

    private stat playerStat; // stat 객체 선언

    @Override
    public void onEnable() {
        // stat 객체 생성 (예: 기본값 0)
        playerStat = new stat(0);

        // 기존 명령어와 이벤트 등록
        this.getCommand("메뉴").setExecutor(new menuGUI_Command(this));
        getServer().getPluginManager().registerEvents(new menuGUI_Event(), this);

        // statcommand에 stat 객체 전달
        this.getCommand("스텟").setExecutor(new statcommand(this, playerStat));
        getServer().getPluginManager().registerEvents(new statmenu_Event(), this);
        this.getCommand("스텟관리자").setExecutor(new statmanager(playerStat));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
