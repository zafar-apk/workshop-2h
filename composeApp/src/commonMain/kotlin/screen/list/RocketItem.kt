package screen.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import io.ktor.util.hex
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import spacex.composeapp.generated.resources.Res
import spacex.composeapp.generated.resources.compose_multiplatform
import spacex.composeapp.generated.resources.placeholder

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RocketItem(
    modifier: Modifier = Modifier,
    rocket: Rocket
) {
    Card(
        onClick = { /* no-op */ },
        modifier = modifier
    ) {
        Row(modifier = modifier.padding(8.dp), verticalAlignment = Alignment.Top) {
            Image(
                painter = getRocketImagePainter(rocket.getFirstImageOrNull()),
                contentDescription = "Rocket's image",
                modifier = Modifier.size(width = 120.dp, height = 80.dp)
            )

            Spacer(modifier = Modifier.size(16.dp))

            Column(modifier = Modifier.weight(1F)) {
                Text(text = rocket.rocketName.orEmpty())

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = rocket.description.orEmpty(),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun getRocketImagePainter(image: String?): Painter {
    return rememberAsyncImagePainter(
        model = image,
        placeholder = painterResource(Res.drawable.placeholder)
    )
}