package pe.info.mybooks.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class PanelizationSummary(
    val containsEpubBubbles: Boolean,
    val containsImageBubbles: Boolean
) : Parcelable