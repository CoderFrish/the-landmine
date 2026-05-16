package me.coderfrish.mods.the_landmine.effect

import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.entity.Entity
import net.minecraft.world.item.enchantment.EnchantedItemInUse
import net.minecraft.world.item.enchantment.LevelBasedValue
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect
import net.minecraft.world.level.Level
import net.minecraft.world.phys.Vec3

data class LandmineBoomEffect(private val amount: LevelBasedValue): EnchantmentEntityEffect {
    companion object {
        val CODEC: MapCodec<LandmineBoomEffect> = RecordCodecBuilder.mapCodec { instance ->
            instance.group(
                LevelBasedValue.CODEC.fieldOf("amount").forGetter(LandmineBoomEffect::amount),
            ).apply(instance) { LandmineBoomEffect(it) }
        }

        fun boom(serverLevel: ServerLevel, entity: Entity) {
            serverLevel.explode(
                null,
                entity.x, entity.y, entity.z,
                6.0F, Level.ExplosionInteraction.MOB
            )
        }
    }

    override fun apply(
        serverLevel: ServerLevel,
        enchantmentLevel: Int,
        item: EnchantedItemInUse,
        entity: Entity,
        position: Vec3
    ) {
        boom(serverLevel, entity)
    }

    override fun codec(): MapCodec<out EnchantmentEntityEffect> = CODEC
}
