package me.currywurscht.left4dead.content.mobs;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;

public class Jockey extends ZombieMob {

	ZombieMobValues values;
	ZombieMobType type;
	LivingEntity entity;
	
	public Jockey() {
		super(ZombieMobType.JOCKEY, null);
		this.values = new ZombieMobValues(ZombieMobType.JOCKEY);
		this.type = ZombieMobType.JOCKEY;
	}

	@Override
	public ZombieMobType getType() {
		return type;
	}

	@Override
	public void setType(ZombieMobType type) {
		this.type = type;
	}

	@Override
	public ZombieMobValues getValue() {
		return this.values;
	}

	@Override
	public void setValue(ZombieMobValues value) {
		this.values = value;
	}

	@Override
	public LivingEntity getEntity() {
		return entity;
	}

	@Override
	public void setEntity(LivingEntity entity) {
		this.entity = entity;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(ZombieMobType type, Location loc) {
		Pig pig = (Pig)((CraftWorld)loc.getWorld()).spawnEntity(loc, EntityType.PIG);
		pig.setBaby();
		this.entity = (LivingEntity) pig;
	}

}
