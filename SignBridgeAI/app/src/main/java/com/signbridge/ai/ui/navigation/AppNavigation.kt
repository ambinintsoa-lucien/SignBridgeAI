package com.signbridge.ai.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.signbridge.ai.ui.components.PlaceholderScreen
import com.signbridge.ai.ui.components.SignBridgeBottomBar
import com.signbridge.ai.ui.components.bottomTabs

/**
 * Point d'entrée de l'interface : barre du bas + graphe de navigation.
 * La barre du bas n'apparaît que sur les 5 onglets principaux.
 */
@Composable
fun SignBridgeApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val routeActuelle = backStackEntry?.destination?.route
    val afficherBarre = bottomTabs.any { it.route == routeActuelle }

    Scaffold(
        bottomBar = {
            if (afficherBarre) {
                SignBridgeBottomBar(
                    routeActuelle = routeActuelle,
                    onTabClick = { route ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { padding ->
        SignBridgeNavHost(navController, Modifier.padding(padding))
    }
}

@Composable
private fun SignBridgeNavHost(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = Routes.DEMARRAGE,
        modifier = modifier
    ) {
        // --- Avant la connexion ---
        composable(Routes.DEMARRAGE) {
            PlaceholderScreen(
                "Démarrage",
                listOf(
                    "Commencer" to { navController.navigate(Routes.INSCRIPTION) },
                    "Se connecter" to { navController.navigate(Routes.CONNEXION) }
                )
            )
        }
        composable(Routes.CONNEXION) {
            PlaceholderScreen(
                "Connexion",
                listOf(
                    "Se connecter" to {
                        navController.navigate(Routes.ACCUEIL) {
                            popUpTo(Routes.DEMARRAGE) { inclusive = true }
                        }
                    },
                    "Créer un compte" to { navController.navigate(Routes.INSCRIPTION) }
                )
            )
        }
        composable(Routes.INSCRIPTION) {
            PlaceholderScreen(
                "Inscription",
                listOf(
                    "S'inscrire" to {
                        navController.navigate(Routes.ACCUEIL) {
                            popUpTo(Routes.DEMARRAGE) { inclusive = true }
                        }
                    }
                )
            )
        }

        // --- Onglets principaux ---
        composable(Routes.ACCUEIL) {
            PlaceholderScreen(
                "Accueil et fil d'actualité",
                listOf(
                    "Contacts" to { navController.navigate(Routes.CONTACTS) },
                    "Traduction LSM" to { navController.navigate(Routes.TRADUCTION_LSM) },
                    "Phrases rapides" to { navController.navigate(Routes.PHRASES_RAPIDES) },
                    "Dictionnaire LSM" to { navController.navigate(Routes.DICTIONNAIRE_LSM) },
                    "Mode SOS" to { navController.navigate(Routes.SOS) }
                )
            )
        }
        composable(Routes.DISCUSSIONS) {
            PlaceholderScreen(
                "Discussions",
                listOf("Ouvrir une conversation" to { navController.navigate(Routes.CONVERSATION) })
            )
        }
        composable(Routes.GROUPES) {
            PlaceholderScreen(
                "Groupes et communautés",
                listOf("Détail d'un groupe" to { navController.navigate(Routes.DETAIL_GROUPE) })
            )
        }
        composable(Routes.NOTIFICATIONS) { PlaceholderScreen("Notifications") }
        composable(Routes.PROFIL) {
            PlaceholderScreen(
                "Profil",
                listOf(
                    "Accessibilité" to { navController.navigate(Routes.PARAMS_ACCESSIBILITE) },
                    "Paramètres" to { navController.navigate(Routes.PARAMS_GENERAUX) }
                )
            )
        }

        // --- Écrans secondaires ---
        composable(Routes.CONTACTS) { PlaceholderScreen("Contacts et recherche d'amis") }
        composable(Routes.CONVERSATION) {
            PlaceholderScreen(
                "Conversation",
                listOf(
                    "Message vocal" to { navController.navigate(Routes.MESSAGE_VOCAL) },
                    "Appel vidéo" to { navController.navigate(Routes.APPEL_VIDEO) },
                    "Reconnaissance des signes" to { navController.navigate(Routes.RECONNAISSANCE_SIGNES) }
                )
            )
        }
        composable(Routes.MESSAGE_VOCAL) { PlaceholderScreen("Message vocal et transcription") }
        composable(Routes.TRADUCTION_LSM) { PlaceholderScreen("Traduction vers la LSM") }
        composable(Routes.APPEL_VIDEO) { PlaceholderScreen("Appel vidéo") }
        composable(Routes.RECONNAISSANCE_SIGNES) { PlaceholderScreen("Reconnaissance des signes") }
        composable(Routes.PARAMS_ACCESSIBILITE) { PlaceholderScreen("Paramètres d'accessibilité") }
        composable(Routes.PARAMS_GENERAUX) { PlaceholderScreen("Paramètres généraux") }
        composable(Routes.DETAIL_GROUPE) { PlaceholderScreen("Détail du groupe") }
        composable(Routes.DICTIONNAIRE_LSM) { PlaceholderScreen("Dictionnaire visuel LSM") }
        composable(Routes.PHRASES_RAPIDES) { PlaceholderScreen("Phrases rapides") }
        composable(Routes.SOS) { PlaceholderScreen("Mode SOS") }
    }
}
