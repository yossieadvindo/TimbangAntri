package id.ac.ukdw.timbangantri

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class BengkelTerdekat: AppCompatActivity(), OnMapReadyCallback {
    private  lateinit var  map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.terdekat)
        val  mapFragment = supportFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera
        val ahasSagan = LatLng(-7.777251, 110.379863)
        val ahasJanti = LatLng(-7.798615, 110.409418)
        val ahasKusumaNeagara = LatLng(-7.802165, 110.393916)
        val marker1: MarkerOptions = MarkerOptions().position(ahasSagan).title("AHASS SAGAN")
        val marker2: MarkerOptions = MarkerOptions().position(ahasJanti).title("AHASS JANTI")
        val marker3: MarkerOptions = MarkerOptions().position(ahasKusumaNeagara).title("AHASS KUSUMA NEGARA")
        val zoomLevel = 12.0f
        map.let {
            it!!.addMarker(marker1)
            it!!.addMarker(marker2)
            it!!.addMarker(marker3)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(ahasSagan, zoomLevel))
        }

    }

}