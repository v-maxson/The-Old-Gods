package mod.maxson.entity;

import mod.maxson.TheOldGods;
import mod.maxson.entity.custom.SphedgeEntity;
import mod.maxson.util.ModIdentifier;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEntities {
    public static final EntityType<SphedgeEntity> SPHEDGE = Registry.register(Registries.ENTITY_TYPE, ModIdentifier.of("sphedge"),
            EntityType.Builder.create(SphedgeEntity::new, SpawnGroup.CREATURE).setDimensions(1f, 2f).build("sphedge"));

    public static void initialize() {
        TheOldGods.LOGGER.info("Registering Entities...");

        // Register Boats
        ModBoats.initialize();

        FabricDefaultAttributeRegistry.register(SPHEDGE, SphedgeEntity.createSphedgeAttributes());
    }
}
