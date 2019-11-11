package id.ac.ukdw.timbangantri

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login.*

class Register : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sing_up)
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

}
