package com.ricardorsdev.hearthstonesearch.domain.model

import com.ricardorsdev.hearthstonesearch.data.remote.dto.BattlegroundsDto

data class Card(
    val attack: Int,
    val battlegrounds: Battlegrounds,
    val cropImage: String,
    val health: Int,
    val id: Int,
    val image: String,
    val manaCost: Int,
    val minionTypeId: Int,
    val name: String,
    val text: String
)
