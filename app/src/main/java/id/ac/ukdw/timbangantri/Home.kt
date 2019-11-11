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

class Home : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        imageView6.setOnClickListener{
            showBengkelTerdekat()
        }

    }

    fun showBengkelTerdekat(){
        var i: Intent = Intent(this, BengkelTerdekat::class.java)
//        i.putExtra()
        startActivity(i)
    }

    }
