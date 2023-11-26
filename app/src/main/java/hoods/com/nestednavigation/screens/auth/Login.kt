package hoods.com.nestednavigation.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(onLogin: () -> Unit, onSignUp: () -> Unit, onForgotPassword: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Login Screen")
        Row {
            Button(onClick = onLogin) {
                Text("Login")
            }
            Spacer(modifier = Modifier.Companion.size(4.dp))
            Button(onClick = onSignUp) {
                Text("SignUp")
            }
            Spacer(modifier = Modifier.Companion.size(4.dp))
            Button(onClick = onForgotPassword) {
                Text("ForgotPassword")
            }
        }
    }
}