package com.ricardorsdev.hearthstonesearch.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ricardorsdev.hearthstonesearch.presentation.card_list.CardListScreen
import com.ricardorsdev.hearthstonesearch.presentation.card_list.CardListViewModel
import com.ricardorsdev.hearthstonesearch.presentation.ui.theme.HearthstoneSearchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CardListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HearthstoneSearchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CardListScreen.route
                    ) {
                        composable(
                            route = Screen.CardListScreen.route
                        ) {
                            CardListScreen(navController)
                        }
                    }
                }
            }
        }

        //TODO: remove it after validation
        viewModel
    }
}
