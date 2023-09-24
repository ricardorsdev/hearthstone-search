package com.ricardorsdev.hearthstonesearch.presentation.card_list.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ricardorsdev.hearthstonesearch.presentation.model.StatusType

@Composable
fun CardStatusBar(
    tier: Int,
    health: Int,
    attack: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StatusMarker(statusType = StatusType.TIER, value = tier)
        StatusMarker(statusType = StatusType.HEALTH, value = health)
        StatusMarker(statusType = StatusType.ATTACK, value = attack)
    }
}