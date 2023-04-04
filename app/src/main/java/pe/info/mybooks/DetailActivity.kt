package pe.info.mybooks

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.info.mybooks.model.Item
import pe.info.mybooks.ui.theme.MyBooksTheme
import pe.info.mybooks.view.BookDetail

class DetailActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val item = if(Build.VERSION.SDK_INT >= 33){
      intent.getParcelableExtra("Item",Item::class.java)
    }else{
      intent.getParcelableExtra<Item>("Item")
    } as Item
    setContent {
      MyBooksTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          BookDetail(book = item)
        }
      }
    }
  }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
  MyBooksTheme {
  }
}