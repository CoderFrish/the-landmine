package me.coderfrish.mods.the_landmine.provider

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.tags.TagKey
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.Enchantments
import java.util.concurrent.CompletableFuture

class EnchantmentTagsProvider(output: FabricPackOutput, registryLookupFuture: CompletableFuture<HolderLookup.Provider>):
    FabricTagsProvider<Enchantment>(output, Registries.ENCHANTMENT, registryLookupFuture) {
    companion object {
        val landmine_excluives: TagKey<Enchantment> = TagKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath("the_landmine", "landmine_excluives"))
    }

    override fun addTags(registries: HolderLookup.Provider) {
        builder(landmine_excluives).add(Enchantments.UNBREAKING)
    }
}
