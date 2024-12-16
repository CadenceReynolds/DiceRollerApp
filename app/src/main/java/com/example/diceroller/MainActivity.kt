package com.example.businesscardapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                AllDice(
                    modifier = Modifier.fillMaxSize().padding(innerPadding)
                )
            }
        }
    }
}

@Composable
fun AllDice(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(Color.Black)
            .border(2.dp, Color.White)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        DiceRoller(modifier.align(alignment = Alignment.CenterHorizontally))
    }
}


@Composable
fun rollAD4(result: Int): Int {
    return when (result) {
        1 -> R.drawable.d4_4
        2 -> R.drawable.d4_2
        3 -> R.drawable.d4_3
        4 -> R.drawable.d4_4
        else -> R.drawable.d4_1
    }
}

@Composable
fun rollAD6(result: Int): Int {
    return when (result) {
        1 -> R.drawable.d6_1
        2 -> R.drawable.d6_2
        3 -> R.drawable.d6_3
        4 -> R.drawable.d6_4
        5 -> R.drawable.d6_5
        6 -> R.drawable.d6_6
        else -> R.drawable.d6_1
    }
}

@Composable
fun rollAD8(result: Int): Int {
    return when (result) {
        1 -> R.drawable.d6_1
        2 -> R.drawable.d6_2
        3 -> R.drawable.d6_3
        4 -> R.drawable.d6_4
        5 -> R.drawable.d6_5
        6 -> R.drawable.d6_6
        7 -> R.drawable.d6_6
        8 -> R.drawable.d6_6
        else -> R.drawable.d6_1
    }
}

@Composable
fun rollAD10(result: Int): Int {
    return when (result) {
        1 -> R.drawable.d6_1
        2 -> R.drawable.d6_2
        3 -> R.drawable.d6_3
        4 -> R.drawable.d6_4
        5 -> R.drawable.d6_5
        6 -> R.drawable.d6_6
        7 -> R.drawable.d6_6
        8 -> R.drawable.d6_6
        9 -> R.drawable.d6_6
        10 -> R.drawable.d6_6
        else -> R.drawable.d6_1
    }
}

@Composable
fun rollAD12(result: Int): Int {
    return when (result) {
        1 -> R.drawable.d6_1
        2 -> R.drawable.d6_2
        3 -> R.drawable.d6_3
        4 -> R.drawable.d6_4
        5 -> R.drawable.d6_5
        6 -> R.drawable.d6_6
        7 -> R.drawable.d6_6
        8 -> R.drawable.d6_6
        9 -> R.drawable.d6_6
        10 -> R.drawable.d6_6
        11 -> R.drawable.d6_6
        12 -> R.drawable.d6_6
        else -> R.drawable.d6_1
    }
}

@Composable
fun rollAD20(result: Int): Int {
    return when (result) {
        1 -> R.drawable.d6_1
        2 -> R.drawable.d6_2
        3 -> R.drawable.d6_3
        4 -> R.drawable.d6_4
        5 -> R.drawable.d6_5
        6 -> R.drawable.d6_6
        7 -> R.drawable.d6_6
        8 -> R.drawable.d6_6
        9 -> R.drawable.d6_6
        10 -> R.drawable.d6_6
        11 -> R.drawable.d6_6
        12 -> R.drawable.d6_6
        13 -> R.drawable.d6_6
        14 -> R.drawable.d6_6
        15 -> R.drawable.d6_6
        16 -> R.drawable.d6_6
        17 -> R.drawable.d6_6
        18 -> R.drawable.d6_6
        19 -> R.drawable.d6_6
        20 -> R.drawable.d6_6
        else -> R.drawable.d6_1
    }
}

@Composable
fun DiceRoller(modifier: Modifier) {
    var totalSum by remember { mutableIntStateOf(0) }
    var D4Sum by remember { mutableIntStateOf(0) }
    var D6Sum by remember { mutableIntStateOf(0) }
    var D8Sum by remember { mutableIntStateOf(0) }
    var D10Sum by remember { mutableIntStateOf(0) }
    var D12Sum by remember { mutableIntStateOf(0) }
    var D20Sum by remember { mutableIntStateOf(0) }

    var rollD4 by remember { mutableIntStateOf(1) }
    var rollD6 by remember { mutableIntStateOf(1) }
    var rollD8 by remember { mutableIntStateOf(1) }
    var rollD10 by remember { mutableIntStateOf(1) }
    var rollD12 by remember { mutableIntStateOf(1) }
    var rollD20 by remember { mutableIntStateOf(1) }

    val d4Image = rollAD4(rollD4)
    val d6Image = rollAD6(rollD6)
    val d8Image = rollAD8(rollD8)
    val d10Image = rollAD10(rollD10)
    val d12Image = rollAD12(rollD12)
    val d20Image = rollAD20(rollD20)

    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(d4Image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .height(80.dp),
                alignment = Alignment.Center
            )
            Text(text = "$D4Sum", color = Color.White)
            Button(onClick = { rollD4 = (1..4).random(); totalSum += rollD4; D4Sum = rollD4 }) {
                Text(stringResource(R.string.Roll))
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(d6Image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .height(80.dp),
                alignment = Alignment.Center
            )
            Text(text = "$D6Sum", color = Color.White)
            Button(onClick = { rollD6 = (1..6).random(); totalSum += rollD6; D6Sum = rollD6 }) {
                Text(stringResource(R.string.Roll))
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(d8Image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .height(80.dp),
                alignment = Alignment.Center
            )
            Text(text = "$D8Sum", color = Color.White)
            Button(onClick = { rollD8 = (1..8).random(); totalSum += rollD8; D8Sum = rollD8 }) {
                Text(stringResource(R.string.Roll))
            }
        }
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(d10Image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .height(80.dp),
                alignment = Alignment.Center
            )
            Text(text = "$D10Sum", color = Color.White)
            Button(onClick = { rollD10 = (1..10).random(); totalSum += rollD10; D10Sum = rollD10 }) {
                Text(stringResource(R.string.Roll))
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(d12Image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .height(80.dp),
                alignment = Alignment.Center
            )
            Text(text = "$D12Sum", color = Color.White)
            Button(onClick = { rollD12 = (1..12).random(); totalSum += rollD12; D12Sum = rollD12 }) {
                Text(stringResource(R.string.Roll))
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(d20Image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .height(80.dp),
                alignment = Alignment.Center
            )
            Text(text = "$D20Sum", color = Color.White)
            Button(onClick = { rollD20 = (1..20).random(); totalSum += rollD20; D20Sum = rollD20 }) {
                Text(stringResource(R.string.Roll)) }
        }
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Total = $totalSum", color = Color.White)
        Spacer(modifier = Modifier.width(30.dp))
        Button(onClick = { totalSum = 0 }) {
            Text(stringResource(R.string.Clear))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CardPreview() {
    AllDice()
}