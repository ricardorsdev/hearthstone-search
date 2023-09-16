package com.ricardorsdev.hearthstonesearch.data.remote.dto

data class CardResponseDto(
    val cardCount: Int,
    val cards: List<CardDto>,
    val page: Int,
    val pageCount: Int
)