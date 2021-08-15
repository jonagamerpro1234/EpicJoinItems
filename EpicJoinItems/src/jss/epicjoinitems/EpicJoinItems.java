package jss.epicjoinitems;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class EpicJoinItems extends JavaPlugin {

	private PluginDescriptionFile jss = getDescription();
	private static EpicJoinItems plugin;
	public Metrics metrics;
	public String name = this.jss.getName();
	public String version = this.jss.getVersion();
	
	public void onEnable() {
		plugin = this;
		metrics = new Metrics(this, 12437);
	}
	
	public void onDisable() {
		
	}
	
	public static EpicJoinItems getPlugin() {
		return plugin;
	}
}
