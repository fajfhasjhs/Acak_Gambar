 package com.example.button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.button.ui.theme.ButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AcakGambarHewan()
                }
            }
        }
    }
}
@Composable
fun AcakGambarHewan(modifier: Modifier =Modifier){
    var result by remember {
        mutableStateOf(1)
    }

    val imageResoure = when (result) {
        1 -> R.drawable.hewan_1
        2 -> R.drawable.hewan_2
        3 -> R.drawable.hewan_3
        4 -> R.drawable.hewan_4
        else -> R.drawable.hewan_5
    }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResoure),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { result = (1..5).random() }) {
            Text(stringResource(R.string.acak_button_name))
        }
    }

}
@Preview (showBackground = true)
@Composable
fun AcakGambarHewanPreview () {
    AcakGambarHewan()
}