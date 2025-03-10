package me.fzzyhmstrs.amethyst_imbuement.registry

import me.fzzyhmstrs.amethyst_imbuement.AI
import me.fzzyhmstrs.amethyst_imbuement.screen.*
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.network.PacketByteBuf
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.resource.featuretoggle.FeatureFlags
import net.minecraft.resource.featuretoggle.FeatureSet
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier

object RegisterHandler {
    var IMBUING_SCREEN_HANDLER: ScreenHandlerType<ImbuingTableScreenHandler>? = null
    var ALTAR_OF_EXPERIENCE_SCREEN_HANDLER: ScreenHandlerType<AltarOfExperienceScreenHandler>? = null
    var DISENCHANTING_TABLE_SCREEN_HANDLER: ScreenHandlerType<DisenchantingTableScreenHandler>? = null
    var CRYSTAL_ALTAR_SCREEN_HANDLER: ScreenHandlerType<CrystalAltarScreenHandler>? = null
    var SPELLCASTERS_FOCUS_SCREEN_HANDLER: ExtendedScreenHandlerType<SpellcastersFocusScreenHandler>? = null

    fun registerAll(){

        IMBUING_SCREEN_HANDLER = ScreenHandlerType ( { syncID: Int, playerInventory: PlayerInventory ->
            ImbuingTableScreenHandler(
                syncID,
                playerInventory
            )
        }, FeatureFlags.VANILLA_FEATURES)

        ALTAR_OF_EXPERIENCE_SCREEN_HANDLER = ScreenHandlerType( { syncID: Int, playerInventory: PlayerInventory ->
            AltarOfExperienceScreenHandler(
                syncID,
                playerInventory
            )
        }, FeatureFlags.VANILLA_FEATURES)

        DISENCHANTING_TABLE_SCREEN_HANDLER = ScreenHandlerType( { syncID: Int, playerInventory: PlayerInventory ->
            DisenchantingTableScreenHandler(
                syncID,
                playerInventory
            )
        }, FeatureFlags.VANILLA_FEATURES)

        CRYSTAL_ALTAR_SCREEN_HANDLER = ScreenHandlerType( { syncID: Int, playerInventory: PlayerInventory ->
            CrystalAltarScreenHandler(
                syncID,
                playerInventory
            )
        }, FeatureFlags.VANILLA_FEATURES)
        
        SPELLCASTERS_FOCUS_SCREEN_HANDLER = ExtendedScreenHandlerType { syncID: Int, playerInventory: PlayerInventory, buf: PacketByteBuf ->
            SpellcastersFocusScreenHandler(
                syncID,
                playerInventory,
                buf
            )
        }

        Registry.register(Registries.SCREEN_HANDLER,Identifier(AI.MOD_ID,"imbuing_table"), IMBUING_SCREEN_HANDLER)
        Registry.register(Registries.SCREEN_HANDLER,Identifier(AI.MOD_ID,"altar_of_experience"), ALTAR_OF_EXPERIENCE_SCREEN_HANDLER)
        Registry.register(Registries.SCREEN_HANDLER,Identifier(AI.MOD_ID,"disenchanting_table"), DISENCHANTING_TABLE_SCREEN_HANDLER)
        Registry.register(Registries.SCREEN_HANDLER,Identifier(AI.MOD_ID,"crystal_altar"), CRYSTAL_ALTAR_SCREEN_HANDLER)
        Registry.register(Registries.SCREEN_HANDLER,Identifier(AI.MOD_ID,"spellcasters_focus"), SPELLCASTERS_FOCUS_SCREEN_HANDLER)
    }
}
