package jss.epicjoinitems.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import jss.epicjoinitems.EpicJoinItems;

public class EpicJoinItemsCmd implements CommandExecutor {

	private EpicJoinItems plugin;
	
	public EpicJoinItemsCmd(EpicJoinItems plugin) {
		this.plugin = plugin;
	}



	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			if(args.length >= 1) {
				
				if(args[0].equalsIgnoreCase("relaod") || args[0].equalsIgnoreCase("rl")) {
					return true;
				}
				
				return true;
			}
			
			return false;
		}
		
		Player j = (Player) sender;
		
		if((j.isOp()) || (j.hasPermission("EpicJoinItems.Admin"))) {
			
			if(args.length >= 1) {
				
				if(args[0].equalsIgnoreCase("relaod") || args[0].equalsIgnoreCase("rl")) {
					if((j.isOp()) || (j.hasPermission("EpicJoinItems.Reload"))) {
						
					}else {
						
					}
					return true;
				}
				
				
				return true;
			}
			
		}else {
			return true;
		}
		
		return true;
	}
	
}
