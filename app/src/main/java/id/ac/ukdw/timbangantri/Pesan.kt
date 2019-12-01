package id.ac.ukdw.timbangantri

//import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import data.Booking
import kotlinx.android.synthetic.main.activity_booking.*
import java.util.*

class Pesan : AppCompatActivity() {
    lateinit var db: DatabaseReference
    lateinit var jenMon: Spinner
    lateinit  var jenisMotor: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        db = FirebaseDatabase.getInstance().getReference("booking")

        jenMon = findViewById(R.id.spin_jenMotor)

        val pilihan = arrayOf("Type Kendaraan","Vario 125","Vario 110", "Beat", "Mio Gt", "Jupiter Mx" )

        jenMon.adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,pilihan)

        jenMon.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                txtKrgBk.text = "plis pilih"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                jenisMotor = pilihan.get(position)
            }

        }
        btnPesan.setOnClickListener {
            if(!platno.text.toString().equals("") && !contact.text.toString().equals("") && !nama.text.toString().equals("")){
                isiDataBooking()
                Toast.makeText(baseContext, "Kirim Pesanan", Toast.LENGTH_LONG).show()
            }
            else{
                txtKrgBk.text = "Belum Diisi Semua"
                //Toast.makeText(baseContext, "EMAIL ATAU PASSWORD KOSONG", Toast.LENGTH_LONG).show()
            }

           /* val i: Intent = Intent(baseContext, Home::class.java)
            startActivity(i)*/

//            lanjut()
        }
    }
    fun lanjut(){
        val i: Intent = Intent(baseContext, Pesan2::class.java)
        startActivity(i)
    }
    fun isiDataBooking(){

        var uid = intent.getStringExtra("id")

        var no_plat: TextView = findViewById(R.id.platno)
        var conct: TextView = findViewById(R.id.contact)
        var nama: TextView = findViewById(R.id.nama)
        var id: String? = UUID.randomUUID().toString()

        var booking = Booking(no_plat.text.toString(), conct.text.toString(), nama.text.toString(), uid)

        db.child(id!!).setValue(booking)

    }
}
