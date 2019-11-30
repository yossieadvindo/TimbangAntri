package id.ac.ukdw.timbangantri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_place_detail.*

class PlaceDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        var namabgkl = intent.getStringExtra("namaBengkel")
        var jambuka= intent.getStringExtra("jambuka")
        var jamtutup = intent.getStringExtra("jamtutup")

        namabengkeldetail.setText(namabgkl);
        bukajam.setText(jambuka)
        tutupjam.setText(jamtutup)

    }
}
