package com.signbridge.ai.ui.navigation

/**
 * Liste de toutes les destinations de l'application.
 * Chaque écran a un nom unique (la "route") utilisé par la navigation.
 */
object Routes {
    // Avant la connexion
    const val DEMARRAGE = "demarrage"
    const val CONNEXION = "connexion"
    const val INSCRIPTION = "inscription"

    // Onglets principaux (barre du bas)
    const val ACCUEIL = "accueil"
    const val DISCUSSIONS = "discussions"
    const val GROUPES = "groupes"
    const val NOTIFICATIONS = "notifications"
    const val PROFIL = "profil"

    // Écrans secondaires
    const val CONTACTS = "contacts"
    const val CONVERSATION = "conversation"
    const val MESSAGE_VOCAL = "message_vocal"
    const val TRADUCTION_LSM = "traduction_lsm"
    const val APPEL_VIDEO = "appel_video"
    const val RECONNAISSANCE_SIGNES = "reconnaissance_signes"
    const val PARAMS_ACCESSIBILITE = "params_accessibilite"
    const val PARAMS_GENERAUX = "params_generaux"
    const val DETAIL_GROUPE = "detail_groupe"
    const val DICTIONNAIRE_LSM = "dictionnaire_lsm"
    const val PHRASES_RAPIDES = "phrases_rapides"
    const val SOS = "sos"
}
