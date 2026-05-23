package me.coderfrish.mods.the_landmine.registry

import com.mojang.serialization.MapCodec
import me.coderfrish.mods.the_landmine.effect.LandmineBoomEffect
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier

internal object EffectRegistry {
    val landmine_boom_effect: MapCodec<LandmineBoomEffect> = Registry.register(
        BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE,
        Identifier.fromNamespaceAndPath("the_landmine", "landmine_boom_effect"),
        LandmineBoomEffect.CODEC
    )

    fun register() {}
}
