package ca.ulaval.ima.tp1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ca.ulaval.ima.tp1.myPackage.Profil
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateDeNaissance = GregorianCalendar(8, 11, 24)
        val monProfil = Profil("Rochdi", "Elfakrani", dateDeNaissance, "roelf1")
        val urlToLoad = "http://monportail.ulaval.ca"

        val buttonSiteWebExt = findViewById<Button>(R.id.siteWebExt)
        val buttonSiteWebWv = findViewById<Button>(R.id.siteWebWv)
        val buttonULaval = findViewById<Button>(R.id.uLaval)
        val buttonMonProfil = findViewById<Button>(R.id.monProfil)



        buttonSiteWebExt.setOnClickListener{
            val browser = Intent(Intent.ACTION_VIEW, Uri.parse(urlToLoad))
            startActivity(browser)
        }

        buttonSiteWebWv.setOnClickListener{
            val intentSiteWebview = Intent(this, WebViewPortail::class.java)
            intentSiteWebview.putExtra("URL", urlToLoad)
            startActivity(intentSiteWebview)
        }

        buttonULaval.setOnClickListener{
            val intentUlaval = Intent(this, UlavalActivity::class.java)
            startActivity(intentUlaval)
        }

        buttonMonProfil.setOnClickListener{
            val intentMonProfil = Intent(this, ProfilDescription::class.java)
            intentMonProfil.putExtra("Profil", monProfil)
            startActivity(intentMonProfil)
        }
    }
}

