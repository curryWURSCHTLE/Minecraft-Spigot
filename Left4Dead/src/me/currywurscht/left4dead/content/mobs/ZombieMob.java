package me.currywurscht.left4dead.content.mobs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

public abstract class ZombieMob {
	
	public static List<ZombieMob> zombies = new ArrayList<>();
	
	ZombieMobType type;
	ZombieMobValues value;
	LivingEntity entity;
	
	public ZombieMob(ZombieMobType type) {
		this.type = type;
		this.value = new ZombieMobValues(type);
	}
	
	public ZombieMob(ZombieMobType type, ZombieMobValues value) {
		this.type = type;
		this.value = value; 
	}
	
	public abstract ZombieMobType getType();
	
	public abstract void setType(ZombieMobType type);

	public abstract ZombieMobValues getValue();

	public abstract void setValue(ZombieMobValues value);
	
	public abstract LivingEntity getEntity();

	public abstract void setEntity(LivingEntity entity);
	
	public abstract void attack();
	
	public abstract void create(ZombieMobType type, Location loc);


	public enum ZombieMobType {
		BOOMER("§4BOOMER", 1),
		CHARGER("§4CHARGER", 2),
		JOCKEY("§4JOCKEY", 3),
		SMOKER("§4SMOKER", 4),
		SPITTER("§4SPITTER", 5),
		TANK("§4TANK", 6),
		WITCH("§6WITCH", 7),
		ZOMBIE(null, 0);
		
		String name;
		int specialAttack;
		
		ZombieMobType(String name, int specialAttack) {
			this.name = name;
			this.specialAttack = specialAttack;
		}
		
		public String getName() {
			return name;
		}
		
		public int getSpecialAttackId() {
			return specialAttack;
		}
	}
}
