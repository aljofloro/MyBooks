package pe.info.mybooks.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import pe.info.mybooks.model.Item

@Composable
fun BookDetail (book:Item){
  Surface(modifier = Modifier
    .fillMaxSize()
    .padding(horizontal = 30.dp)) {
    Column(modifier = Modifier.fillMaxWidth()) {
      BookPicture(imageUrl = book.volumeInfo?.imageLinks?.thumbnail)
      BookVolumeDetail(book = book)
    }
  }
}

@Composable
fun BookVolumeDetail (book:Item){
  val scrollState = rememberScrollState()
  Card(modifier = Modifier.fillMaxWidth()
    , elevation = 5.dp,
  shape = RoundedCornerShape(8.dp)
  ) {
    Column(modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp)
      .verticalScroll(state = scrollState),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
      Text(text = book.volumeInfo.title,
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.Bold
      )
      Text(text = book.volumeInfo.description,
        modifier = Modifier
          .fillMaxWidth()
          .padding(15.dp),
        color = Color.LightGray
      )
    }
  }
}

@Composable
fun BookPicture(imageUrl:String?){

    AsyncImage(model = imageUrl
      , contentDescription = "Imagen",
      modifier = Modifier
        .size(350.dp)
        .padding(10.dp),
    contentScale = ContentScale.FillBounds,
    )

}