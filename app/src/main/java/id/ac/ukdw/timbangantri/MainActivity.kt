package id.ac.ukdw.timbangantri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
//        btnLogin.setOnClickListener({login(emailLogin.text.toString(), passwordLogin.text.toString())})
//        txtsignup.setOnClickListener({showRegisterActivity()})

        btnLogin.setOnClickListener {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(
                  emailLogin.text.toString(), passwordLogin.text.toString())
                    .addOnCompleteListener {
                        Toast.makeText(baseContext, "Login Berhasil", Toast.LENGTH_LONG).show()
                        val i:Intent = Intent(baseContext, Home::class.java)
                        startActivity(i)
                    }
                    .addOnFailureListener {
                        Toast.makeText(baseContext, "Login Gagal", Toast.LENGTH_LONG).show()
                    }
        }

        txtsignup.setOnClickListener{
            val i:Intent = Intent(baseContext, Register::class.java)
            startActivity(i)
        }

    }

//    fun login(email: String, password:String){
//        if (email.equals("coba@gmail.com") && password.equals("1234")){
//            showHomeActivity()
//        }else{
//            Toast.makeText(this, "Login Gagal", Toast.LENGTH_LONG).show()
//        }
//    }
//
//    fun showHomeActivity(){
//        var i: Intent = Intent(this, Home::class.java)
////        i.putExtra()
//        startActivity(i)
//    }
//
//    fun showRegisterActivity(){
//        var i: Intent = Intent(this, Register::class.java)
////        i.putExtra()
//        startActivity(i)
//    }

}
