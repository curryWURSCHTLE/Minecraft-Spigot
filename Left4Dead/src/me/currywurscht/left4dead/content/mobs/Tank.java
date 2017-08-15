package me.currywurscht.left4dead.content.mobs;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class Tank extends ZombieMob {

	ZombieMobValues values;
	ZombieMobType type;
	LivingEntity entity;
	
	public Tank() {
		super(ZombieMobType.TANK, null);
		this.values = new ZombieMobValues(ZombieMobType.TANK);
		this.type = ZombieMobType.TANK;
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
		Entity entity = ((CraftWorld)loc.getWorld()).spawnEntity(loc, EntityType.IRON_GOLEM);
		this.entity = (LivingEntity) entity;
	}
}
