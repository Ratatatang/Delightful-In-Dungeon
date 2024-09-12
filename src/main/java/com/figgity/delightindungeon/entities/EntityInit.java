package com.figgity.delightindungeon.entities;

import com.figgity.delightindungeon.DelightInDungeon;
import com.figgity.delightindungeon.entities.custom.WalkingMushroomEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DelightInDungeon.MODID);

    public static final RegistryObject<EntityType<WalkingMushroomEntity>> WALKNG_MUSHROOM =
            ENTITY_TYPES.register("walking_mushroom", () -> EntityType.Builder.<WalkingMushroomEntity>of(WalkingMushroomEntity::new, MobCategory.CREATURE)
                    .sized(0.7f, 1.3f)
                    .build(new ResourceLocation(DelightInDungeon.MODID, "walking_mushroom").toString()));
}
