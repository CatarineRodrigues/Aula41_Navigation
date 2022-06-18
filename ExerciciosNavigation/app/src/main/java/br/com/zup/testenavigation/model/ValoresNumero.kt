package br.com.zup.testenavigation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ValoresNumero(
    private val numero: Double
) : Parcelable {
    fun getNumero() = this.numero
}