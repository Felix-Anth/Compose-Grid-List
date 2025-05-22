package com.example.gridlistapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.gridlistapp.model.ListItemData
import com.example.gridlistapp.ui.components.GridView
import com.example.gridlistapp.ui.components.ListView

enum class ViewType {
    GRID,
    LIST
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(items: List<ListItemData>) {
    var currentViewType by remember { mutableStateOf(ViewType.LIST) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Grid/List App") },
                actions = {
                    if (currentViewType == ViewType.LIST) {
                        IconButton(
                            onClick = { currentViewType = ViewType.GRID },
                            modifier = Modifier.testTag("grid_view_button")
                        ) {
                            Icon(Icons.Filled.GridView, contentDescription = "Switch to Grid View")
                        }
                    } else {
                        IconButton(
                            onClick = { currentViewType = ViewType.LIST },
                            modifier = Modifier.testTag("list_view_button")
                        ) {
                            Icon(Icons.Filled.ViewList, contentDescription = "Switch to List View")
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (currentViewType) {
                ViewType.GRID -> GridView(items = items, modifier = Modifier.testTag("grid_view"))
                ViewType.LIST -> ListView(items = items, modifier = Modifier.testTag("list_view"))
            }
        }
    }
}
