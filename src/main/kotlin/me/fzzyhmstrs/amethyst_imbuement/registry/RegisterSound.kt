package me.fzzyhmstrs.amethyst_imbuement.registry

import me.fzzyhmstrs.amethyst_imbuement.AI
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier

object RegisterSound {

    private val HAMSTER_HIT_ID = Identifier(AI.MOD_ID,"hamster_hit")
    val HAMSTER_HIT = soundEvent(HAMSTER_HIT_ID)

    private val HAMSTER_DIE_ID = Identifier(AI.MOD_ID,"hamster_die")
    val HAMSTER_DIE = soundEvent(HAMSTER_DIE_ID)

    private val HAMSTER_AMBIENT_ID = Identifier(AI.MOD_ID,"hamster_ambient")
    val HAMSTER_AMBIENT = soundEvent(HAMSTER_AMBIENT_ID)

    private val UNLOCK_ID = Identifier(AI.MOD_ID,"unlock")
    val UNLOCK = soundEvent(UNLOCK_ID)

    private val LOCKED_BOOK_ID = Identifier(AI.MOD_ID,"locked_book")
    val LOCKED_BOOK = soundEvent(LOCKED_BOOK_ID)

    private val EXECUTE_ID = Identifier(AI.MOD_ID,"execute")
    val EXECUTE = soundEvent(EXECUTE_ID)

    private val ICE_SPIKES_ID = Identifier(AI.MOD_ID,"ice_spikes")
    val ICE_SPIKES = soundEvent(ICE_SPIKES_ID)

    private val SOLAR_FLARE_CHARGE_ID = Identifier(AI.MOD_ID,"solar_flare_charge")
    val SOLAR_FLARE_CHARGE = soundEvent(SOLAR_FLARE_CHARGE_ID)

    private val SOLAR_FLARE_FIRE_ID = Identifier(AI.MOD_ID,"solar_flare_fire")
    val SOLAR_FLARE_FIRE = soundEvent(SOLAR_FLARE_FIRE_ID)

    private val ENERGY_BLADE_ID = Identifier(AI.MOD_ID,"energy_blade")
    val ENERGY_BLADE = soundEvent(ENERGY_BLADE_ID)

    private fun soundEvent(identifier: Identifier): SoundEvent{
        return Registry.register(Registries.SOUND_EVENT,identifier, SoundEvent.of(identifier))
    }

    fun registerAll(){

    }


}