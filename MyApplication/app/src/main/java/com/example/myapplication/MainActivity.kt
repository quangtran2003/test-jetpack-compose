@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyApp()
//        }
//    }
private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserListScreen(viewModel = viewModel)
        }
    }
}

@Composable
fun MyApp(){
    val navCtrl= rememberNavController()
    NavHost(navCtrl,"first_screen"){
        composable("first_screen"){FirstScreen(navCtrl)}
        composable("second_screen"){SecondScreen(navCtrl)}

    }
}
@Composable
fun FirstScreen(navController: NavController){
    Scaffold (
        topBar = {
            TopAppBar(title = {Text("first screen") })
        },
        content ={
        padding ->
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                ) {
                Button(onClick = {
                    navController.navigate("second_screen")
                }) {
                    Text( text = "Go to second screen")
                }
                Button(onClick = {
                    navController.navigate("second_screen")
                }) {
                    Text( text = "Go to second screen")
                }
                Button(onClick = {
                    navController.navigate("second_screen")
                }) {
                    Text( text = "Go to second screen")
                }
            }
        }
    )
}
@Composable
fun SecondScreen(navController:NavController){
    Scaffold (
        topBar = {
            TopAppBar(title = {Text(text = "second screen") })
        },
        content = {
            padding->
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize().padding(padding)
            ) {
                Button(onClick = {
                    navController.popBackStack()
                }) {
                    Text(text = "Go back")
                }
            }
        }
    )
}