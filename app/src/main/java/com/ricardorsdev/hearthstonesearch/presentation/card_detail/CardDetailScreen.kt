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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.ricardorsdev.hearthstonesearch.R
import com.ricardorsdev.hearthstonesearch.presentation.card_list.component.CardDetailHeader
import com.ricardorsdev.hearthstonesearch.presentation.card_list.component.CardExhibition
import com.ricardorsdev.hearthstonesearch.presentation.card_list.component.CardStatusBar
import com.ricardorsdev.hearthstonesearch.presentation.model.CardVersion

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
                    ) {
                        CardDetailHeader(title = card.name, imageUrl = card.cropImage)
                        Divider()

                        CardStatusBar(
                            tier = card.battlegrounds.tier,
                            health = card.health,
                            attack = card.attack
                        )
                        Divider()

                        Column(
                            modifier = Modifier
                                .height(IntrinsicSize.Min)
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "${stringResource(id = R.string.card_effect)}: ${
                                    HtmlCompat.fromHtml(
                                        card.text,
                                        HtmlCompat.FROM_HTML_MODE_COMPACT
                                    )
                                }",
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Spacer(modifier = Modifier.height(16.dp))
                            Divider()

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(IntrinsicSize.Min),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                CardExhibition(
                                    cardVersion = CardVersion.NORMAL,
                                    imageUrl = card.battlegrounds.image
                                )
                                Divider(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(1.dp)
                                )
                                CardExhibition(
                                    cardVersion = CardVersion.GOLDEN,
                                    imageUrl = card.battlegrounds.imageGold
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