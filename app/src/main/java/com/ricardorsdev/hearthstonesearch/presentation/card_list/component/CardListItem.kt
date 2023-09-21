package com.ricardorsdev.hearthstonesearch.presentation.card_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ricardorsdev.hearthstonesearch.R
import com.ricardorsdev.hearthstonesearch.domain.model.Card

@Composable
fun CardListItem(
    card: Card,
    onItemClick: (Card) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(card) }
            .padding(16.dp)
    ) {
        AsyncImage(
            model = card.image,
            contentDescription = stringResource(R.string.card_image),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(120.dp)
                .width(80.dp)
        )
        Column(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .align(Alignment.CenterVertically)
                .fillMaxHeight()
                .padding(4.dp)
        ) {
            Text(
                text = card.name,
                style = MaterialTheme.typography.titleLarge,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = stringResource(id = R.string.tavern_tier),
                    tint = Color.Yellow
                )
                Text(
                    text = "${card.battlegrounds.tier} ",
                    style = MaterialTheme.typography.bodyLarge,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}