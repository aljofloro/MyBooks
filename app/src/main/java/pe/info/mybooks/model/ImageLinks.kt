package pe.info.mybooks.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String
) : Parcelable