package me.coderfrish.mods.the_landmine.generator

import me.coderfrish.mods.the_landmine.registry.EnchantmentRegistry
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries

class TheLandmineGenerator: DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(pack: FabricDataGenerator) {
        pack.createPack().addProvider { p0, p1 ->
            EnchantmentGenerator(p0, p1)
        }
    }

    override fun buildRegistry(registryBuilder: RegistrySetBuilder) {
        registryBuilder.add(Registries.ENCHANTMENT, EnchantmentRegistry::register)
    }
}
