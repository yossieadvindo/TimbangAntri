package id.ac.ukdw.timbangantri

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.setting.*

class Setting: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting)

        imgakun.setOnClickListener{
            showAkun()
        }

        privacy.setOnClickListener {

            var privacy: String = "Tentang TimbangAntri\n" +
                    "\n" +
                    "TimbangAntri adalah layanan booking antrian bengkel yang ada di Yogyakarta.\n" +
                    "\n" +
                    "TimbangAntri lahir untuk menjadi wadah sinergi bagi semua layanan masyarakat dalam memesan antrian service yang ada di Bengkel.\n" +
                    "\n" +
                    "Perpindahan ke TimbangAntri adalah proses penginputan data yang tercatat di masing-masing akun, sehingga sampai pada bengkel ang tertuju.\n" +
                    "\n" +
                    "Waktu pelaksanaan antrian adalah sesuai dengan registrasi waktu sekarang. "

            val alertDialog = AlertDialog.Builder(this).create()
            alertDialog.setTitle("Privacy Policy")
            alertDialog.setMessage(privacy)

            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OKE"
            ) { dialog, which -> dialog.dismiss() }

//            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No"
//            ) { dialog, which -> dialog.dismiss() }
            alertDialog.show()

            val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL)
//            val btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)

            val layoutParams = btnPositive.layoutParams as LinearLayout.LayoutParams
            layoutParams.weight = 10f
            btnPositive.layoutParams = layoutParams
//            btnNegative.layoutParams = layoutParams

        }


    }

    fun showAkun(){
        var i: Intent = Intent(this, EditProfile::class.java)
        i.putExtra("id", intent.getStringExtra("id"))
        startActivity(i)
    }
}