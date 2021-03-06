package me.currywurscht.left4dead.content.mobs;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class Witch extends ZombieMob {

	ZombieMobValues values;
	ZombieMobType type;
	LivingEntity entity;
	
	public Witch() {
		super(ZombieMobType.WITCH, null);
		this.values = new ZombieMobValues(ZombieMobType.WITCH);
		this.type = ZombieMobType.WITCH;
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
		return values;
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
	}

	@Override
	public void create(ZombieMobType type, Location loc) {
		Entity entity = ((CraftWorld)loc.getWorld()).spawnEntity(loc, EntityType.SKELETON);
		this.entity = (LivingEntity) entity;
	}
}
