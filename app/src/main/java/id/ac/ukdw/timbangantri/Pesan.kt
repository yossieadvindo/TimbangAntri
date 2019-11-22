package id.ac.ukdw.timbangantri

//import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import data.Booking
import kotlinx.android.synthetic.main.activity_booking.*

class Pesan : AppCompatActivity() {
    lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        db = FirebaseDatabase.getInstance().getReference("booking")

        btnPesan.setOnClickListener {
            if(!platno.text.toString().equals("") && !contact.text.toString().equals("") && !nama.text.toString().equals("")){
                isiDataBooking()
                Toast.makeText(baseContext, "Kirim Pesanan", Toast.LENGTH_LONG).show()
            }
            else{
                txtKrgBk.text = "Belum Diisi Semua"
                //Toast.makeText(baseContext, "EMAIL ATAU PASSWORD KOSONG", Toast.LENGTH_LONG).show()
            }
            val i: Intent = Intent(baseContext, Home::class.java)
            startActivity(i)
        }
    }

    fun isiDataBooking(){
        var no_plat: TextView = findViewById(R.id.platno)
        var conct: TextView = findViewById(R.id.contact)
        var nama: TextView = findViewById(R.id.nama)

        var booking =
            Booking(no_plat.text.toString(), conct.text.toString(), nama.text.toString())
        db.child(no_plat.text.toString()).setValue(booking)
    }
}
