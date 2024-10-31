package com.example.myapplication
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import coil3.size.Size

@Composable
fun UserListScreen(viewModel: UserViewModel = viewModel()) {
    val users by viewModel.users.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(users) { user ->
            UserItem(user)
        }
    }
}

@Composable
fun UserItem(user: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = "https://hoanghamobile.com/tin-tuc/wp-content/webp-express/webp-images/uploads/2024/04/anh-con-gai-0.jpg.webp",
            contentDescription = null,
            modifier = Modifier
//                .size(64.dp) // Đặt kích thước của ảnh
//                .clip(CircleShape) // Làm cho ảnh thành hình tròn
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = user.name.toString()+"test",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
    }
}

