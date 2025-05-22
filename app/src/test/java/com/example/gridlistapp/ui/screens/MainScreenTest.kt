package com.example.gridlistapp.ui.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.gridlistapp.R
import com.example.gridlistapp.model.ListItemData
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE, sdk = [33]) // Configure Robolectric for Compose tests
class MainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val sampleItems = (1..3).map {
        ListItemData(
            id = it,
            title = "Item $it",
            imageRes = R.drawable.ic_placeholder // Using actual drawable for test
        )
    }

    @Test
    fun mainScreen_initialState_showsListView() {
        composeTestRule.setContent {
            MainScreen(items = sampleItems)
        }

        composeTestRule.onNodeWithTag("list_view").assertIsDisplayed()
        composeTestRule.onNodeWithTag("grid_view").assertDoesNotExist()
    }

    @Test
    fun mainScreen_clickGridViewButton_showsGridView() {
        composeTestRule.setContent {
            MainScreen(items = sampleItems)
        }

        // Initial state: List view should be displayed
        composeTestRule.onNodeWithTag("list_view").assertIsDisplayed()
        composeTestRule.onNodeWithTag("grid_view_button").assertIsDisplayed() // Grid view button should be present

        // Click on the grid view button
        composeTestRule.onNodeWithTag("grid_view_button").performClick()

        // After click: Grid view should be displayed
        composeTestRule.onNodeWithTag("grid_view").assertIsDisplayed()
        composeTestRule.onNodeWithTag("list_view").assertDoesNotExist()
        composeTestRule.onNodeWithTag("list_view_button").assertIsDisplayed() // List view button should now be present
    }

    @Test
    fun mainScreen_clickListViewButton_showsListView() {
        composeTestRule.setContent {
            MainScreen(items = sampleItems)
        }

        // First, switch to GridView
        composeTestRule.onNodeWithTag("grid_view_button").performClick()
        composeTestRule.onNodeWithTag("grid_view").assertIsDisplayed() // Ensure grid view is shown
        composeTestRule.onNodeWithTag("list_view_button").assertIsDisplayed() // List view button should be present

        // Click on the list view button
        composeTestRule.onNodeWithTag("list_view_button").performClick()

        // After click: List view should be displayed
        composeTestRule.onNodeWithTag("list_view").assertIsDisplayed()
        composeTestRule.onNodeWithTag("grid_view").assertDoesNotExist()
        composeTestRule.onNodeWithTag("grid_view_button").assertIsDisplayed() // Grid view button should now be present
    }
}
