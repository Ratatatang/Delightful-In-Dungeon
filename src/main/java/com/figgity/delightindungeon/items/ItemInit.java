package com.figgity.delightindungeon.items;

import com.figgity.delightindungeon.DelightInDungeon;
import com.figgity.delightindungeon.entities.EntityInit;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, DelightInDungeon.MODID);

    public static final RegistryObject<ForgeSpawnEggItem> WALKING_MUSHROOM_SPAWN_EGG = Items.register("walking_mushroom_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.WALKNG_MUSHROOM, 0xFF7676, 0xDADAD1, new Item.Properties()));

    public static final RegistryObject<Item> MUSHROOM_SLICE = Items.register("mushroom_slice",
            () -> new Item(new Item.Properties()));
}
