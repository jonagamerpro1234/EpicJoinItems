package jss.epicjoinitems;

import java.util.ArrayList;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import jss.epicjoinitems.listeners.utils.EventsUtils;
import jss.epicjoinitems.manager.ItemsManager;
import jss.epicjoinitems.utils.Utils;

public class EpicJoinItems extends JavaPlugin {

	private PluginDescriptionFile jss = getDescription();
	private static EpicJoinItems plugin;
	public Metrics metrics;
	public String name = this.jss.getName();
	public String version = this.jss.getVersion();
	public ArrayList<ItemsManager> itemsmanager = new ArrayList<>();
	public EventsUtils eventsUtils = new EventsUtils();
	
	public void onEnable() {
		Utils.sendColorConsoleMessage(eventsUtils.getConsoleSender(), Utils.getPrefix() + "&aEnabled &b" + this.name + " Version:" + this.version);
		plugin = this;
		metrics = new Metrics(this, 12437);
	}
	
	public void onDisable() {
		Utils.sendColorConsoleMessage(eventsUtils.getConsoleSender(), Utils.getPrefix() + "&dDisabled &b" + this.name + " Version:" + this.version);
		metrics = null;
	}
	
	public static EpicJoinItems getPlugin() {
		return plugin;
	}
}
