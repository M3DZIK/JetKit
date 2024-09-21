
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.medzik.jetkit.ui.GroupBox
import dev.medzik.jetkit.ui.LazySettingsGroup
import dev.medzik.jetkit.ui.SettingsEntry
import dev.medzik.jetkit.ui.SettingsSwitcherEntry
import dev.medzik.jetkit.ui.Subtitle
import dev.medzik.jetkit.ui.Title
import ui.theme.AppTheme

@Composable
fun App() {
    var darkTheme by remember { mutableStateOf(false) }

    AppTheme(
        darkTheme = darkTheme
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "Theme Switcher",
                    style = MaterialTheme.typography.titleLarge
                )

                Switch(
                    checked = darkTheme,
                    onCheckedChange = { darkTheme = it }
                )
            }

            item {
                ColorExample()
            }

            item {
                Text(
                    text = "GroupBox",
                    style = MaterialTheme.typography.titleLarge
                )

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
                }
            }

            item {
                Text(
                    text = "Lazy Settings Group",
                    style = MaterialTheme.typography.titleLarge
                )

                Box(
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    var checked1 by remember { mutableStateOf(true) }
                    var checked2 by remember { mutableStateOf(true) }
                    var checked3 by remember { mutableStateOf(true) }
                    var checked4 by remember { mutableStateOf(true) }

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

                        entry(
                            title = "Some title",
                            subtitle = "Some description"
                        )
                    }
                }
            }
        }
    }
}
