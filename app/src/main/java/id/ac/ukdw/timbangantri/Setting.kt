package id.ac.ukdw.timbangantri

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.setting.*

class Setting: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting)

        imgakun.setOnClickListener{
            showAkun()
        }
    }

    fun showAkun(){
        var i: Intent = Intent(this, EditProfile::class.java)
//        i.putExtra()
        startActivity(i)
    }
}