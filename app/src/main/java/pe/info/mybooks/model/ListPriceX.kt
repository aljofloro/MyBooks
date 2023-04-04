package pe.info.mybooks.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ListPriceX(
    val amountInMicros: Int,
    val currencyCode: String
) : Parcelable