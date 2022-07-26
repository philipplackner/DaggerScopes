package com.plcoding.daggerscopes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.plcoding.daggerscopes.ui.theme.DaggerScopesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerScopesTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "start_destination") {
                    navigation(
                        startDestination = "video_call_screen",
                        route = "video_graph"
                    ) {
                        composable("video_call_screen") { backStackEntry ->
                            val parentEntry = remember(backStackEntry) {
                                navController.getBackStackEntry("video_graph")
                            }
                            val viewModel = hiltViewModel<SessionViewModel>(parentEntry)
                        }
                        composable("call_info_screen") { backStackEntry ->
                            val parentEntry = remember(backStackEntry) {
                                navController.getBackStackEntry("video_graph")
                            }
                            val viewModel = hiltViewModel<SessionViewModel>(parentEntry)
                        }
                    }
                }
            }
        }
    }
}