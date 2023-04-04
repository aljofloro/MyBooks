package pe.info.mybooks

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.info.mybooks.model.Item
import pe.info.mybooks.ui.theme.MyBooksTheme
import pe.info.mybooks.view.BookItem
import pe.info.mybooks.viewModel.BookViewModel

class MainActivity : ComponentActivity() {

  val bookViewModel by viewModels<BookViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyBooksTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize()
          , color = MaterialTheme.colors.background) {
          Column(modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)) {
            OutlinedTextField(value = bookViewModel.searchField,
              onValueChange = { bookViewModel.searchField = it
                },
            modifier = Modifier.fillMaxWidth(),
              label = {Text("Ingresar búsqueda")}
            )
            Button(onClick = { bookViewModel.getBookList(bookViewModel.searchField.trim()) },
            modifier = Modifier.fillMaxWidth().padding(4.dp))
            {
              Text(text = "Buscar")
            }
            BookList(bookList = bookViewModel.bookListResponse, context = baseContext)
          }
        }
      }
    }
  }
}

@Composable
fun BookList(bookList: List<Item>,context: Context){
  LazyColumn{
    itemsIndexed(items = bookList){ index, item->
      BookItem (book = item, context)
    }
  }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  MyBooksTheme {

  }
}