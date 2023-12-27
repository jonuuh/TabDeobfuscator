# Minecraft 1.8.9 Forge Template

##TODO:

    src
    └── main
            ├── java
            │       └── net
            │              └── example
            │                         └── examplemod
            │                                       └── ExampleMod.java
            └── resources
                         └── mcmod.info

- Edit package name **example**
- Edit package name **examplemod**
- Edit file name **ExampleMod**.java

### ExampleMod.java:

    1     package net.example.examplemod;
    2
    3     import net.minecraft.init.Blocks;
    4     import net.minecraftforge.fml.common.Mod;
    5     import net.minecraftforge.fml.common.Mod.EventHandler;
    6     import net.minecraftforge.fml.common.event.FMLInitializationEvent;
    7
    8     @Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
    9     public class ExampleMod
    10    {
    11    public static final String MODID = "examplemod";
    12    public static final String VERSION = "1.0";
    13
    14        @EventHandler
    15        public void init(FMLInitializationEvent event)
    16        {
    17            System.out.println("DIRT BLOCK: " + Blocks.dirt.getUnlocalizedName());
    18        }
    19    }

- Edit line 1: net.**example.examplemod**;
- Edit line 8: @Mod(modid = **ExampleMod**.MODID, version = **ExampleMod**.VERSION)
- Edit line 9: public class **ExampleMod**
- Edit line 11: public static final String MODID = "**examplemod**";

### mcmod.info:

    1     [
    2         {
    3             "modid": "examplemod",
    4             "name": "Example Mod",
    5             "description": "An example mod.",
    6             "version": "${version}",
    7             "mcversion": "${mcversion}",
    8             "url": "",
    9             "updateUrl": "",
    10            "authorList": ["The author"],
    11            "credits": "",
    12            "logoFile": "",
    13            "screenshots": [],
    14            "dependencies": []
    15        }
    16    ]

- Edit line 3: "modid": "**examplemod**",
- Edit line 4: "name": "**Example Mod**",
- Edit line 5: "description": "**An example mod.**",
- Edit line 10: "authorList": \["**The author**"\],

### build.gradle:

    24    group= "net.yourname.modid" // http://maven.apache.org/guides/mini/guide-naming-conventions.html
    25    archivesBaseName = "modid"

- Edit line 24: group= "net.**yourname**.**modid**"
- Edit line 25: archivesBaseName = "**modid**"

## Next:
- Run gradle task **runClient** to run the game
- Run grade task **build** to build a jar file (build > libs > modid-version.jar)