package com.github.FelipeAlafy.adjustingbase.util;

import com.github.FelipeAlafy.adjustingbase.AdjustingBase;
import com.github.FelipeAlafy.adjustingbase.armor.ModArmorMaterial;
import com.github.FelipeAlafy.adjustingbase.blocks.*;
import com.github.FelipeAlafy.adjustingbase.items.ChupChup;
import com.github.FelipeAlafy.adjustingbase.items.ItemBailey;
import com.github.FelipeAlafy.adjustingbase.items.ItemBase;
import com.github.FelipeAlafy.adjustingbase.items.ItemSieve;
import com.github.FelipeAlafy.adjustingbase.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AdjustingBase.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AdjustingBase.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Item> BAILEY = ITEMS.register("bailey", ItemBailey::new);
    public static final RegistryObject<Item> MACHINE_FRAME = ITEMS.register("machine_frame", ItemBase::new);
    public static final RegistryObject<Item> TEMPERED_GLASS_RAW = ITEMS.register("tempered_glass_raw", ItemBase::new);
    public static final RegistryObject<Item> SIEVE = ITEMS.register("sieve", ItemSieve::new);
    public static final RegistryObject<Item> SILICON = ITEMS.register("silicon", ItemBase::new);
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", ItemBase::new);

    //Dusts
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", ItemBase::new);
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust", ItemBase::new);

    //Food
    public static final RegistryObject<ChupChup> CHUP_CHUP = ITEMS.register("chup_chup", ChupChup::new);

    //Tools
    //Ruby Tools
    //Ruby Sword
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () ->
            new SwordItem(ModItemTier.RUBY, 2, -2.4F, new Item.Properties().group(AdjustingBase.TAB)));
    //Ruby Pickaxe
    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () ->
            new PickaxeItem(ModItemTier.RUBY, 0, 2.0F, new Item.Properties().group(AdjustingBase.TAB)));
    //Ruby Axe
    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe", () ->
            new AxeItem(ModItemTier.RUBY, 0, 2.0F, new Item.Properties().group(AdjustingBase.TAB)));
    //Ruby Shovel
    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () ->
            new ShovelItem(ModItemTier.RUBY, 0, 2.0F, new Item.Properties().group(AdjustingBase.TAB)));
    //Ruby Hoe
    public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register("ruby_hoe", () ->
            new HoeItem(ModItemTier.RUBY, -3,-1.0F, new Item.Properties().group(AdjustingBase.TAB)));

    //Armor
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", () ->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(AdjustingBase.TAB)));

    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () ->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(AdjustingBase.TAB)));

    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () ->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(AdjustingBase.TAB)));

    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots", () ->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(AdjustingBase.TAB)));

    //Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", RubyOre::new);
    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", CopperOre::new);
    public static final RegistryObject<Block> TEMPERED_GLASS = BLOCKS.register("tempered_glass", TemperedGlass::new);

    //Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));
    public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", () ->  new BlockItemBase(RUBY_ORE.get()));
    public static final RegistryObject<Item> TEMPERED_GLASS_ITEM = ITEMS.register("tempered_glass", () -> new BlockItemBase(TEMPERED_GLASS.get()));
    public static final RegistryObject<Item> COPPER_ORE_ITEM = ITEMS.register("copper_ore", () -> new BlockItemBase(COPPER_ORE.get()));
}
