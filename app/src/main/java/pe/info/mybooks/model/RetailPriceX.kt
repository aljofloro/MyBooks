package pe.info.mybooks.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class RetailPriceX(
    val amount: Double,
    val currencyCode: String
) : Parcelable