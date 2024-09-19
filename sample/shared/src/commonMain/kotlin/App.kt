import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import ui.theme.AppTheme

@Composable
fun App() {
    var darkTheme by remember { mutableStateOf(false) }

    AppTheme(
        darkTheme = darkTheme
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Theme Switcher",
                style = MaterialTheme.typography.titleLarge
            )

            Switch(
                checked = darkTheme,
                onCheckedChange = { darkTheme = it }
            )

            ColorExample()
        }
    }
}
