package id.ac.ukdw.timbangantri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_home.*

class EditProfile : AppCompatActivity() {

    lateinit var db: DatabaseReference

    lateinit var edtEmail2: EditText
    lateinit var edtpassword2: EditText

    var NAME_KEY = "nama_dpn"
    var nm_dpn = ""
    var nm_dpn_new: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        edtEmail2 = findViewById(R.id.edtemail2)
        edtpassword2 = findViewById(R.id.edtpassword2)

        val user = FirebaseAuth.getInstance().currentUser
        user?.let {
            val uid = user.uid
            db = FirebaseDatabase.getInstance().getReference("user").child(uid)

            db.addValueEventListener(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(databaseSnapshot: DataSnapshot) {
                    edtEmail2.setText(databaseSnapshot.child("email").value!!.toString())
                    edtpassword2.setText(databaseSnapshot.child("password").value!!.toString())
                }

            })
//
        }

    }
}

