package com.zimmy.sample.weather_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.zimmy.sample.weather_compose.ui.theme.Weather_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Weather_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column {
        TopHeader()
    }
}

@Composable
fun TopHeader(modifier: Modifier = Modifier.fillMaxWidth()) {
    var searchQuery by remember { mutableStateOf("") }
    Row(modifier = modifier.fillMaxWidth()) {
        BasicTextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
            },
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(color = Color.Black),
        )
        Spacer(modifier = modifier)
        Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Weather_ComposeTheme {
        MainScreen()
    }
}