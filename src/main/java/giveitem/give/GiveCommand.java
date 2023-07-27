package giveitem.give;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class GiveCommand implements CommandExecutor {

    private Main plugin;

    public GiveCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("TestGive")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length > 3) {


                    player.sendMessage(ChatColor.BOLD + " /give <player> <item> <amount>");

                    return true;
                }
                else if(args.length == 3){
                    if(!(Bukkit.getPlayer(args[0]) == null)) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if(!(org.bukkit.Material.getMaterial(args[1]) == null)){
                            player.sendMessage("Giving " + player + args[0] + ChatColor.GREEN + args[2] + " " + args[1] + ChatColor.YELLOW + ".");
                            target.sendMessage("You have received " + ChatColor.GREEN + args[2] + " " + args[1] + ChatColor.YELLOW + " from " + player + player.getName() + ChatColor.YELLOW + ".");

                            String Amt = args[1];

                            ItemStack Item = new ItemStack(Material.matchMaterial(args[2]));
                            Item.setAmount(Integer.parseInt(Amt));
                            PlayerInventory inv = player.getInventory();
                            inv.addItem(Item);
                        }
                    }
                }
            } else {
                sender.sendMessage("SenderNotPlayer");
            }
        }
        return false;
    }
}