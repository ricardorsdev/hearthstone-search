package com.ricardorsdev.hearthstonesearch.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ricardorsdev.hearthstonesearch.presentation.card_detail.CardDetailScreen
import com.ricardorsdev.hearthstonesearch.presentation.card_list.CardListScreen
import com.ricardorsdev.hearthstonesearch.presentation.hero_list.HeroListScreen
import com.ricardorsdev.hearthstonesearch.presentation.home.HomeScreen
import com.ricardorsdev.hearthstonesearch.presentation.ui.theme.HearthstoneSearchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(
                            route = Screen.HomeScreen.route
                        ) {
                            HomeScreen(navController)
                        }
                        composable(
                            route = Screen.HeroListScreen.route
                        ) {
                            HeroListScreen(navController)
                        }
                        composable(
                            route = Screen.CardListScreen.route
                        ) {
                            CardListScreen(navController)
                        }
                        composable(
                            route = Screen.CardDetailScreen.route + "/{cardId}"
                        ) {
                            CardDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
