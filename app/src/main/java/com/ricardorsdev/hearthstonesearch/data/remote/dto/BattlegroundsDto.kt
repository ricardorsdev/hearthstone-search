package com.ricardorsdev.hearthstonesearch.data.remote.dto

data class BattlegroundsDto(
    val companionId: Int,
    val hero: Boolean,
    val image: String,
    val imageGold: String,
    val quest: Boolean,
    val reward: Boolean,
    val tier: Int,
    val upgradeId: Int
)