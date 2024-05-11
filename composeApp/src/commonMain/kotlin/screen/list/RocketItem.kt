package screen.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.ktor.util.hex
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import spacex.composeapp.generated.resources.Res
import spacex.composeapp.generated.resources.compose_multiplatform

@OptIn(ExperimentalResourceApi::class)
@Composable
fun RocketItem(
    modifier: Modifier = Modifier,
    rocket: Rocket
) {
    Column {
        Row(modifier = modifier, verticalAlignment = Alignment.Top) {
            Image(
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = "Rocket's image",
                modifier = Modifier.size(width = 120.dp, height = 80.dp)
            )

            Spacer(modifier = Modifier.size(16.dp))

            Column(modifier = Modifier.weight(1F)) {
                Text(rocket.rocketName.orEmpty())
                Spacer(modifier = Modifier.size(16.dp))
                Text(rocket.description.orEmpty())
            }

        }
        Spacer(modifier = Modifier.size(8.dp))

        Divider(modifier = Modifier.background(Color.Black))

        Spacer(modifier = Modifier.size(16.dp))
    }

}