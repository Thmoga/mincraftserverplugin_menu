package gui.stat;

import gui.mainclass;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class statmanager implements CommandExecutor {
    private mainclass stat_statmanager;
    private statcommand_function statcommand_function;
    private stat stat; // stat 객체 선언

    public statmanager(stat stat){
        this.stat = stat;
        this.statcommand_function = new statcommand_function(this.stat);
    }
    public statmanager(mainclass stat_statmanager) {
        this.stat_statmanager = stat_statmanager;
        this.stat = new stat(0); // 기본 값으로 stat 객체 생성
        this.statcommand_function = new statcommand_function(this.stat); // 생성된 stat 객체 전달
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "이 명령어는 플레이어만 사용할 수 있습니다.");
            return true;
        }

        Player p = (Player) sender;

        if (!p.hasPermission("statmanager.permission")) {
            p.sendMessage(ChatColor.RED + "[ 명령어 사용 권한 없음 ]");
            return true;
        }

        if (args.length == 0) {
            p.sendMessage(ChatColor.WHITE + "[ 스텟 관리자 명령어 ]");
            p.sendMessage(ChatColor.WHITE + "1. /스텟관리자");
            p.sendMessage(ChatColor.WHITE + ": 스텟 관리자에 관련된 명령어들을 확인합니다.");
            p.sendMessage(ChatColor.WHITE + "2. /스텟관리자 추가 [숫자] [플레이어]");
            p.sendMessage(ChatColor.WHITE + ": [플레이어]에게 [숫자]만큼 보너스 스텟을 지급합니다.");
            p.sendMessage(ChatColor.WHITE + "3. /스텟관리자 추가스텟 [스텟종류] [숫자] [플레이어]");
            p.sendMessage(ChatColor.WHITE + ": [플레이어]에게 [숫자]만큼 [스텟종류]의 스텟을 추가합니다.");
            p.sendMessage(ChatColor.WHITE + "스텟 종류 : 힘, 체력, 민첩, 내구력, 정신력, 감각, 행운, 기술");
            p.sendMessage(ChatColor.WHITE + "4. /스텟관리자 초기화 [플레이어]");
            p.sendMessage(ChatColor.WHITE + ": [플레이어]의 모든 스텟 정보를 초기화 합니다.");
            p.sendMessage(ChatColor.WHITE + "5. /스텟관리자 종이 [숫자]");
            p.sendMessage(ChatColor.WHITE + ": 우클릭시 [숫자]만큼 보너스 스텟을 얻을 수 있는 아이템을 지급합니다.");
            p.sendMessage(ChatColor.WHITE + "6. /스텟관리자 확인 [플레이어]");
            p.sendMessage(ChatColor.WHITE + ": [플레이어]의 현재 스텟 상태를 확인하는 GUI를 열람합니다.");
        } else {
            switch (args[0]) {
                case "추가":
                    if (args.length < 3) {
                        p.sendMessage(ChatColor.RED + "명령어의 올바른 사용법은 '/스텟관리자 추가 [숫자] [플레이어]' 입니다.");
                        return true;
                    }
                    if (!args[1].matches("\\d+")) {
                        p.sendMessage(ChatColor.RED + "[숫자] 부분에는 숫자를 입력해주세요.");
                        return true;
                    }
                    int index1 = Integer.parseInt(args[1]);
                    Player playername1 = p.getServer().getPlayer(args[2]);

                    if (playername1 == null) {
                        p.sendMessage(ChatColor.RED + "플레이어 '" + args[2] + "'을(를) 찾을 수 없습니다.");
                        return true;
                    }
                    statcommand_function.Stat_add(index1, playername1);
                    break;

                case "추가스텟":
                    if (args.length < 4) {
                        p.sendMessage(ChatColor.RED + "명령어의 올바른 사용법은 '/스텟관리자 추가스텟 [스텟종류] [숫자] [플레이어]' 입니다.");
                        return true;
                    }
                    if (!args[2].matches("\\d+")) {
                        p.sendMessage(ChatColor.RED + "[숫자] 부분에는 숫자를 입력해주세요.");
                        return true;
                    }
                    String stattype = args[1];
                    int index2 = Integer.parseInt(args[2]);
                    Player playername2 = p.getServer().getPlayer(args[3]);

                    if (playername2 == null) {
                        p.sendMessage(ChatColor.RED + "플레이어 '" + args[3] + "'을(를) 찾을 수 없습니다.");
                        return true;
                    }
                    statcommand_function.Stat_tpyeadd(stattype, index2, playername2);
                    break;

                case "초기화":
                    if (args.length < 2) {
                        p.sendMessage(ChatColor.RED + "명령어의 올바른 사용법은 '/스텟관리자 초기화 [플레이어]' 입니다.");
                        return true;
                    }
                    Player playername3 = p.getServer().getPlayer(args[1]);
                    if (playername3 == null) {
                        p.sendMessage(ChatColor.RED + "플레이어 '" + args[1] + "'을(를) 찾을 수 없습니다.");
                        return true;
                    }
                    statcommand_function.Stat_Initialization(playername3);
                    break;

                case "종이":
                    if (args.length < 2 || !args[1].matches("\\d+")) {
                        p.sendMessage(ChatColor.RED + "[숫자] 부분에는 숫자를 입력해주세요.");
                        return true;
                    }
                    int index4 = Integer.parseInt(args[1]);
                    statcommand_function.Stat_paper(index4, p);
                    break;

                case "확인":
                    if (args.length < 2) {
                        p.sendMessage(ChatColor.RED + "명령어의 올바른 사용법은 '/스텟관리자 확인 [플레이어]' 입니다.");
                        return true;
                    }
                    Player playername5 = p.getServer().getPlayer(args[1]);
                    if (playername5 == null) {
                        p.sendMessage(ChatColor.RED + "플레이어 '" + args[1] + "'을(를) 찾을 수 없습니다.");
                        return true;
                    }
                    statcommand_function.Stat_Check(playername5, p);
                    break;

                default:
                    p.sendMessage(ChatColor.RED + "알 수 없는 명령어입니다.");
                    break;
            }
        }
        return true;
    }
}
