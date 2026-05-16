package me.coderfrish.mods.the_landmine.generator

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import java.util.concurrent.CompletableFuture

class EnchantmentGenerator(
    output: FabricPackOutput,
    registriesFuture: CompletableFuture<HolderLookup.Provider>
): FabricDynamicRegistryProvider(output, registriesFuture) {
    override fun configure(
        provider: HolderLookup.Provider,
        entries: Entries
    ) {
        entries.addAll(provider.lookupOrThrow(Registries.ENCHANTMENT))
    }

    override fun getName(): String {
        return "Enchantments"
    }
}
