package com.ricardorsdev.hearthstonesearch.presentation.card_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ricardorsdev.hearthstonesearch.R
import com.ricardorsdev.hearthstonesearch.presentation.card_detail.component.rememberSwords
import com.ricardorsdev.hearthstonesearch.presentation.card_detail.component.rememberWaterDrop

@Composable
fun CardDetailScreen(
    viewModel: CardDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        when (state) {
            is CardDetailUiState.Success -> {
                state.card?.let { card ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Text(
                            modifier = Modifier.align(CenterHorizontally),
                            text = card.name,
                            style = MaterialTheme.typography.headlineMedium
                        )
                        AsyncImage(
                            model = card.cropImage,
                            contentDescription = stringResource(R.string.cropped_image),
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Divider()
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Icon(
                                Icons.Filled.Star,
                                contentDescription = stringResource(id = R.string.tavern_tier),
                                tint = Color.Yellow,
                                modifier = Modifier
                                    .height(20.dp)
                                    .width(20.dp)
                            )
                            Text(
                                text = "${card.battlegrounds.tier}",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.weight(1f)
                            )
                            Icon(
                                rememberSwords(),
                                contentDescription = stringResource(id = R.string.tavern_tier),
                                tint = Color.Yellow,
                                modifier = Modifier
                                    .height(20.dp)
                                    .width(20.dp)
                            )
                            Text(
                                text = "${card.attack}",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.weight(1f)
                            )
                            Icon(
                                rememberWaterDrop(),
                                contentDescription = stringResource(id = R.string.tavern_tier),
                                tint = Color.Red,
                                modifier = Modifier
                                    .height(20.dp)
                                    .width(20.dp)
                            )
                            Text(
                                text = "${card.health}",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.weight(1f)
                            )
                        }

                        Divider()
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = stringResource(id = R.string.card_effect) + HtmlCompat.fromHtml(
                                card.text,
                                HtmlCompat.FROM_HTML_MODE_COMPACT
                            ),
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Divider()

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min)
                        ) {
                            Column(
                                Modifier
                                    .weight(1f)
                                    .height(IntrinsicSize.Min)
                                    .padding(8.dp),
                                horizontalAlignment = CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(id = R.string.normal_version),
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.weight(1f)
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                AsyncImage(
                                    model = card.battlegrounds.image,
                                    contentDescription = stringResource(R.string.card_image),
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .height(120.dp)
                                        .width(80.dp)
                                )
                            }
                            Divider(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(1.dp)
                            )
                            Column(
                                Modifier
                                    .weight(1f)
                                    .height(IntrinsicSize.Min)
                                    .padding(8.dp),
                                horizontalAlignment = CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(id = R.string.golden_version),
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.weight(1f)
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                AsyncImage(
                                    model = card.battlegrounds.imageGold,
                                    contentDescription = stringResource(R.string.card_image),
                                    contentScale = ContentScale.FillBounds,
                                    alignment = Center,
                                    modifier = Modifier
                                        .height(120.dp)
                                        .width(80.dp)
                                )
                            }
                        }
                    }
                }
            }

            is CardDetailUiState.Error -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        text = state.error,
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Red,
                        textAlign = TextAlign.Center
                    )
                }
            }

            CardDetailUiState.Loading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}