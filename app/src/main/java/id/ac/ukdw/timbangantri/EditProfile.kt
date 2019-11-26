package id.ac.ukdw.timbangantri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import data.User
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.login.*

class EditProfile : AppCompatActivity() {

    lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        var uid = intent.getStringExtra("id")

        var edtEmail2: TextView = findViewById(R.id.edtemailep)
        var edtPassword2: TextView = findViewById(R.id.edtpasswordep)
        var edtNamaDepan2: TextView = findViewById(R.id.txtNamaDepanep)
        var edtNamaBelakang2: TextView = findViewById(R.id.txtNamaBlkngep)
        var edtNoHp2: TextView = findViewById(R.id.txtNoTlpep)

        db = FirebaseDatabase.getInstance().getReference("user/$uid")
        db.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(dataSnapshot: DatabaseError) {

            }

            override fun onDataChange(data: DataSnapshot) {
                var user = data.getValue(User::class.java)
                edtEmail2.text =  user!!.Email
                edtPassword2.text =  user!!.Password
                edtNamaDepan2.text = user!!.nama_dpn
                edtNamaBelakang2.text = user!!.nama_blkng
                edtNoHp2.text = user!!.no_tlp
            }

        })

//        val user = FirebaseAuth.getInstance().currentUser
//        user?.let {
//            val uid = user.uid
//            db = FirebaseDatabase.getInstance().getReference("user").child(uid)
//            db.addValueEventListener(object : ValueEventListener {
//                override fun onCancelled(p0: DatabaseError) {
//
//                }
//
//                override fun onDataChange(databaseSnapshot: DataSnapshot) {
//                    edtEmail2.setText(databaseSnapshot.child("email").value!!.toString())
//                    edtPassword2.setText(databaseSnapshot.child("password").value!!.toString())
//
////                    var user = databaseSnapshot.getValue(User::class.java)
////                    edtEmail2.text = user!!.Email as Editable
////                    edtPassword2.text = user!!.Password as Editable
//
//                }
//
//            })
//        }

        btnsaveep.setOnClickListener {
            if(!edtEmail2.text.toString().equals("") && !edtPassword2.text.toString().equals("") && !edtNamaDepan2.text.toString().equals("") &&
                !edtNamaBelakang2.text.toString().equals("") && !edtNoHp2.text.toString().equals("")){

                var user = User(
                    edtEmail2.text.toString(),
                    edtPassword2.text.toString(),
                    edtNamaDepan2.text.toString(),
                    edtNamaBelakang2.text.toString(),
                    edtNoHp2.text.toString()
                )

                db.child(uid).setValue(user)

                Toast.makeText(baseContext, "TERGANTI", Toast.LENGTH_LONG).show()
            }
        }
    }

//    fun gantidong() {
//        var emailEP: TextView = findViewById(R.id.edtemailep)
//        var passEP: TextView = findViewById(R.id.edtpasswordep)
//        var nama_depEP: TextView = findViewById(R.id.txtNamaDepanep)
//        var nama_belkEP: TextView = findViewById(R.id.txtNamaBlkngep)
//        var no_telpEP: TextView = findViewById(R.id.txtNoTlpep)
//
//        var user = User(
//            emailEP.text.toString(),
//            passEP.text.toString(),
//            nama_depEP.text.toString(),
//            nama_belkEP.text.toString(),
//            no_telpEP.text.toString()
//        )
//
//        db.child(uid).setValue(user)
//    }
}

