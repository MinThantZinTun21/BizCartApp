package com.example.bizcartapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcartapp.ui.theme.BizCartAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BizCartAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val buttonClickState = remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .padding(12.dp),
            elevation = CardDefaults.elevatedCardElevation(4.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileImage()
                Divider(
                    thickness = 1.dp, color = Color.Gray, modifier = Modifier.padding(top = 28.dp)
                )
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "Min Thant zin tun ",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "I am android develper @ \n company with 10 year experience ",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Button(onClick = {
                        buttonClickState.value = buttonClickState.value.not()
                    }) {
                        Text(text = "Profile Button")
                    }


                }
                if (buttonClickState.value) {
                    Content()
                } else {
                    Box {

                    }
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()

    ) {

        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(3.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, color = Color.Gray)
        ) {
            Porfolio(arrayListOf("Profolio 1", "Profolio2", "Profolio 3"))

        }
    }

}

@Composable
private fun Porfolio(data: List<String>) {
    LazyColumn {
        items(data) {
            Card(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(), shape = RectangleShape
            ) {
                Row(
                    modifier = Modifier.background(MaterialTheme.colorScheme.surface)
                ) {
                    Surface(
                        modifier = Modifier.size(56.dp), shape = CircleShape
                    ) {
                        ProfileImage()


                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, start = 12.dp)
                    ) {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Project Description is Here ",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

            }


        }

    }

}

@Composable
private fun ProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.Gray),
        tonalElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)


    ) {
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "Profile",
            modifier = Modifier.size(156.dp),
            contentScale = ContentScale.FillBounds
        )

    }
}


@Preview(showBackground = true)
@Composable
fun BizCardDefaultPreview() {
    CreateBizCard()

}

