package ca.ulaval.ima.tp1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ca.ulaval.ima.tp1.myPackage.Profil
import java.util.*

class ProfilDescription : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_description)

        val intent = intent
        val monProfil = intent.getParcelableExtra<Profil>("Profil")

        val textPrenom = findViewById<TextView>(R.id.prenom)
        val textNom = findViewById<TextView>(R.id.nom)
        val textDate = findViewById<TextView>(R.id.date)
        val textIdul = findViewById<TextView>(R.id.idul)

        textPrenom.text = "Prénom:\t\t\t\t\t\t\t\t\t\t\t${monProfil?.nom}"
        textNom.text = "Nom de famille:\t\t\t\t\t${monProfil?.prenom}"
        textDate.text = "Date de naissance:" +
                "\t\t${1990 + monProfil?.dateDeNaissance?.get(Calendar.YEAR)!!}/" +
                "${monProfil.dateDeNaissance?.get(Calendar.MONTH)}/" +
                "${monProfil.dateDeNaissance?.get(Calendar.DAY_OF_MONTH)}"
        textIdul.text = "IDUL:\t\t\t\t\t\t\t\t\t\t\t\t\t\t${monProfil.IDUL}"

    }
}
