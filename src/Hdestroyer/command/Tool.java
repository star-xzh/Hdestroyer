package com.Hdestroyer.plugin.command;

import com.Hdestroyer.plugin.HdestroyerMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tool implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("Hdestroyer.tool")) {
            sender.sendMessage("没有足够的权限");
            return true;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage("此命令对象必须为玩家");
            return true;
        }
        Player p = (Player) sender;
        if (args.length == 0) {
            p.sendMessage("§b[Hdestroyer]§4输入错误,正确用法为:§a/Hdestroyer help");
        } else if (args[0].equalsIgnoreCase("tool")) {
            p.getInventory().addItem(HdestroyerMain.Plugin.wood);
            p.sendMessage("§b[Hdestroyer]§a给予工具");
        }else if (args[0].equalsIgnoreCase("help")){
            p.sendMessage("§a===========插件命令=================");
            p.sendMessage("§a/Hdestroyer tool §6给自己一个圈地工具");
            p.sendMessage("§a/Hdestroyer info §6插件信息");
        }else if(args[0].equalsIgnoreCase("info")){
            p.sendMessage("§a[Hdestroyer]联系作者以反馈bug:1910244723");
            p.sendMessage("§a[Hdestroyer]此插件由冷馨老板赞助 §4老板大气");
        }else if (!(args.length == 0)){
            p.sendMessage("§b[Hdestroyer]§4输入错误,正确用法为:§a/Hdestroyer help");
        }
        return true;
    }
}