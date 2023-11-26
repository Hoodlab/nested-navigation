package hoods.com.nestednavigation.screens.home

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
fun HomeScreen(onNavigateToScreenOne: () -> Unit, onNavigateToScreenTwo: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Home Screen")
        Row {
            Button(onClick = onNavigateToScreenOne) {
                Text("Navigate Screen One")
            }
            Spacer(modifier = Modifier.Companion.size(4.dp))
            Button(onClick = onNavigateToScreenTwo) {
                Text("Navigate Screen Two")
            }
        }
    }
}