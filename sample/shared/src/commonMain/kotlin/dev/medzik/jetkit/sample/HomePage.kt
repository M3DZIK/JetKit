package dev.medzik.jetkit.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.medzik.jetkit.theme.DisabledComponentAlpha
import dev.medzik.jetkit.theme.combineAlpha
import dev.medzik.jetkit.theme.info
import dev.medzik.jetkit.theme.infoContainer
import dev.medzik.jetkit.theme.ok
import dev.medzik.jetkit.theme.okContainer
import dev.medzik.jetkit.theme.onInfoContainer
import dev.medzik.jetkit.theme.onOkContainer
import dev.medzik.jetkit.theme.onWarningContainer
import dev.medzik.jetkit.theme.warning
import dev.medzik.jetkit.theme.warningContainer
import dev.medzik.jetkit.ui.BasicBottomSheet
import dev.medzik.jetkit.ui.ExpandedContent
import dev.medzik.jetkit.ui.ExpandedContentRow
import dev.medzik.jetkit.ui.GroupBox
import dev.medzik.jetkit.ui.LazySettingsGroup
import dev.medzik.jetkit.ui.LoadingButton
import dev.medzik.jetkit.ui.LoadingOutlinedButton
import dev.medzik.jetkit.ui.PickerBottomSheet
import dev.medzik.jetkit.ui.SettingsCheckboxEntry
import dev.medzik.jetkit.ui.SettingsEntry
import dev.medzik.jetkit.ui.SettingsSwitcherEntry
import dev.medzik.jetkit.ui.Subtitle
import dev.medzik.jetkit.ui.Title
import dev.medzik.jetkit.ui.rememberBottomSheetState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(innerPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        homePageColors()

        item {
            Text(
                text = "GroupBox",
                style = MaterialTheme.typography.titleLarge
            )
        }
        item {
            GroupBox(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )

                    Spacer(
                        modifier = Modifier.size(12.dp)
                    )

                    Column {
                        Title("Account")
                        Subtitle("Manage your account")
                    }
                }
            }
        }

        item {
            Text(
                text = "Settings",
                style = MaterialTheme.typography.titleLarge
            )
        }
        item {
            Column(
                modifier = Modifier.padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SettingsEntry(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Settings",
                    subtitle = "Manage application settings",
                    leading = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = null
                        )
                    },
                    trailing = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null
                        )
                    }
                )

                var checked by remember { mutableStateOf(false) }

                SettingsSwitcherEntry(
                    modifier = Modifier.fillMaxWidth(),
                    checked = checked,
                    onCheckedChange = { checked = it },
                    title = "Switcher",
                    subtitle = "Enable/Disable somethings",
                    leading = {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null
                        )
                    }
                )

                SettingsCheckboxEntry(
                    modifier = Modifier.fillMaxWidth(),
                    checked = checked,
                    onCheckedChange = { checked = it },
                    title = "Checkbox",
                    subtitle = "Enable/Disable somethings",
                    leading = {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null
                        )
                    }
                )
            }
        }

        item {
            Text(
                text = "Lazy Settings Group",
                style = MaterialTheme.typography.titleLarge
            )
        }
        item {
            Box(
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                var checked1 by remember { mutableStateOf(true) }
                var checked2 by remember { mutableStateOf(true) }
                var checked3 by remember { mutableStateOf(true) }
                var checked4 by remember { mutableStateOf(true) }
                var checked5 by remember { mutableStateOf(true) }

                LazySettingsGroup {
                    switcher(
                        checked = checked1,
                        onCheckedChange = { checked1 = it },
                        title = "Switcher",
                        subtitle = "Enable/Disable somethings"
                    )

                    switcher(
                        checked = checked2,
                        onCheckedChange = { checked2 = it },
                        title = "Switcher",
                        subtitle = "Enable/Disable somethings"
                    )

                    switcher(
                        checked = checked3,
                        onCheckedChange = { checked3 = it },
                        title = "Switcher",
                        subtitle = "Enable/Disable somethings"
                    )

                    switcher(
                        checked = checked4,
                        onCheckedChange = { checked4 = it },
                        title = "Switcher",
                        subtitle = "Enable/Disable somethings"
                    )

                    checkbox(
                        checked = checked5,
                        onCheckedChange = { checked5 = it },
                        title = "Checkbox",
                        subtitle = "Enable/Disable somethings"
                    )

                    entry(
                        title = "Some title",
                        subtitle = "Some description"
                    )
                }
            }
        }

        item {
            Text(
                text = "Bottom Sheet",
                style = MaterialTheme.typography.titleLarge
            )
        }
        item {
            val firstDialogState = rememberBottomSheetState()

            Button(
                onClick = { firstDialogState.show() }
            ) {
                Text("Show Basic")
            }

            BasicBottomSheet(
                state = firstDialogState,
                onDismiss = {  }
            ) {
                Text("Some text")
            }

            val secondaryDialogState = rememberBottomSheetState()

            val items = listOf("Item 1", "Item 2", "Item 3")
            val selectedItem = remember { mutableStateOf("Item 1") }

            Button(
                onClick = { secondaryDialogState.show() }
            ) {
                Text("Show Picker")
            }

            PickerBottomSheet(
                state = secondaryDialogState,
                items = items,
                onDismiss = {},
                onSelect = { selectedItem.value = it }
            ) {
                Text(it)
            }
        }

        item {
            Text(
                text = "Loading Button",
                style = MaterialTheme.typography.titleLarge
            )
        }
        item {
            var loading by remember { mutableStateOf(false) }

            LoadingButton(
                loading = loading,
                onClick = { loading = !loading }
            ) {
                Text("Log in")
            }

            Spacer(
                modifier = Modifier.size(8.dp)
            )

            LoadingOutlinedButton(
                loading = loading,
                onClick = { loading = !loading }
            ) {
                Text("Log in")
            }
        }

        item {
            Text(
                text = "Expand",
                style = MaterialTheme.typography.titleLarge
            )
        }
        item {
            var expandColumn by remember { mutableStateOf(false) }

            Button(
                onClick = { expandColumn = !expandColumn }
            ) {
                Text("Expand Column")
            }

            ExpandedContent(
                expand = expandColumn
            ) {
                Text("Some data to expand")
            }

            var expandRow by remember { mutableStateOf(false) }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { expandRow = !expandRow }
                ) {
                    Text("Expand Row")
                }

                ExpandedContentRow(
                    expand = expandRow
                ) {
                    Text("Some data to expand")
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.homePageColors() {
    item {
        Text(
            text = "Alpha",
            style = MaterialTheme.typography.titleLarge
        )
    }
    item {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.width(120.dp)
            ) {
                Text(
                    text = "Normal",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(12.dp),
                    textAlign = TextAlign.Center
                )
            }

            Surface(
                color = MaterialTheme.colorScheme.primaryContainer.combineAlpha(
                    DisabledComponentAlpha
                ),
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.width(120.dp)
            ) {
                Text(
                    text = "Disabled",
                    color = MaterialTheme.colorScheme.onPrimaryContainer.combineAlpha(
                        DisabledComponentAlpha
                    ),
                    modifier = Modifier.padding(12.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
    item {
        Text(
            text = "Colors",
            style = MaterialTheme.typography.titleLarge
        )
    }
    item {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.width(120.dp)
            ) {
                Text(
                    text = "Primary",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(12.dp),
                    textAlign = TextAlign.Center
                )
            }

            Surface(
                color = MaterialTheme.colorScheme.warningContainer,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.width(120.dp)
            ) {
                Text(
                    text = "Warning",
                    color = MaterialTheme.colorScheme.onWarningContainer,
                    modifier = Modifier.padding(12.dp),
                    textAlign = TextAlign.Center
                )
            }

            Surface(
                color = MaterialTheme.colorScheme.infoContainer,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.width(120.dp)
            ) {
                Text(
                    text = "Info",
                    color = MaterialTheme.colorScheme.onInfoContainer,
                    modifier = Modifier.padding(12.dp),
                    textAlign = TextAlign.Center
                )
            }

            Surface(
                color = MaterialTheme.colorScheme.okContainer,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.width(120.dp)
            ) {
                Text(
                    text = "Ok",
                    color = MaterialTheme.colorScheme.onOkContainer,
                    modifier = Modifier.padding(12.dp),
                    textAlign = TextAlign.Center
                )
            }

            Surface(
                color = MaterialTheme.colorScheme.errorContainer,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.width(120.dp)
            ) {
                Text(
                    text = "Error",
                    color = MaterialTheme.colorScheme.onErrorContainer,
                    modifier = Modifier.padding(12.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }

    item {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = "Primary",
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "Warning",
                color = MaterialTheme.colorScheme.warning
            )

            Text(
                text = "Info",
                color = MaterialTheme.colorScheme.info
            )

            Text(
                text = "Okay",
                color = MaterialTheme.colorScheme.ok
            )

            Text(
                text = "Error",
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}
