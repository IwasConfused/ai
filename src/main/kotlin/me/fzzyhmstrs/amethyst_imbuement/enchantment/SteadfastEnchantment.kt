package me.fzzyhmstrs.amethyst_imbuement.enchantment

import net.minecraft.enchantment.EnchantmentTarget
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorItem
import net.minecraft.item.ItemStack
import java.util.*

class SteadfastEnchantment(weight: Rarity, vararg slot: EquipmentSlot): ConfigDisableEnchantment(weight, EnchantmentTarget.ARMOR,*slot) {

    internal val uuids: EnumMap<EquipmentSlot, UUID> = EnumMap(mapOf(
        EquipmentSlot.HEAD to UUID.fromString("797ca106-ba09-11ed-afa1-0242ac120002"),
        EquipmentSlot.CHEST to UUID.fromString("797ca52a-ba09-11ed-afa1-0242ac120002"),
        EquipmentSlot.LEGS to UUID.fromString("797ca67e-ba09-11ed-afa1-0242ac120002"),
        EquipmentSlot.FEET to UUID.fromString("797ca836-ba09-11ed-afa1-0242ac120002")
    ))

    override fun getMinPower(level: Int): Int {
        return 15 * level
    }

    override fun getMaxPower(level: Int): Int {
        return getMinPower(level) + 20
    }

    override fun getMaxLevel(): Int {
        return 3
    }

    override fun isAcceptableItem(stack: ItemStack): Boolean {
        return (stack.item is ArmorItem) && enabled
    }

}