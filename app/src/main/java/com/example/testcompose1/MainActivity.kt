package com.example.testcompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testcompose1.ui.theme.TestCompose1Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestCompose1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HelloScreenViewModel()
                }
            }
        }
    }
}

@Composable
fun RunAll() {
    val clickCounter = remember { mutableStateOf(0) }

    Column {
        Text(
            text = "Clicked ${clickCounter.value} times!"
        )
        Button(
            onClick = {
                clickCounter.value++
                println("RunAll: ${clickCounter.value}")
            },
        ) {
            Text("RunAll Btn")
        }
        NoState()
        MutableStateClick()
        MutableStateClickWithRemember()
        RememberSavableSample()
    }
}
@Composable
fun NoState() {
    var clickCount = 0
    Column {
        Button(onClick = {
            clickCount++
            println("NoState: $clickCount")
        }) {
            Text(text = "$clickCount NoState")
        }
    }
}
@Composable
fun MutableStateClick() {
    var clickCount:Int by mutableStateOf(0)//Not recommended
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "$clickCount MutableStateClick")
        }
    }
}
@Composable
fun MutableStateClickWithRemember() {
    var clickCount:Int by remember { mutableStateOf(0) }//Not recommended
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "$clickCount MutableStateClickWithRemember")
        }
    }
}
@Composable
fun RememberSavableSample() {
    val clickCount = rememberSaveable { mutableStateOf(0) }
    Column {
        Button(onClick = { clickCount.value++ }) {
            Text(text = "" + clickCount.value + " RememberSavableSample")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestCompose1Theme {
        RunAll()
    }
}