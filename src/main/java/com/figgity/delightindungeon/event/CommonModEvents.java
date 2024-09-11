package com.figgity.delightindungeon.event;

import com.figgity.delightindungeon.DelightInDungeon;
import com.figgity.delightindungeon.entities.EntityInit;
import com.figgity.delightindungeon.entities.custom.WalkingMushroomEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DelightInDungeon.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.WALKNG_MUSHROOM.get(), WalkingMushroomEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(
                EntityInit.WALKNG_MUSHROOM.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                WalkingMushroomEntity::canSpawn,
                SpawnPlacementRegisterEvent.Operation.OR
        );
    }
}
