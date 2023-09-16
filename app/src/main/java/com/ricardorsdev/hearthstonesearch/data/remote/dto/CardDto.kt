package com.ricardorsdev.hearthstonesearch.data.remote.dto

data class CardDto(
    val armor: Int,
    val artistName: String,
    val attack: Int,
    val battlegrounds: BattlegroundsDto,
    val cardSetId: Int,
    val cardTypeId: Int,
    val childIds: List<Int>,
    val classId: Int,
    val collectible: Int,
    val cropImage: String,
    val flavorText: String,
    val health: Int,
    val id: Int,
    val image: String,
    val imageGold: String,
    val keywordIds: List<Int>,
    val manaCost: Int,
    val minionTypeId: Int,
    val multiClassIds: List<Any>,
    val multiTypeIds: List<Int>,
    val name: String,
    val rarityId: Int,
    val slug: String,
    val text: String
)