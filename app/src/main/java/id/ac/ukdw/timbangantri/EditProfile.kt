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
    var edtEmail2: TextView = findViewById(R.id.edtemailep)
    var edtPassword2: TextView = findViewById(R.id.edtpasswordep)
    var edtNamaDepan2: TextView = findViewById(R.id.txtNamaDepanep)
    var edtNamaBelakang2: TextView = findViewById(R.id.txtNamaBlkngep)
    var edtNoHp2: TextView = findViewById(R.id.txtNoTlpep)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        var uid = intent.getStringExtra("id")
        db = FirebaseDatabase.getInstance().getReference("user/$uid")
        db.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(dataSnapshot: DatabaseError) {

            }

            override fun onDataChange(data: DataSnapshot) {
                var user = data.getValue(User::class.java)
////                edtEmail2.setText(user!!.Email)
                edtEmail2.text =  user!!.Email
////                edtPassword2.setText(user!!.Password)
                edtPassword2.text =  user!!.Password
                //txtNamaDepan2.text = user!!.Email
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


        fun updateprofil(){
            var user = User(
                edtEmail2.toString(),
                edtPassword2.toString(),
                edtNamaDepan2.toString(),
                edtNamaBelakang2.toString(),
                edtNoHp2.toString()
            )
        }
    }
}

