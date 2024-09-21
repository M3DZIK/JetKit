package dev.medzik.jetkit.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun SettingsEntry(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
    shape: Shape = GroupBoxDefaultShape
) = GroupBox(
    modifier = if (onClick != null) modifier.clickable(onClick = onClick) else modifier,
    shape = shape
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
    leading: @Composable (() -> Unit)? = null,
    shape: Shape = GroupBoxDefaultShape
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
    onClick = onCheckedChange?.let { { it(!checked) } },
    shape = shape
)

class LazySettingsGroupState {
    internal var items = mutableListOf<@Composable LazySettingsGroupState.(Shape) -> Unit>()

    fun entry(
        title: String,
        subtitle: String? = null,
        leading: (@Composable () -> Unit)? = null,
        trailing: (@Composable () -> Unit)? = null,
        onClick: (() -> Unit)? = null
    ) = items.add { shape ->
        SettingsEntry(
            title = title,
            subtitle = subtitle,
            leading = leading,
            trailing = trailing,
            onClick = onClick,
            shape = shape
        )
    }

    fun switcher(
        checked: Boolean,
        title: String,
        subtitle: String? = null,
        leading: (@Composable () -> Unit)? = null,
        onCheckedChange: ((Boolean) -> Unit)? = null
    ) = items.add { shape ->
        SettingsSwitcherEntry(
            checked = checked,
            title = title,
            subtitle = subtitle,
            leading = leading,
            onCheckedChange = onCheckedChange,
            shape = shape
        )
    }
}

@Composable
fun LazySettingsGroup(
    state: LazySettingsGroupState = remember { LazySettingsGroupState() },
    content: LazySettingsGroupState.() -> Unit
) {
    // clear current items
    state.items.clear()
    // add items
    content(state)

    Column {
        state.items.forEachIndexed { i, item ->
            if (i != 0) {
                HorizontalDivider()
            }

            val shape = run {
                when (i) {
                    0 -> GroupBoxTopShape
                    state.items.size - 1 -> GroupBoxBottomShape
                    else -> RectangleShape
                }
            }

            item(state, shape)
        }
    }
}