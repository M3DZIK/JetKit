package dev.medzik.jetkit.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun rememberBottomSheetState(
    sheetState: SheetState = SheetState(
        skipPartiallyExpanded = true,
        density = LocalDensity.current
    )
) = remember { BottomSheetState(sheetState) }

@ExperimentalMaterial3Api
class BottomSheetState(internal val sheetState: SheetState) {
    internal var visible by mutableStateOf(false)

    suspend fun hide() {
        sheetState.hide()
        visible = false
    }

    fun show() {
        visible = true
    }
}

@ExperimentalMaterial3Api
@Composable
fun BasicBottomSheet(
    state: BottomSheetState,
    onDismiss: () -> Unit,
    content: @Composable (ColumnScope.() -> Unit)
) {
    if (state.visible) {
        ModalBottomSheet(
            onDismissRequest = {
                state.visible = false
                onDismiss()
            },
            sheetState = state.sheetState
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                content()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun <T> PickerBottomSheet(
    state: BottomSheetState,
    items: Iterable<T>,
    onSelect: (T) -> Unit,
    onDismiss: () -> Unit,
    content: @Composable ((T) -> Unit)
) = BasicBottomSheet(
    state = state,
    onDismiss = onDismiss,
    content = {
        val scope = rememberCoroutineScope()

        LazyColumn {
            items.forEach { item ->
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                scope
                                    .launch { state.hide() }
                                    .invokeOnCompletion {
                                        if (!state.sheetState.isVisible) {
                                            onSelect(item)
                                        }
                                    }
                            }
                    ) {
                        Row(
                            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp)
                        ) {
                            content(item)
                        }
                    }
                }
            }
        }
    }
)
