package com.example.testcompose1

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding //-
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp //-
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testcompose1.ui.theme.TestCompose1Theme
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreviewTextInput() {
    TestCompose1Theme {
        Screen7()
    }
}

@Composable
fun TextInput1(){
    var text by remember { mutableStateOf("") }
    val icoRotation = listOf(
        Icons.Filled.Edit,
        Icons.Filled.Add,
        Icons.Filled.Email
    )
    var icoRotationIndex by remember { mutableStateOf(0) }

    TextField(
        //modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = {inp -> text = inp},
        label = {
            Text("My Label")
        },
        leadingIcon = {
            IconButton(onClick = { icoRotationIndex = if (icoRotationIndex < 2) icoRotationIndex+1 else 0 }) {
                Icon(imageVector = icoRotation[icoRotationIndex], "Lead Icon")
            }
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Check Mark",
                    modifier = Modifier.background(Color.Red)
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                Log.d("ImeAction", "Search Clicked: $text")
            }
        )
    )
}

@Composable
fun TextInput2(){
    var text by remember { mutableStateOf("") }
    val icoRotation = listOf(
        Icons.Filled.Edit,
        Icons.Filled.Add,
        Icons.Filled.Email
    )
    var icoRotationIndex by remember { mutableStateOf(0) }

    OutlinedTextField(

        value = text,
        onValueChange = {inp -> text = inp},
        label = {
            Text("My Label")
        },
        leadingIcon = {
            IconButton(onClick = { icoRotationIndex = if (icoRotationIndex < 2) icoRotationIndex+1 else 0 }) {
                Icon(imageVector = icoRotation[icoRotationIndex], "Lead Icon")
            }
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Check Mark"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                Log.d("ImeAction", "Search Clicked: $text")
            }
        )
    )
}

@Composable
fun TextInput3(){
    var text by remember { mutableStateOf("") }


    BasicTextField(
        modifier = Modifier
            .background(Color.Gray)
            .padding(16.dp),
        value = text,
        onValueChange = {inp -> text = inp},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                Log.d("ImeAction", "Search Clicked: $text")
            }
        )
    )
}

@Composable
fun Screen7() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextInput1()
        TextInput2()
        TextInput3()
    }
}