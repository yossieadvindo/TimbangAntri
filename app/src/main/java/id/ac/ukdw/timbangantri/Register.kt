package id.ac.ukdw.timbangantri

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import data.User
import kotlinx.android.synthetic.main.sing_up.*

class Register : AppCompatActivity(){
    lateinit var db:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.sing_up)

        db = FirebaseDatabase.getInstance().getReference("user")

//        loginkuy.setOnClickListener {
//            val i: Intent = Intent(baseContext, MainActivity::class.java)
//            startActivity(i)
//        }

        btnDaftar.setOnClickListener {
            if(!edtEmail.text.toString().equals("") && !edtPass.text.toString().equals("") && !txtNamaDepan.text.toString().equals("") &&
                    !txtNamaBlkng.text.toString().equals("") && !txtNoTlp.text.toString().equals("")){
                isiData()
                Toast.makeText(baseContext, "TERDAFTAR", Toast.LENGTH_LONG).show()
                val i = Intent(baseContext, MainActivity::class.java)
                startActivity(i)
            }
            else if(!edtPass.text.toString().equals(edtPassAgain.text.toString())) {
                txtAlert.text = "Pasword tidak sesuai"
            }
            else{
                txtAlert.text = "EMAIL ATAU PASSWORD KOSONG"
                //Toast.makeText(baseContext, "EMAIL ATAU PASSWORD KOSONG", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun isiData(){
        var email: TextView = findViewById(R.id.edtEmail)
        var pass: TextView = findViewById(R.id.edtPass)
        var nama_dep: TextView = findViewById(R.id.txtNamaDepan)
        var nama_belk: TextView = findViewById(R.id.txtNamaBlkng)
        var no_telp: TextView = findViewById(R.id.txtNoTlp)

        var user = User(
            email.text.toString(),
            pass.text.toString(),
            nama_dep.text.toString(),
            nama_belk.text.toString(),
            no_telp.text.toString()
        )

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.text.toString(), pass.text.toString())
            .addOnSuccessListener {
                val uid = FirebaseAuth.getInstance().currentUser!!.uid
                db.child(uid).setValue(user)
            }

    }
}

