package pe.info.mybooks.view

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import coil.request.ImageRequest
import pe.info.mybooks.DetailActivity
import pe.info.mybooks.model.Item

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BookItem(book: Item, context: Context){
  Card(modifier = Modifier
    .padding(8.dp, 4.dp)
    .fillMaxWidth()
    ,shape = RoundedCornerShape(8.dp),
    elevation = 4.dp,
    onClick = { Toast.makeText(context,book.volumeInfo.pageCount.toString(),Toast.LENGTH_SHORT).show()
      var intent = Intent(context,DetailActivity::class.java)
      intent.putExtra("Item",book)
      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      context.startActivity(intent)
    }
  ) {
    androidx.compose.material.Surface() {
      Row(
        Modifier
          .padding(8.dp)
          .fillMaxSize(),
      verticalAlignment = Alignment.CenterVertically) {
        if(!book.volumeInfo.imageLinks.thumbnail.isNullOrEmpty()){
          AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
              .data(book.volumeInfo.imageLinks.thumbnail)
              .crossfade(true)
              .build(),
            contentDescription = book.volumeInfo.title,
            placeholder = painterResource(pe.info.mybooks.R.drawable.ic_launcher_background),
            contentScale = ContentScale.Fit,
            modifier = Modifier.clip(RectangleShape)
              .width(110.dp),
          )
        }

        Column(verticalArrangement = Arrangement.Center,
          modifier = Modifier
          .padding(4.dp)
          .fillMaxHeight()
          .weight(0.8f)) {

          if(!book.volumeInfo.categories.isNullOrEmpty()) {
            Text(
              text = book.volumeInfo.categories.toString(),
              style = MaterialTheme.typography.overline, modifier = Modifier.padding(4.dp)
            )
          }

          Text(text = book.volumeInfo.title, style = MaterialTheme.typography.subtitle1,
          modifier = Modifier
            .background(Color.LightGray)
            .padding(8.dp), fontWeight = FontWeight.Bold)

          if(!book.volumeInfo.subtitle.isNullOrEmpty()){
            Text(text = book.volumeInfo.subtitle, style = MaterialTheme.typography.subtitle2,
              modifier = Modifier
                .padding(8.dp))
          }

          if(!book.volumeInfo.authors.isNullOrEmpty()) {
            Text(
              text = book.volumeInfo.authors.toString(), style = MaterialTheme.typography.caption,
              modifier = Modifier
                .padding(4.dp), color = Color.LightGray
            )
          }
        }
      }
    }
  }
}