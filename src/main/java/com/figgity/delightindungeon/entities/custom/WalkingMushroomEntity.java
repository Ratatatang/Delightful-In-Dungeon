package com.figgity.delightindungeon.entities.custom;

import com.figgity.delightindungeon.entities.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;


public class WalkingMushroomEntity extends Monster {
    public WalkingMushroomEntity(EntityType<WalkingMushroomEntity> pEntity, Level pLevel) {
        super(pEntity, pLevel);
    }

    public WalkingMushroomEntity(Level level, double x, double y, double z) {
        this(EntityInit.WALKNG_MUSHROOM.get(), level);
        setPos(x, y, z);
    }

    public WalkingMushroomEntity(Level level, BlockPos position) {
        this(level, position.getX(), position.getY(), position.getZ());
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, AbstractVillager.class, false));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 10.0)
                .add(Attributes.FOLLOW_RANGE, 25.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ATTACK_DAMAGE, 1.5);
    }

    public static boolean canSpawn(EntityType<WalkingMushroomEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
        //if (level.getHeight() >= level.getSeaLevel()) {
        //    return false;
        return Monster.checkMonsterSpawnRules(entityType, level, spawnType, position, random);
    }
}
