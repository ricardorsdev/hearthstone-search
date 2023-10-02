package com.ricardorsdev.hearthstonesearch.presentation.card_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import com.ricardorsdev.hearthstonesearch.R
import com.ricardorsdev.hearthstonesearch.presentation.model.CardVersion

@Composable
fun CardExhibition(
    cardVersion: CardVersion,
    imageUrl: String
) {
    val title = when (cardVersion) {
        CardVersion.NORMAL -> stringResource(id = R.string.normal_version)
        CardVersion.GOLDEN -> stringResource(id = R.string.golden_version)
    }

    var cardInFullScreen by remember { mutableStateOf(false) }

    Column(
        Modifier
            .height(IntrinsicSize.Min)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            model = imageUrl,
            contentDescription = stringResource(R.string.card_image),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(120.dp)
                .width(80.dp)
                .clickable {
                    cardInFullScreen = !cardInFullScreen
                }
        )
    }

    if (cardInFullScreen) {
        Dialog(
            properties = DialogProperties(usePlatformDefaultWidth = false),
            onDismissRequest = { }
        ) {
            Surface(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = stringResource(R.string.card_image),
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { cardInFullScreen = !cardInFullScreen }
                )
            }
        }
    }
}