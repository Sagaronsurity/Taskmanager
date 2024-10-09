package com.example.taskmanager.Views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.Model.Task
import com.example.taskmanager.ViewModel.TaskViewModel

@Composable
fun TaskListScreen(
    modifier: Modifier,
    viewModel: TaskViewModel,
    tasks: List<Task>,
    onEdit: (Task) -> Unit,
    onAddClicked : () -> Unit
    // Edit action callback
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Text(
                text = "Total Tasks: ${tasks.size}",
                modifier = Modifier.padding(16.dp)
            )
        }

        items(tasks) { task ->
            TaskCard(
                data = task,
                onDelete = { viewModel.delete(task) },
                onEdit = { onEdit(task) },
                onToggleComplete = {
                    viewModel.upsert(task.copy(isCompleted = it))
                }
            )
        }
    }
}
