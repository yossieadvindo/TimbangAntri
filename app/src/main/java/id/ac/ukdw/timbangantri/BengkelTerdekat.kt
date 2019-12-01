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

        val andaMotor = LatLng(-7.787522, 110.378193)
        val sumberBaru = LatLng(-7.783089, 110.388809)
        val gemilangMotor = LatLng(-7.781569, 110.372507)
        val hondaMotor = LatLng(-7.756186, 110.362393)
        val monzaPrima = LatLng(-7.7845342, 110.3904599)

        val marker1: MarkerOptions = MarkerOptions().position(ahasSagan).title("AHASS SAGAN")
        val marker2: MarkerOptions = MarkerOptions().position(ahasJanti).title("AHASS JANTI")
        val marker3: MarkerOptions = MarkerOptions().position(ahasKusumaNeagara).title("AHASS KUSUMA NEGARA")

        val marker4: MarkerOptions = MarkerOptions().position(andaMotor).title("ANDA MOTOR")
        val marker5: MarkerOptions = MarkerOptions().position(sumberBaru).title("SUMBER BARU")
        val marker6: MarkerOptions = MarkerOptions().position(gemilangMotor).title("GEMILANG MOTOR")
        val marker7: MarkerOptions = MarkerOptions().position(hondaMotor).title("HONDA MOTOR")
        val marker8: MarkerOptions = MarkerOptions().position(monzaPrima).title("MONZA MOTOR")

        val zoomLevel = 12.0f
        map.let {
            it!!.addMarker(marker1)
            it!!.addMarker(marker2)
            it!!.addMarker(marker3)

            it!!.addMarker(marker4)
            it!!.addMarker(marker5)
            it!!.addMarker(marker6)
            it!!.addMarker(marker7)
            it!!.addMarker(marker8)

            it.moveCamera(CameraUpdateFactory.newLatLngZoom(ahasSagan, zoomLevel))
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(ahasJanti, zoomLevel))
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(ahasKusumaNeagara, zoomLevel))

            it.moveCamera(CameraUpdateFactory.newLatLngZoom(andaMotor, zoomLevel))
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(sumberBaru, zoomLevel))
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(gemilangMotor, zoomLevel))
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(hondaMotor, zoomLevel))
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(monzaPrima, zoomLevel))
        }

    }

}