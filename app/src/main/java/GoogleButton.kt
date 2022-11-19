package com.example.testcompose1

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcompose1.ui.theme.Shapes
import com.example.testcompose1.ui.theme.TestCompose1Theme


@Preview(showBackground = false, showSystemUi = false)
@Composable
fun DefaultPreviewGoogleButton() {
    TestCompose1Theme {
        Screen8()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GoogleButton(onClicked: @Composable ()->Unit ){
    var clicked by remember { mutableStateOf( false )}
    Surface(
        onClick = {
            clicked = !clicked
        },
        shape = Shapes.medium,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        color = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp)
                .height(40.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
        ) {
            Text("Sign Up with ", fontSize = MaterialTheme.typography.button.fontSize)
            Icon(
                painter = painterResource(id = R.drawable.ic_google_logo),
                contentDescription = "Google Button",
                tint = Color.Unspecified,
                modifier = Modifier.height(20.dp)
            )
            if(clicked){
                Spacer(modifier = Modifier.width(8.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colors.primary
                )
                onClicked()
            }
        }
    }
}

@Composable
fun Screen8() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        GoogleButton(){ Log.d("Google Btn", "I'm clicked" )}
    }
}