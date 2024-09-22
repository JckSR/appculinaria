package com.example.appculinaria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.appculinaria.feature_culinaria.presentation._detailproduct.DetailScreen
import com.example.appculinaria.feature_culinaria.presentation._detailproduct.components.DetailDescriptor
import com.example.appculinaria.feature_culinaria.presentation.productlist.MealListScreen
import com.example.appculinaria.feature_culinaria.presentation.util.Screens
import com.example.appculinaria.ui.theme.AppCulinariaTheme
import com.example.appculinaria.ui.theme.black
import dagger.hilt.android.AndroidEntryPoint
import okio.blackholeSink


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCulinariaTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = black){
                    val navController = rememberNavController()

                  NavHost(navController = navController, startDestination = Screens.MealListScreen.route) {
                      composable(Screens.MealListScreen.route){
                          MealListScreen(
                              onMealClick = {
                                  navController.navigate(
                                      "DETAIL/${it.id}"
                                  )

                              }
                          )


                      }
                      composable(
                          Screens.DetailScreen.route,
                          arguments = listOf(
                              navArgument("meal_id"){
                                  type = NavType.StringType
                              }
                          )
                      ){
                          DetailScreen(onBack = {
                              navController.popBackStack()
                          })

                      }
                  }
                }
            }
        }
    }
}

