package pe.info.mybooks.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ReadingModes(
    val image: Boolean,
    val text: Boolean
) : Parcelable