package id.ac.ukdw.timbangantri

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        imageView6.setOnClickListener {
            showBengkelTerdekat()
        }
        imageView10.setOnClickListener {
            showHomeActivity()
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
    }
    fun showSetting(){
        var i: Intent = Intent(this, Setting::class.java)
//        i.putExtra()
        startActivity(i)
    }
    fun showListHarga(){
        var i: Intent = Intent(this, Pricelist::class.java)
//        i.putExtra()
        startActivity(i)
    }
    fun showBooking(){
        var i: Intent = Intent(this, Pesan::class.java)
//        i.putExtra()
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

}