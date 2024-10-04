package com.rezekoard.roomdatabase_apps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rezekoard.roomdatabase_apps.presentation.AddNoteScreen
import com.rezekoard.roomdatabase_apps.presentation.NoteViewModel
import com.rezekoard.roomdatabase_apps.presentation.NotesScreen
import com.rezekoard.roomdatabase_apps.ui.theme.RoomDatabaseappsTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDatabaseappsTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = hiltViewModel<NoteViewModel>()

                    val state by viewModel.state.collectAsState()
                    val navController = rememberNavController()
                    
                    NavHost(
                        navController = navController,
                        startDestination = "NotesScreen"
                    ) {
                        composable("NotesScreen"){
                            NotesScreen(
                                state = state,
                                navController = navController,
                                onEvent = viewModel::onEvent
                            )
                        }
                        composable("AddNoteScreen"){
                            AddNoteScreen(
                                state = state,
                                navController = navController,
                                onEvent = viewModel::onEvent
                            )
                        }

                    }


                }
            }
        }
    }
}