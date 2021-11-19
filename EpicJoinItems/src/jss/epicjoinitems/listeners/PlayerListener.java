package jss.epicjoinitems.listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import jss.epicjoinitems.EpicJoinItems;

public class PlayerListener implements Listener {

	private EpicJoinItems plugin;

	public PlayerListener(EpicJoinItems plugin) {
		this.plugin = plugin;
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	
	public void onDrop(PlayerDropItemEvent e) {
		
	}
	
	public EpicJoinItems getPlugin() {
		return plugin;
	}
}
