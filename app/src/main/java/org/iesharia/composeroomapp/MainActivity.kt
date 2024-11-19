package org.iesharia.composeroomapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.iesharia.composeroomapp.ui.theme.ComposeRoomAppTheme
import androidx.compose.material3.OutlinedTextField
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskApp(database)
        }
    }
}

@Composable
fun TaskApp(database: AppDatabase) {
    val taskDao = database.taskDao()
    val scope = rememberCoroutineScope()
    var tasks by remember { mutableStateOf(listOf<Task>()) }
    var newTaskName by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        tasks = taskDao.getAllTasks()
    }
    Column( modifier = Modifier .fillMaxSize() .padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally ){
        OutlinedTextField(value = newTaskName, onValueChange = { newTaskName = it }, label = { Text("New Task") }, modifier = Modifier.fillMaxWidth())
        Button(onClick = {
            scope.launch(Dispatchers.IO) {
                val newTask = Task(name = newTaskName)
                taskDao.insert(newTask)
                tasks = taskDao.getAllTasks()
                newTaskName = ""
            }

        }) {Text("Add Task") }
        tasks.forEach { task -> Text(text = task.name) }
    }

}
