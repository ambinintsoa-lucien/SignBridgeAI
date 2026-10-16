package com.signbridge.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.signbridge.ai.ui.navigation.SignBridgeApp
import com.signbridge.ai.ui.theme.SignBridgeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignBridgeTheme {
                SignBridgeApp()
            }
        }
    }
}
