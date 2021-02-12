package ca.ulaval.ima.tp1.myPackage

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class Profil(var nom: String, var prenom: String, var dateDeNaissance: Calendar?,
                  var IDUL: String): Parcelable{
    constructor(parcel: Parcel) : this(
        nom = parcel.readString() ?:"",
        prenom = parcel.readString() ?:"",
        dateDeNaissance = GregorianCalendar(0, 0 , 0).also{
            val readValues = parcel.readString()?.split(";")
            it.set(readValues?.get(0)?.toInt() ?: 0, readValues?.get(1)?.toInt() ?: 0
                , readValues?.get(2)?.toInt() ?: 0)
        },
        IDUL = parcel.readString() ?:""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom)
        parcel.writeString(prenom)
        parcel.writeString("${dateDeNaissance?.get(Calendar.YEAR)};" +
                "${dateDeNaissance?.get(Calendar.MONTH)};" +
                "${dateDeNaissance?.get(Calendar.DAY_OF_MONTH)}")
        parcel.writeString(IDUL)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Profil> {
        override fun createFromParcel(parcel: Parcel): Profil {
            return Profil(parcel)
        }

        override fun newArray(size: Int): Array<Profil?> {
            return arrayOfNulls(size)
        }
    }
}