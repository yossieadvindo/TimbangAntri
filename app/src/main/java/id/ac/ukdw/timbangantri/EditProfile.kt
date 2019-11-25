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

class EditProfile : AppCompatActivity() {

    lateinit var db: DatabaseReference

    lateinit var edtEmail2: EditText
    lateinit var edtPassword2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        edtEmail2 = findViewById(R.id.edtemail2)
        edtPassword2 = findViewById(R.id.edtpassword2)

//        val uid = FirebaseAuth.getInstance().currentUser!!.uid
//        db = FirebaseDatabase.getInstance().getReference("user/$uid")
//        db.addValueEventListener(object : ValueEventListener{
//            override fun onCancelled(dataSnapshot: DatabaseError) {
//
//            }
//
//            override fun onDataChange(data: DataSnapshot) {
//                var user = data.getValue(User::class.java)
//                edtEmail2.setText(user!!.Email)
//                edtpassword2.setText(user!!.Password)
//            }
//
//        })

        val user = FirebaseAuth.getInstance().currentUser
        user?.let {
            val uid = user.uid
            db = FirebaseDatabase.getInstance().getReference("user").child(uid)
            db.addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(databaseSnapshot: DataSnapshot) {
                    edtEmail2.setText(databaseSnapshot.child("email").value!!.toString())
                    edtPassword2.setText(databaseSnapshot.child("password").value!!.toString())

//                    var user = databaseSnapshot.getValue(User::class.java)
//                    edtEmail2.text = user!!.Email as Editable
//                    edtPassword2.text = user!!.Password as Editable

                }

            })
        }



    }
}

