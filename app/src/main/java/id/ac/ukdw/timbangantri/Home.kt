package id.ac.ukdw.timbangantri

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_booking.*
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    var uid :String = FirebaseAuth.getInstance().currentUser?.uid.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val user = FirebaseAuth.getInstance().currentUser?.email

//        user?.let {
//            val email = user.email
            namaUser.text = user
//        }

        val out = FirebaseAuth.getInstance().signOut()

//        val akun = FirebaseDatabase.getInstance().getReference("user").child("nama_dpn")
//        namaUser.text = akun.toString()

        imageView6.setOnClickListener {
            showBengkelTerdekat()
        }
        imageView10.setOnClickListener {
            showHomeActivity()
            out
        }
        imageView3.setOnClickListener {
            showBooking()
        }
        imageView11.setOnClickListener {
            showListHarga()
        }
        imageView9.setOnClickListener {
            showSetting()
        }
        imgRiwayat.setOnClickListener {
            showRiwayat()
        }

    }

    //Melempar activity lain pada tombol atau image
    fun showSetting(){
        var i: Intent = Intent(this, Setting::class.java)
        i.putExtra("id", uid)
        startActivity(i)
    }
    fun showListHarga(){
        var i: Intent = Intent(this, Pricelist::class.java)
//        i.putExtra()
        startActivity(i)
    }
    fun showBooking(){
        var i: Intent = Intent(this, Pesan::class.java)
        i.putExtra("id", uid)
        startActivity(i)
    }
    fun showBengkelTerdekat() {
        var i: Intent = Intent(this, BengkelTerdekat::class.java)
//        i.putExtra()
        startActivity(i)
    }

    fun showHomeActivity() {
        var i: Intent = Intent(this, MainActivity::class.java)
//        i.putExtra()
        startActivity(i)
    }

    fun showRiwayat(){
        var i: Intent = Intent(this, Riwayat::class.java)
        i.putExtra("id", uid)
        startActivity(i)
    }

}