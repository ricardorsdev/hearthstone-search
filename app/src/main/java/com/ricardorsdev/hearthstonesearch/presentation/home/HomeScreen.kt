package com.ricardorsdev.hearthstonesearch.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ricardorsdev.hearthstonesearch.R
import com.ricardorsdev.hearthstonesearch.presentation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            modifier = Modifier.padding(8.dp)
        )
    }, content = {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ElevatedButton(onClick = { navController.navigate(Screen.HeroListScreen.route) }) {
                    Text(
                        text = stringResource(id = R.string.heroes),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                ElevatedButton(onClick = { navController.navigate(Screen.CardListScreen.route) }) {
                    Text(
                        text = stringResource(id = R.string.cards),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    })
}