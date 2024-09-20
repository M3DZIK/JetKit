package dev.medzik.jetkit.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsEntry(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null
) = GroupBox(
    modifier = if (onClick != null) modifier.clickable(onClick = onClick) else modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (leading != null) {
            leading()

            Spacer(
                modifier = Modifier.size(12.dp)
            )
        }

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Title(title)

            if (subtitle != null) {
                Subtitle(subtitle)
            }
        }

        if (trailing != null) {
            trailing()
        }
    }
}

@Composable
fun SettingsSwitcherEntry(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    title: String,
    subtitle: String? = null,
    modifier: Modifier = Modifier,
    leading: @Composable (() -> Unit)? = null
) = SettingsEntry(
    title = title,
    subtitle = subtitle,
    modifier = modifier,
    leading = leading,
    trailing = {
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    },
    onClick = onCheckedChange?.let { { it(!checked) } }
)