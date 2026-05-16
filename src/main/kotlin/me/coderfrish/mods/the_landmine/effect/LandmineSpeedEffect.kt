package me.coderfrish.mods.the_landmine.effect

import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.ai.attributes.AttributeInstance
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.enchantment.EnchantedItemInUse
import net.minecraft.world.item.enchantment.LevelBasedValue
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect
import net.minecraft.world.phys.Vec3

data class LandmineSpeedEffect(private val amount: LevelBasedValue): EnchantmentEntityEffect {
    companion object {
        val CODEC: MapCodec<LandmineSpeedEffect> = RecordCodecBuilder.mapCodec { instance ->
            instance.group(
                LevelBasedValue.CODEC.fieldOf("amount").forGetter(LandmineSpeedEffect::amount),
            ).apply(instance) { LandmineSpeedEffect(it) }
        }
    }

    override fun apply(
        serverLevel: ServerLevel,
        enchantmentLevel: Int,
        item: EnchantedItemInUse,
        entity: Entity,
        position: Vec3
    ) {
        if (entity is Player) {
            if (entity.isUsingItem && !entity.isSprinting) {
                entity.isSprinting = true
            }
        }
    }

    override fun codec(): MapCodec<out EnchantmentEntityEffect> = CODEC
}
