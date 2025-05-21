package com.dinoy.forkcast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dinoy.forkcast.navigation.MainNavigation
import com.dinoy.forkcast.ui.theme.ForkCastTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            ForkCastTheme(darkTheme = false) {
                MainNavigation()
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(
        text = "Building something new",
        modifier = modifier,
        color = Color.LightGray
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ForkCastTheme {
        Greeting()
    }
}