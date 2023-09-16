package com.ricardorsdev.hearthstonesearch.domain.model

data class Battlegrounds (
    val hero: Boolean,
    val image: String,
    val quest: Boolean,
    val reward: Boolean,
    val tier: Int,
)
