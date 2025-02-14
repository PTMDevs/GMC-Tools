package pl.refertv.tools.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import pl.refertv.tools.MessageManager;

public class GetPosCommand extends CommandBase {

    @Override
    protected boolean onCommand(Player p, Command cmd, String label, String[] args) {
        if (p.hasPermission("gamesmc.getpos")) {
            if (args.length == 0) {
                MessageManager.sendMessage(p,"location", p.getName());
                p.sendMessage("\n§7X: §b" + p.getLocation().getX() + "\n§7Y: §b" + p.getLocation().getY() + "\n§7Z: §b" + p.getLocation().getZ());
            }
            if (p.hasPermission("gamesmc.getpos.others")) {
                if (args.length == 1) {
                    Player gracz = Bukkit.getPlayer(args[0]);
                    if (gracz == null) {
                        MessageManager.sendMessage(p, "player_offline");
                        return false;
                    }
                    MessageManager.sendMessage(p, "location", gracz.getName());
                    p.sendMessage("\n§7X: §b" + gracz.getLocation().getX() + "\n§7Y: §b" + gracz.getLocation().getY() + "\n§7Z: §b" + gracz.getLocation().getZ());

                }
            } else {
                MessageManager.sendMessage(p, "error_no_permission");
            }
        } else {
            MessageManager.sendMessage(p, "error_no_permission");
        }
        return false;
    }
}
