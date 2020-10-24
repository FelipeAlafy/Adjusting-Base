package com.github.FelipeAlafy.adjustingbase;


import com.github.FelipeAlafy.adjustingbase.util.world.config.Config;
import com.github.FelipeAlafy.adjustingbase.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("adjustingbase")
public class AdjustingBase {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "adjustingbase";



    public AdjustingBase() {
        LOGGER.info("Mhuuuuuaaaaaaa! see you later");
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.client_config);

        Config.loadConfig(Config.client_config, FMLPaths.CONFIGDIR.get().resolve("adjustingbase-client.toml").toString());
        Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve("adjustingbase-server.toml").toString());

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {    }

    private void doClientStuff(final FMLClientSetupEvent event) {    }

    //Set creative tab and icon.
    public static final ItemGroup TAB = new ItemGroup("adjustingbaseTab"){
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RUBY.get());
        }
    };
}