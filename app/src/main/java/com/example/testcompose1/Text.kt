package com.example.testcompose1

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
fun DefaultPreviewText() {
    TestCompose1Theme {
        Screen5()
    }
}

@Composable
fun MyText1(){
    Text(stringResource(id=R.string.hello_world),
        modifier = Modifier
            .padding(16.dp)
            .background(MaterialTheme.colors.primary)
    )
}

@Composable
fun MyText2() {
    Text(stringResource(R.string.hello_world),
        modifier = Modifier
            .background(MaterialTheme.colors.secondary)
            .padding(16.dp)
            .width(400.dp),
        color = Color.White,
        fontSize = 40.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontFamily = MaterialTheme.typography.h1.fontFamily,
        textAlign = TextAlign.Center
    )
}

@Composable
fun MyText3(){
    Text(buildAnnotatedString {
        withStyle(style = ParagraphStyle(
            textAlign = TextAlign.Center
        )) {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("A")
            }
            append("BBB")
            append('C')
            append("ZZZ")
        }
    }, modifier = Modifier.fillMaxWidth())
}

@Composable
fun MyText4(){
    Text(
        text = "Hello World!!".repeat(20),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun SelectableText1() {
    SelectionContainer() {
        Column {
            Text(text = "Hello World111")
            DisableSelection {
                Text(text = "Hello World222")
            }
            Text(text = "Hello World333")
        }
    }
}

@Composable
fun SuperScriptText(text: String = "", superText: String = "", subText: String = ""){
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        )
        ){
            append(text)
        }
        withStyle(style = SpanStyle(
            fontSize = MaterialTheme.typography.overline.fontSize,
            fontWeight = FontWeight.Bold,
            baselineShift = BaselineShift.Superscript
        )
        ){
            append(superText)
        }
        withStyle(style = SpanStyle(
            fontSize = MaterialTheme.typography.overline.fontSize,
            fontWeight = FontWeight.Bold,
            baselineShift = BaselineShift.Subscript
        )
        ){
            append(subText)
        }
    })
}

@Composable
fun Screen5() {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        MyText1()
        MyText2()
        MyText3()
        MyText4()
        SelectableText1()
        SuperScriptText(text="Привет Всем", superText="От Меня", subText="K Вам")
    }
}