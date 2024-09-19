import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun ColorExample() {
    Text(
        text = "Alpha",
        style = MaterialTheme.typography.titleLarge
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
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
            color = MaterialTheme.colorScheme.primaryContainer.combineAlpha(DisabledComponentAlpha),
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

    Text(
        text = "Colors",
        style = MaterialTheme.typography.titleLarge
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
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

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
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
