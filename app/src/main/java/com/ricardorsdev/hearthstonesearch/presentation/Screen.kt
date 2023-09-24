package com.ricardorsdev.hearthstonesearch.presentation


sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object HeroListScreen: Screen("hero_list_screen")
    object CardListScreen: Screen("card_list_screen")
    object CardDetailScreen: Screen("card_detail_screen")
}