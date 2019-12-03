package id.ac.ukdw.timbangantri

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import data.Antrian
import kotlinx.android.synthetic.main.activity_booking.*
import kotlinx.android.synthetic.main.activity_place_detail.*
import java.sql.Time
import java.text.DateFormat
import java.time.LocalDateTime
import java.util.*

class PlaceDetailActivity : AppCompatActivity() {

    lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        var namabgkl = intent.getStringExtra("namaBengkel")
        var jambuka= intent.getStringExtra("jambuka")
        var jamtutup = intent.getStringExtra("jamtutup")
        val uid :String = intent.getStringExtra("id")
        var cal: Calendar = Calendar.getInstance()
        db = FirebaseDatabase.getInstance().getReference("antrian")
        namabengkeldetail.setText(namabgkl)
        bukajam.setText(jambuka)
        tutupjam.setText(jamtutup)

        btnsaveAntrian.setOnClickListener {
            if(!namadetail.text.toString().equals("") && !contactdetail.text.toString().equals("") && !no_platdetail.text.toString().equals("")){
                var namaantr: TextView = findViewById(R.id.namadetail)
                var contactantr: TextView = findViewById(R.id.contactdetail)
                var no_platantr: TextView = findViewById(R.id.no_platdetail)
                var tgl = DateFormat.getDateInstance(DateFormat.FULL).format(cal.time)
                var jam = DateFormat.getTimeInstance(TimeZone.SHORT).format(cal.time)
                var service:String = ""
                var idantr: String? = UUID.randomUUID().toString()

                    val builder = AlertDialog.Builder(this@PlaceDetailActivity)

                    // String array for alert dialog multi choice items
                    val bengkelArray = arrayOf(
                        "Ganti_Ban", "Ganti_Lampu", "Ganti_Oli", "Ganti_Ban", "Ganti_Accu", "Ganti_Ecu", "Ganti_Coil", "Ganti_Busi",
                        "Ganti_Vanbelt", "Ganti_Cover_Fan", "Ganti_Filter")
                    // Boolean array for initial selected items
                    val checkedColorsArray = booleanArrayOf(
                        false, false, false, false, false, false, false, false, false, false, false
                    )
                    // Convert the color array to list
                    val colorsList = Arrays.asList(*bengkelArray)
                    //setTitle
                    builder.setTitle("Pilih Service")
                    //set multichoice
                    builder.setMultiChoiceItems(bengkelArray, checkedColorsArray) { dialog, which, isChecked ->
                        // Update the current focused item's checked status
                        checkedColorsArray[which] = isChecked
                        // Get the current focused item
                        val currentItem = colorsList[which]
                        // Notify the current action
                        Toast.makeText(applicationContext, currentItem + " " + isChecked, Toast.LENGTH_SHORT).show()
                    }

                    // Set the positive/yes button click listener
                    builder.setPositiveButton("OK") { dialog, which ->
                        // Do something when click positive button
                        for (i in checkedColorsArray.indices) {
                            val checked = checkedColorsArray[i]
                            if (checked) {
                                service = service.toString() + colorsList[i] + " "
                            }
                        }

                        var antrian = Antrian(namabgkl, namaantr.text.toString(), contactantr.text.toString(), no_platantr.text.toString(), tgl, jam, service, uid)

                        db.child(idantr!!).setValue(antrian)

                        var i: Intent = Intent(this, Code::class.java)
                        i.putExtra("id", uid)
                        i.putExtra("bgklantr", namabgkl)
                        i.putExtra("namaantr", namaantr.text.toString())
                        i.putExtra("contactantr", contactantr.text.toString())
                        i.putExtra("noplatantr" ,no_platantr.text.toString())
                        i.putExtra("tglantr", tgl)
                        i.putExtra("jamantr", jam)
                        i.putExtra("service", service)
                        startActivity(i)

                    }
                    // Set the neutral/cancel button click listener
                    builder.setNeutralButton("Cancel") { dialog, which ->
                        // Do something when click the neutral button
                    }
                    val dialog = builder.create()
                    // Display the alert dialog on interface
                    dialog.show()

                Toast.makeText(baseContext, "Kirim Antrian", Toast.LENGTH_LONG).show()

            }
            else{
                txtKrgBk.text = "Belum Diisi Semua Antrian"
                //Toast.makeText(baseContext, "EMAIL ATAU PASSWORD KOSONG", Toast.LENGTH_LONG).show()
            }
        }

    }
}
