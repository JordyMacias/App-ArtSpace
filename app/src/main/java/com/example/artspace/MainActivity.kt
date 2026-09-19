package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

data class Artwork(
    val imageResId: Int,
    val titleResId: Int,
    val artistResId: Int,
    val yearResId: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    val artworks = listOf(
        Artwork(R.drawable.artwork1, R.string.title_1, R.string.artist_1, R.string.year_1),
        Artwork(R.drawable.artwork2, R.string.title_2, R.string.artist_2, R.string.year_2),
        Artwork(R.drawable.artwork3, R.string.title_3, R.string.artist_3, R.string.year_3)
    )

    var currentIndex by remember { mutableIntStateOf(0) }
    val current = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        ArtworkWall(imageResId = current.imageResId)

        Spacer(modifier = Modifier.height(24.dp))

        ArtworkDescriptor(
            title = stringResource(current.titleResId),
            artist = stringResource(current.artistResId),
            year = stringResource(current.yearResId)
        )

        Spacer(modifier = Modifier.height(24.dp))

        DisplayController(
            onPreviousClick = {
                currentIndex = if (currentIndex == 0) {
                    artworks.lastIndex
                } else {
                    currentIndex - 1
                }
            },
            onNextClick = {
                currentIndex = if (currentIndex == artworks.lastIndex) {
                    0
                } else {
                    currentIndex + 1
                }
            }
        )
    }
}

@Composable
fun ArtworkWall(imageResId: Int, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .shadow(elevation = 8.dp)
            .fillMaxWidth()
            .height(400.dp),
        shape = RoundedCornerShape(4.dp),
        color = Color.White,
        tonalElevation = 4.dp
    ) {
        Box(
            modifier = Modifier.padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun ArtworkDescriptor(
    title: String,
    artist: String,
    year: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Light
            )
            Row {
                Text(
                    text = artist,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = " ($year)",
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun DisplayController(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.width(120.dp),
            colors = ButtonDefaults.buttonColors()
        ) {
            Text(text = stringResource(R.string.previous))
        }
        Button(
            onClick = onNextClick,
            modifier = Modifier.width(120.dp),
            colors = ButtonDefaults.buttonColors()
        ) {
            Text(text = stringResource(R.string.next))
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}