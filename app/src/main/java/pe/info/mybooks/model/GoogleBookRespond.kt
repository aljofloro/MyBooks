package pe.info.mybooks.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class GoogleBookRespond(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
) : Parcelable