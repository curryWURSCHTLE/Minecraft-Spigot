package me.currywurscht.left4dead.content.mobs;

import java.util.HashMap;

import me.currywurscht.left4dead.content.mobs.ZombieMob.ZombieMobType;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ZombieMobValues {
	
	private HashMap<ItemStack, String> content = new HashMap<>();
	private ZombieMobType type;
	
	public ZombieMobValues(ZombieMobType type) {
		this.type = type;
		addContent();
	}
	
	public void addContent() {
		switch(type) {
		case SMOKER:
			content.put(getLeatherArmor(1, Color.RED), "helmet");
			content.put(getLeatherArmor(2, Color.RED), "chestplate");
			content.put(getLeatherArmor(3, Color.RED), "leggings");
			content.put(getLeatherArmor(4, Color.RED), "boots");
			break;
		case SPITTER:
			content.put(getLeatherArmor(1, Color.GREEN), "helmet");
			content.put(getLeatherArmor(2, Color.GREEN), "chestplate");
			content.put(getLeatherArmor(3, Color.GREEN), "leggings");
			content.put(getLeatherArmor(4, Color.GREEN), "boots");
			break;
		default:
			break;
		}
	}
	
	private ItemStack getLeatherArmor(Integer id, Color color) {
		ItemStack istack = null;
		
		switch(id) {
		case 1:
			istack = new ItemStack(Material.LEATHER_HELMET);
			break;
		case 2:
			istack = new ItemStack(Material.LEATHER_CHESTPLATE);
			break;
		case 3:
			istack = new ItemStack(Material.LEATHER_LEGGINGS);
			break;
		case 4:
			istack = new ItemStack(Material.LEATHER_BOOTS);
			break;
		default:
			break;
		}
		LeatherArmorMeta meta = (LeatherArmorMeta) istack.getItemMeta();
		meta.setColor(color);
		istack.setItemMeta(meta);
		return istack;
	}
	
	@SuppressWarnings("deprecation")
	public void equip(ZombieMob mob) {
		EntityEquipment equip = mob.getEntity().getEquipment();
		for(ItemStack istack : content.keySet()) {
			switch(content.get(istack)) {
			case "helmet":
				equip.setHelmet(istack);
				break;
			case "chestplate":
				equip.setChestplate(istack);
				break;
			case "leggings":
				equip.setLeggings(istack);
				break;
			case "boots":
				equip.setBoots(istack);
				break;
			case "item":
				equip.setItemInHand(istack);
				break;
			default:
				break;
			}
		}
	}
	
	public HashMap<ItemStack, String> getContent() {
		return content;
	}
	
	public ZombieMobType getType() {
		return type;
	}
}
