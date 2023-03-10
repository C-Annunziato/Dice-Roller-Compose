package com.example.dicerollercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicerollercompose.ui.theme.DiceRollerComposeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerComposeTheme {
                    DiceRollerApp()
            }
        }
    }
}

@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}

@Composable
fun DiceWithButtonAndImage(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {

    var result by rememberSaveable { mutableStateOf(1) }

    val diceImage = when(result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> {R.drawable.dice_4}
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = diceImage), contentDescription = "dice")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            result = Random.nextInt(1, 7)
        }, modifier = Modifier.size(89.dp),
            shape = CircleShape,
        colors = ButtonDefaults.buttonColors(Color.LightGray)
        ) {
            Text(stringResource(id = R.string.roll), fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerAppPreview() {
    DiceRollerComposeTheme {
        DiceWithButtonAndImage()
    }
}

















