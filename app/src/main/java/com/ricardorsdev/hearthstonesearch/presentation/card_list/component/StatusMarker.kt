package com.ricardorsdev.hearthstonesearch.presentation.card_list.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ricardorsdev.hearthstonesearch.R
import com.ricardorsdev.hearthstonesearch.presentation.card_detail.component.rememberSwords
import com.ricardorsdev.hearthstonesearch.presentation.model.StatusType

@Composable
fun StatusMarker(
    statusType: StatusType,
    value: Int
) {
    lateinit var icon: ImageVector
    lateinit var description: String
    var tint: Color = Color.Unspecified

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        when (statusType) {
            StatusType.TIER -> {
                icon = Icons.Filled.Star
                description = stringResource(id = R.string.tavern_tier)
                tint = Color.Yellow
            }

            StatusType.HEALTH -> {
                icon = rememberSwords()
                description = stringResource(id = R.string.minion_health)
                tint = Color.Yellow
            }

            StatusType.ATTACK -> {
                icon = Icons.Default.WaterDrop
                description = stringResource(id = R.string.minion_attack)
                tint = Color.Red
            }
        }

        Icon(
            icon,
            contentDescription = description,
            tint = tint,
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)
        )
        Text(
            text = "$value",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}