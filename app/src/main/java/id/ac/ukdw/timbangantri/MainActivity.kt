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
        btnLogin.setOnClickListener {
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(emailLogin.text.toString(), passwordLogin.text.toString())
                .addOnSuccessListener  {
                    Toast.makeText(baseContext, "berhasil login", Toast.LENGTH_LONG).show()
                    val i: Intent = Intent(baseContext, Home::class.java)
                    startActivity(i)
                }.addOnFailureListener {
                    //FirebaseAuth.getInstance().createUserWithEmailAndPassword(edtEmail.text.toString(), edtPassword.text.toString())
                    Toast.makeText(baseContext, "berhasil gagal", Toast.LENGTH_LONG).show()
                }

        }

        txtsignup.setOnClickListener({showRegisterActivity()})

    }


    fun showRegisterActivity(){
        var i: Intent = Intent(this, Register::class.java)
//        i.putExtra()
        startActivity(i)
    }

}
