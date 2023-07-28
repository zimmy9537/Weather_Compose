package com.zimmy.sample.weather_compose.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zimmy.sample.weather_compose.R

@Composable
fun TopHeader(
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFFD3D3D3),
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            CreativeTextEditField(
                text = searchQuery,
                onTextChange = { searchQuery = it },
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Gray)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = Color.Gray,
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun CreativeTextEditField(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var isFocused by remember { mutableStateOf(false) }
    var isHintVisible by remember { mutableStateOf(text.isEmpty()) }

    LaunchedEffect(text) {
        isHintVisible = text.isEmpty()
    }

    Surface(
        modifier = modifier.background(Color.Transparent)
    ) {
        BasicTextField(
            value = text,
            onValueChange = onTextChange,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { isFocused = false }
            ),
            textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 20.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .graphicsLayer {
                    translationY = if (isFocused) (-4).dp.toPx() else 0f
                }
                .background(Color.Transparent)
                .onFocusChanged { isFocused = it.isFocused }
        )
        if (isHintVisible) {
            Text(
                text = "Search Location",
                color = Color.Gray,
                modifier = Modifier
                    .padding(16.dp)
                    .graphicsLayer {
                        alpha = if (isHintVisible) 1f else 0f
                    }
                    .background(Color.Transparent)
            )
        }
    }
}

@Preview("Fill Preview", showBackground = true)
@Composable
fun TopHeaderPreview() {
    TopHeader()
}