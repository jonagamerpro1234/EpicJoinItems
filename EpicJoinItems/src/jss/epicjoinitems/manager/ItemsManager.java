package jss.epicjoinitems.manager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import jss.epicjoinitems.utils.Utils;

public class ItemsManager {

	private String name;
	private String material;
	private String command;
	private String permission;
	private List<String> lore;
	private int amount;
	
	public ItemsManager(String name, String material, String command, String permission, int amount) {
		this.name = name;
		this.material = material;
		this.command = command;
		this.permission = permission;
		this.amount = amount;
	}
	
	@SuppressWarnings("null")
	public void giveTo(Player player) {
		PlayerInventory inv = player.getInventory();
		if(inv.firstEmpty() == -1) {
			Utils.sendColorMessage(player, "&6Your inventory is full!");
		}else {
			ItemStack[] a = null;
			int b = player.getInventory().getContents().length;
			
			ItemStack item;
			for(int c = 0; c < b; ++c) {
				item = a[c];
				if(this.isSimilar(item)) {
					Utils.sendColorMessage(player, "&cYour already own this item");
					return;
				}
			}

	         item = new ItemStack(Material.valueOf(material.toUpperCase()));
	         ItemMeta meta = item.getItemMeta();
	         meta.setDisplayName(this.name);
	         if (this.lore != null) {
	            meta.setLore(this.lore);
	         }

	         item.setItemMeta(meta);
	         item.setAmount(this.amount);
	         inv.addItem(new ItemStack[]{item});
		}
	}
	
	public boolean isSimilar(ItemStack item) {
		if (item == null) {
			return false;
		} else if (item.getType() != Material.valueOf(material.toUpperCase())) {
			return false;
		} else if (!item.hasItemMeta()) {
			return false;
		} else {
			return item.getItemMeta().getDisplayName().equals(this.name);
		}
	}
	
	public boolean hasPermission(Player player) {
		return this.permission != null && this.permission.length() != 0 ? player.hasPermission(this.permission) : true;
	}
	
	public void executeCommand(Player player) {
		if(this.command != null && this.command.length() > 0) {
			player.chat("/" + this.command);
		}
	}
	
	public void setLore(List<String> lore) {
		if(isLore()) {
			lore.forEach( lines -> {
				String lineColored = Utils.color(lines);
				this.lore.add(lineColored);
			});
		}else {
			this.lore = new ArrayList<>();
		}
	}
	
	private boolean isLore() {
		return this.lore != null && this.lore.size() != 0 ? false : true;
	}
}
