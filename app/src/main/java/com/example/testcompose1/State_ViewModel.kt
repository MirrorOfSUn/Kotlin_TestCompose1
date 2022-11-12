package com.example.testcompose1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding //-
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp //-
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testcompose1.ui.theme.TestCompose1Theme
import androidx.lifecycle.viewmodel.compose.viewModel



@Preview(showBackground = true)
@Composable
fun DefaultPreviewStateViewModel() {
    TestCompose1Theme {
        Screen2()
    }
}

@Composable
fun Screen2() {

    val btnGlobValue = remember { mutableStateOf(0) }

    Column {
        HelloContentStateFull()
        HelloScreenStateLess()
        HelloScreenViewModel()
    }
}

@Composable
fun HelloContentStateFull() {
    Column(modifier = Modifier.padding(16.dp)) {
        var name: String by remember {
            mutableStateOf("A")
        }
        // 3 variants:
        // val mutableState = remember { mutableStateOf(default) }
        // var value by remember { mutableStateOf(default) }
        // val (value, setValue) = remember { mutableStateOf(default) }
        if (name.isNotEmpty()) {
            Text(
                text = "Hello! $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("HelloContentStateFull") }
        )
    }
}

// Stateless
@Composable
fun HelloScreenStateLess() {
    var name by rememberSaveable { mutableStateOf("") }

    HelloContentStateLess(name = name, onNameChange = { name = it })
}

@Composable
fun HelloContentStateLess(name: String, onNameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("HelloScreenStateLess") }
        )
    }
}

// View Model
class HelloViewModel: ViewModel() {
    private val _name:MutableLiveData<String> = MutableLiveData("")
    val name: LiveData<String> = _name

    fun onNameChange(newName: String){
        _name.value = newName
    }
}
@Composable
fun HelloScreenViewModel(helloViewModel: HelloViewModel = viewModel()) {
    // var name: String by helloViewModel.name.observeAsState("")
    val name = helloViewModel.name.observeAsState("")


    HelloContentViewModel(name = name.value, onNameChange = { helloViewModel.onNameChange(it) })
}

@Composable
fun HelloContentViewModel(name: String, onNameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("HelloContentViewModel") }
        )
    }
}