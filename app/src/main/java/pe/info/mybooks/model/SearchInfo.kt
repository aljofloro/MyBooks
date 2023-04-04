package pe.info.mybooks.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class SearchInfo(
    val textSnippet: String
) : Parcelable