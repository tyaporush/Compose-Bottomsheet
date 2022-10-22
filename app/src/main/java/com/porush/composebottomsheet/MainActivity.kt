package com.porush.composebottomsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.porush.composebottomsheet.ui.theme.ComposeBottomsheetTheme
import com.porush.composebottomsheet.ui.theme.component.BottomSheet

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBottomsheetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Cyan
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    var isSheetOpen by remember {
        mutableStateOf(false)
    }
    Button(onClick = {
        isSheetOpen = !isSheetOpen
    }, modifier = Modifier.wrapContentSize()) {
        Text(text = if (isSheetOpen) "Close BottomSheet" else "Open BottomSheet")
    }

    BottomSheet(expanded = isSheetOpen)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBottomsheetTheme {

    }
}