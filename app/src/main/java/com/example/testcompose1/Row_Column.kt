package com.example.testcompose1

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
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp //-
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testcompose1.ui.theme.TestCompose1Theme
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreviewRowColumn() {
    TestCompose1Theme {
        Screen3()
    }
}

@Composable
fun ColumnScope.CustomItem(width: Dp = 200.dp,
                           weight: Float = 1f,
                           color: Color = MaterialTheme.colors.primary,
                           content: @Composable () -> Unit = {}
){
    Surface(modifier = Modifier
        .fillMaxSize()
        .width(width)
        .weight(weight),
        color=color,
        content=content)
}

@Composable
fun RowScope.CustomItem(weight: Float = 1f,
                        color: Color = MaterialTheme.colors.primary,
                        content: @Composable () -> Unit = {}
){
    Surface(modifier = Modifier
        .fillMaxSize()
        .weight(weight),
        color=color,
        content=content)
}

@Composable
fun Screen3() {
    Column(modifier = Modifier.fillMaxSize().background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomItem(200.dp, 1f)
        CustomItem(5000.dp, weight = 3f, color = MaterialTheme.colors.secondary) {
            Row(Modifier.fillMaxWidth()){
                CustomItem(color=Color.Green)
                CustomItem(2f, color=Color.Red)
            }
        }
    }
}