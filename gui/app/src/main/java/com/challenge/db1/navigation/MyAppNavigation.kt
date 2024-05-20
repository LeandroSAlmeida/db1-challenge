package com.challenge.db1.navigation

import DashboardScreen
import ProfileScreen
import SkillsScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.challenge.db1.domain.AlunoEProfessor
import com.challenge.db1.screens.ForgotPasswordScreen
import com.challenge.db1.screens.FormLogin
import com.challenge.db1.screens.RegistrationSuccessScreen
import com.challenge.db1.screens.SignUp
import com.google.gson.Gson

@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            FormLogin(navController = navController)
        }
        composable("signup") {
            SignUp(navController = navController)
        }
        composable("skills") {
            SkillsScreen(navController = navController)
        }
        composable("forgotpassword") {
            ForgotPasswordScreen(navController = navController)
        }
        composable("successful") {
            RegistrationSuccessScreen(navController = navController)
        }
        composable("dashboard") {
            DashboardScreen(navController = navController)
        }
        composable(
            route = "profile/{alunoEProfessorJson}",
            arguments = listOf(navArgument("alunoEProfessorJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val alunoEProfessorJson = backStackEntry.arguments?.getString("alunoEProfessorJson")
            val alunoEProfessor = Gson().fromJson(alunoEProfessorJson, AlunoEProfessor::class.java)
            ProfileScreen(alunoEProfessor = alunoEProfessor, navController = navController)
        }
    }
}
