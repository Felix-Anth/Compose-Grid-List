package com.example.gridlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gridlistapp.R
import com.example.gridlistapp.model.ListItemData
import com.example.gridlistapp.ui.screens.MainScreen
import com.example.gridlistapp.ui.theme.GridListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridListAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val sampleItems = (1..15).map {
                        ListItemData(
                            id = it,
                            title = "Item $it",
                            imageRes = R.drawable.ic_placeholder
                        )
                    }
                    MainScreen(items = sampleItems)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridListAppTheme {
        val sampleItems = (1..5).map {
            ListItemData(
                id = it,
                title = "Item $it",
                imageRes = R.drawable.ic_placeholder
            )
        }
        MainScreen(items = sampleItems)
    }
}
