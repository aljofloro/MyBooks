package pe.info.mybooks.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Pdf(
    val acsTokenLink: String?,
    val isAvailable: Boolean
) : Parcelable