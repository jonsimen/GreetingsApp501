package com.example.greetingsapp501

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.greetingsapp501.ui.theme.GreetingsApp501Theme
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.Calendar


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingsApp501Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NameGreeting()
                }
            }
        }
    }
}

@Composable
fun NameGreeting(){
    var name by remember {mutableStateOf("")}
    var name2 by remember {mutableStateOf("")}
    val currentHour = Calendar.HOUR_OF_DAY + 6

    Column (modifier=Modifier.fillMaxSize(),horizontalAlignment= Alignment.CenterHorizontally){
        TextField(
            value = name,
            onValueChange = {name = it},
            label = { Text("Type Name Here") },
        )
        Button (onClick = {
            name2 = if (currentHour <= 11) {
                "Good morning $name!"
            } else if (currentHour == 12){
                "It's high noon $name."
            } else if (currentHour <= 18){
                "Afternoon $name :)"
            } else {
                "Good night $name!"
            }
        })
        {Text("Click to display greeting")}
        Text(name2)

    }

}

