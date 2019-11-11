package id.ac.ukdw.timbangantri

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        logOut.setOnClickListener({showHomeActivity()})
    }

    fun showHomeActivity(){
        var i: Intent = Intent(this, MainActivity::class.java)
//        i.putExtra()
        startActivity(i)
    }
}