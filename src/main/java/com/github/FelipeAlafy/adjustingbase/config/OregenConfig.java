package com.github.FelipeAlafy.adjustingbase.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig {
    public static ForgeConfigSpec.BooleanValue gen_ruby;
    public static ForgeConfigSpec.BooleanValue gen_copper;
    public static ForgeConfigSpec.BooleanValue gen_tin;
    public static ForgeConfigSpec.BooleanValue gen_silver;
    public static ForgeConfigSpec.BooleanValue gen_aluminum;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client){
        server.comment("Oregen Config");
        gen_ruby = server.comment("Generated Ruby? true or false")
                .define("oregen.gen_ruby", true);
        gen_copper = server.comment("Generated Copper? true or false")
                .define("oregen.gen_copper", true);
        gen_tin = server.comment("Generated Tin? true or false")
                .define("oregen.gen_tin", true);
        gen_silver = server.comment("Generated Silver? true or false")
                .define("oregen.gen_silver", true);
        gen_aluminum = server.comment("Generated Aluminum? true or false")
                .define("oregen.gen_aluminum", true);
    }
}
