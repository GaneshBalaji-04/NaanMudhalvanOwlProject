package com.example.owlapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Define a color palette
val primaryColor = Color(0xFF2196F3) // Vibrant blue
val secondaryColor = Color(0x9DD9FAFF) // Light gray
val accentColor = Color(0xFFE91E63) // Pink accent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyApp(this)
        }
    }
}

@Composable
fun StudyApp(context: Context) {

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .background(secondaryColor) // Light gray background
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Study Material",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor, // Vibrant blue
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Create a list of card data
        val cardData = listOf(
            CardData(
                imageId = R.drawable.img_1,
                courseTitle = stringResource(id = R.string.course1),
                topicTitle = stringResource(id = R.string.topic1),
                targetActivity = MainActivity2::class.java
            ),
            CardData(
                imageId = R.drawable.img_2,
                courseTitle = stringResource(id = R.string.course2),
                topicTitle = stringResource(id = R.string.topic2),
                targetActivity = MainActivity3::class.java
            ),
            CardData(
                imageId = R.drawable.img_3,
                courseTitle = stringResource(id = R.string.course3),
                topicTitle = stringResource(id = R.string.topic3),
                targetActivity = MainActivity4::class.java
            ),
            CardData(
                imageId = R.drawable.img_4,
                courseTitle = stringResource(id = R.string.course4), // Assuming typo
                topicTitle = stringResource(id = R.string.topic4),
                targetActivity = MainActivity5::class.java
            )
        )

        // Loop through the card data and create cards
        cardData.forEach { card ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clickable {
                        context.startActivity(Intent(context, card.targetActivity))
                    }
                    .clip(RoundedCornerShape(16.dp)), // Rounded corners
                elevation = 8.dp,
                backgroundColor = secondaryColor // White card background
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.background(secondaryColor) // Light gray background for card content
                ) {
                    Image(
                        painterResource(id = card.imageId),
                        contentDescription = "",
                        modifier = Modifier
                            .height(150.dp)
                            .scale(scaleX = 1.2F, scaleY = 1F)
                    )
                    Text(
                        text = card.courseTitle,
                        color = primaryColor, // Vibrant blue
                        fontSize = 16.sp,
                        // Use a custom font if desired (replace with your font file)
                        // font = Font(resource = "your_font_file.ttf")
                    )
                    Text(
                        text = card.topicTitle,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        // Use a custom font if desired (replace with your font file)
                        // font = Font(resource = "your_font_file.ttf")
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

// Data class to hold card information
data class CardData(
    val imageId: Int,
    val courseTitle: String,
    val topicTitle: String,
    val targetActivity: Class<out ComponentActivity>
)