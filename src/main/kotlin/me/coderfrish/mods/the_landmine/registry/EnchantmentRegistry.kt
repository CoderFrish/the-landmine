package me.coderfrish.mods.the_landmine.registry

import me.coderfrish.mods.the_landmine.effect.LandmineBoomEffect
import me.coderfrish.mods.the_landmine.effect.LandmineSpeedEffect
import net.minecraft.core.registries.Registries
import net.minecraft.core.registries.Registries.ITEM
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.ItemTags
import net.minecraft.world.entity.EquipmentSlotGroup
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents
import net.minecraft.world.item.enchantment.EnchantmentTarget
import net.minecraft.world.item.enchantment.LevelBasedValue

internal object EnchantmentRegistry {
    val landmine_id: Identifier = Identifier.fromNamespaceAndPath("the_landmine", "landmine");
    val landmine: ResourceKey<Enchantment> = ResourceKey.create(Registries.ENCHANTMENT, landmine_id)

    fun register(context: BootstrapContext<Enchantment>) {
        val items = context.lookup(ITEM)

        val landmine = Enchantment.enchantment(
            Enchantment.definition(
                items.getOrThrow(ItemTags.SPEARS), 1, 1,
                Enchantment.constantCost(25), Enchantment.constantCost(50), 8,
                EquipmentSlotGroup.MAINHAND
            )
        ).withEffect(
            EnchantmentEffectComponents.TICK,
            LandmineSpeedEffect(LevelBasedValue.perLevel(1.0F))
        ).withEffect(
            EnchantmentEffectComponents.POST_ATTACK,
            EnchantmentTarget.ATTACKER,
            EnchantmentTarget.DAMAGING_ENTITY,
            LandmineBoomEffect(LevelBasedValue.perLevel(1.0F))
        )

        context.register(EnchantmentRegistry.landmine, landmine.build(landmine_id))
    }
}
