package com.example.testcompose1

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testcompose1.ui.theme.TestCompose1Theme


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestCompose1Theme {
        Screen1()
    }
}

@Composable
fun Screen1() {

    val btnGlobValue = remember { mutableStateOf(0) }

    Column {
        ButtonAndText()
        ButtonWithMemory(btnGlobValue)
        ButtonWithMemory(btnGlobValue)
        NoState()
        MutableStateClick()
        MutableStateClickWithRemember()
        RememberSavableSample()
        NamePicker(
            myText = "Test Pickler",
            myList = listOf("AAA","BBB","CCC"),
            onNameClicked = clickPrint
        )
        TextWithRemember()
        StatefulVsStatelessScreen()
    }
}

@Composable
fun ButtonAndText(){
    // Stateful
    var clickCounter by remember { mutableStateOf(0) }
    Text(
        text = "Clicked ${clickCounter} times!"
    )
    Button(
        onClick = {
            clickCounter++
            println("RunAll: ${clickCounter}")
        },
    ) {
        Text("RunAll Btn")
    }
}

@Composable
fun ButtonWithMemory(globCounter: MutableState<Int>){
    // Stateful
    // при нажатии меняю T-F-T
    val btnValue = remember { mutableStateOf(false) }
    Button(onClick = {
        btnValue.value = ! btnValue.value
        globCounter.value++
    }) {
        Text(text="${btnValue.value} (${globCounter.value})")
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
@SuppressLint("UnrememberedMutableState")
@Composable
fun MutableStateClick() {
    var clickCount:Int by mutableStateOf(0)  // Not recommended
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "$clickCount MutableStateClick")
        }
    }
}
@Composable
fun MutableStateClickWithRemember() {
    var clickCount:Int by remember { mutableStateOf(0) }  // Not recommended
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


@Composable
private fun NamePickerItem(
    name: String,
    onClicked: (String) -> Unit
){
    Text(
        name,
        Modifier.clickable( onClick = { onClicked(name) })
    )
}

@Composable
fun NamePicker(
    myText: String,
    myList: List<String>,
    onNameClicked: (String)->Unit
){
    Column {
        Text(myText, style = MaterialTheme.typography.h5)
        Divider()

        LazyColumn{
            items(myList){
                    name-> NamePickerItem(name = name, onClicked = onNameClicked)
            }
        }
    }
}

// lambda
val clickPrint = { value: String -> println(value) }
//val lambda2 : (String) -> Unit = { name: String ->
//    println("My name is $name")
//}

@Composable
fun TextWithRemember(){
    var name by remember { mutableStateOf("TextWithRemember") }

    TextField(
        value = name,
        onValueChange = {name = it },
        label = {Text(name)}
    )
}

//-------  Stateful Vs Stateless
// Stateful
@Composable
fun StatefulVsStatelessScreen(){
    var name by remember { mutableStateOf("") }
    StatefulVsStatelessScreenContent(
        name = name,
        onNameChange = {name = it.uppercase()}
    )
}

// Stateless
@Composable
fun StatefulVsStatelessScreenContent(
    name: String,
    onNameChange: (String) -> Unit
){
    TextField(
        value = name,
        onValueChange =onNameChange,
        label = {Text("StatefulVsStatelessScreenContent")}
    )
}
