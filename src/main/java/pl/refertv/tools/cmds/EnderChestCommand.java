package pl.refertv.tools.cmds;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import pl.refertv.tools.MessageManager;

public class EnderChestCommand extends CommandBase {

    @Override
    protected boolean onCommand(Player p, Command cmd, String label, String[] args) {
        if (p.hasPermission("gamesmc.enderchest")) {
            if (args.length == 0) {
                p.openInventory(p.getEnderChest());
                p.playSound(p.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 2F, 1F);
            }
            if (args.length == 1) {
                if (p.hasPermission("gamesmc.enderchest.others")) {
                    Player gracz = Bukkit.getPlayer(args[0]);
                    if (gracz == null) {
                        MessageManager.sendMessage(p, "player_offline");
                        return false;
                    }
                    gracz.openInventory(gracz.getEnderChest());
                    gracz.playSound(gracz.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 2F, 1F);
                } else {
                    MessageManager.sendMessage(p, "error_no_permission"); }
            }
            if (args.length > 1) {
                MessageManager.sendMessage(p, "too_many_arguments");
            }
            } else {
            MessageManager.sendMessage(p, "error_no_permission");
        }
        return false;
    }
}





