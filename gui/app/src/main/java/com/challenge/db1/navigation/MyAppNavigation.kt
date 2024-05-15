package com.challenge.db1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.challenge.db1.screens.FormLogin
import com.challenge.db1.screens.SignUp

@Composable
fun MyAppNavigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login",){
            FormLogin(navController = navController)
        }

        composable("signup",){
            SignUp(navController = navController)
        }
    } )
}