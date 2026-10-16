package com.signbridge.ai.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.signbridge.ai.ui.navigation.Routes

/** Un onglet de la barre de navigation du bas. */
data class BottomTab(
    val route: String,
    val libelle: String,
    val icone: ImageVector
)

/** Les 5 onglets principaux, dans le même ordre que les maquettes. */
val bottomTabs = listOf(
    BottomTab(Routes.ACCUEIL, "Accueil", Icons.Outlined.Home),
    BottomTab(Routes.DISCUSSIONS, "Discussions", Icons.Outlined.ChatBubbleOutline),
    BottomTab(Routes.GROUPES, "Groupes", Icons.Outlined.Groups),
    BottomTab(Routes.NOTIFICATIONS, "Notifications", Icons.Outlined.Notifications),
    BottomTab(Routes.PROFIL, "Profil", Icons.Outlined.Person)
)

@Composable
fun SignBridgeBottomBar(
    routeActuelle: String?,
    onTabClick: (String) -> Unit
) {
    NavigationBar {
        bottomTabs.forEach { tab ->
            NavigationBarItem(
                selected = routeActuelle == tab.route,
                onClick = { onTabClick(tab.route) },
                icon = { Icon(tab.icone, contentDescription = tab.libelle) },
                label = { Text(tab.libelle) }
            )
        }
    }
}
