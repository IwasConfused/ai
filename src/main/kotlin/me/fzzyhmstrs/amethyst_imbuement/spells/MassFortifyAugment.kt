package me.fzzyhmstrs.amethyst_imbuement.spells

import me.fzzyhmstrs.amethyst_core.interfaces.SpellCastingEntity
import me.fzzyhmstrs.amethyst_core.modifier_util.AugmentConsumer
import me.fzzyhmstrs.amethyst_core.modifier_util.AugmentEffect
import me.fzzyhmstrs.amethyst_core.scepter_util.LoreTier
import me.fzzyhmstrs.amethyst_core.scepter_util.ScepterTier
import me.fzzyhmstrs.amethyst_core.scepter_util.SpellType
import me.fzzyhmstrs.amethyst_core.scepter_util.augments.AugmentDatapoint
import me.fzzyhmstrs.amethyst_core.scepter_util.augments.MiscAugment
import me.fzzyhmstrs.amethyst_imbuement.config.AiConfig
import me.fzzyhmstrs.fzzy_core.trinket_util.EffectQueue
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.mob.Monster
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.item.Items
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.world.World
import kotlin.math.max

class MassFortifyAugment: MiscAugment(ScepterTier.THREE,9){

    override val baseEffect: AugmentEffect = super.baseEffect
                                                .withAmplifier(-1,1,0)
                                                .withDuration(700,100,0)
                                                .withRange(9.0,1.0,0.0)

    override fun augmentStat(imbueLevel: Int): AugmentDatapoint {
        return AugmentDatapoint(SpellType.GRACE,1200,275,
            22,imbueLevel,35,LoreTier.HIGH_TIER, Items.GOLDEN_APPLE)
    }

    override fun effect(
        world: World,
        user: LivingEntity,
        entityList: MutableList<Entity>,
        level: Int,
        effect: AugmentEffect
    ): Boolean {
        var successes = 0

        if (entityList.isEmpty()){
            successes++
            EffectQueue.addStatusToQueue(user,StatusEffects.RESISTANCE, effect.duration(level), max(effect.amplifier((level-1)/4+3),3))
            EffectQueue.addStatusToQueue(user,StatusEffects.STRENGTH, (effect.duration(level) * 1.25).toInt(), effect.amplifier((level-1)/4))
            effect.accept(user, AugmentConsumer.Type.BENEFICIAL)
        } else {
            entityList.add(user)
            for (entity3 in entityList) {
                if (entity3 !is Monster && entity3 !is PassiveEntity && entity3 is LivingEntity) {
                    if (entity3 is SpellCastingEntity && !AiConfig.entities.isEntityPvpTeammate(user,entity3,this)) continue
                    successes++
                    EffectQueue.addStatusToQueue(entity3, StatusEffects.RESISTANCE, effect.duration(level),  max(effect.amplifier((level-1)/4+2),2))
                    EffectQueue.addStatusToQueue(entity3, StatusEffects.STRENGTH,  effect.duration(level), effect.amplifier((level-1)/4))
                    effect.accept(entity3,AugmentConsumer.Type.BENEFICIAL)
                }
            }
        }
        return successes > 0
    }

    override fun soundEvent(): SoundEvent {
        return SoundEvents.BLOCK_BEACON_ACTIVATE
    }
}
