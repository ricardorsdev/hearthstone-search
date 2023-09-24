package com.ricardorsdev.hearthstonesearch.presentation.hero_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ricardorsdev.hearthstonesearch.R
import com.ricardorsdev.hearthstonesearch.domain.model.Card

@Composable
fun HeroListItem(
    hero: Card,
    onItemClick: (Card) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(hero) }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = hero.image,
            contentDescription = stringResource(R.string.card_image),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(120.dp)
                .width(80.dp)
        )
        Text(
            text = hero.name,
            style = MaterialTheme.typography.titleLarge,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}