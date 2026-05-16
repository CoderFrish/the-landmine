package me.coderfrish.mods.the_landmine

import me.coderfrish.mods.the_landmine.registry.EffectRegistry
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

/* 神人的模组，神人的开始 */
class TheLandmineMod: ModInitializer {
    companion object {
        const val MOD_NAME = "The Landmine"

        val logger = LoggerFactory.getLogger(MOD_NAME)
    }

    override fun onInitialize() {
        EffectRegistry.register()
        logger.info("TheLandmineMod has been Initialized.")
    }
}
