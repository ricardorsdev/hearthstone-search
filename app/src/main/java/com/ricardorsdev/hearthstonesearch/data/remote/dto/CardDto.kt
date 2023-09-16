package com.ricardorsdev.hearthstonesearch.data.remote.dto

import com.ricardorsdev.hearthstonesearch.domain.model.Card

data class CardDto(
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

fun CardDto.toCard(): Card {
    return Card(
        attack = attack,
        battlegrounds = battlegrounds.toBattlegrounds(),
        cropImage = cropImage,
        health = health,
        id = id,
        image = image,
        manaCost = manaCost,
        minionTypeId = minionTypeId,
        name = name,
        text = text
    )
}