package com.example.taskmanager.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.Model.Task

@Composable
fun TaskCard(
    data: Task,
    onDelete: () -> Unit,
    onEdit: () -> Unit,
    onToggleComplete: (Boolean) -> Unit  // Function to mark task as completed/uncompleted
) {
    val bgColor = when (data.priority) {
        "High" -> Color(0xFFFFCDD2) // Reddish shade
        "Medium" -> Color(0xFFFFF9C4) // Yellow shade
        "Low" -> Color(0xFFC8E6C9) // Green shade
        else -> Color.LightGray // Default shade for any other case
    }

    Column(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .background(
                color = bgColor,
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = data.title+ if(data.isCompleted) "  ✔" else "",
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp),
                    fontSize = 20.sp,
                )
            }

            Checkbox(
                checked = data.isCompleted,
                onCheckedChange = { onToggleComplete(it) },
                modifier = Modifier.padding(12.dp)
            )


            // Edit icon for editing the task

        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = data.description,
                modifier = Modifier
                    .padding(top = 12.dp, start = 12.dp)
                    .weight(1f),
                fontSize = 15.sp,
                lineHeight = 20.sp
            )

            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(
                        end = 24.dp
                    )
                    .clickable { onEdit() }
            )
        }

        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Due date of the task
            Text(
                text = data.dueDate,
                modifier = Modifier.weight(1f),
                fontSize = 13.sp,
                lineHeight = 20.sp
            )

            // Delete icon to delete the task
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .clickable { onDelete() }
                    .padding(end = 14.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewTaskCard() {
    TaskCard(
        data = Task(
            title = "Important Task",
            description = "This task needs to be done urgently.",
            dueDate = "12/12/2024",
            priority = "High",
            isCompleted = false
        ),
        onDelete = {},
        onEdit = {},
        onToggleComplete = {}
    )
}
