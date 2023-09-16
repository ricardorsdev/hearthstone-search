package com.ricardorsdev.hearthstonesearch.data.remote.dto

import com.ricardorsdev.hearthstonesearch.domain.model.Battlegrounds

data class BattlegroundsDto(
    val hero: Boolean,
    val image: String,
    val imageGold: String,
    val quest: Boolean,
    val reward: Boolean,
    val tier: Int,
    val upgradeId: Int
)

fun BattlegroundsDto.toBattlegrounds(): Battlegrounds {
    return Battlegrounds(
        hero = hero,
        image = image,
        quest = quest,
        reward = reward,
        tier = tier
    )
}