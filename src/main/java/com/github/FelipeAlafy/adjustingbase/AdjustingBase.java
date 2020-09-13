package com.github.FelipeAlafy.adjustingbase;


import com.github.FelipeAlafy.adjustingbase.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("adjustingbase")
public class AdjustingBase {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "adjustingbase";

    public AdjustingBase() {
        LOGGER.info("Hello, Mhuuuuuaaaaaaa! see you later");
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {    }

    private void doClientStuff(final FMLClientSetupEvent event) {    }

    //Set creative tab and icon.
    public static final ItemGroup TAB = new ItemGroup("AdjustingBase"){
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RUBY.get());
        }
    };
}
