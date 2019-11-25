package id.ac.ukdw.timbangantri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_home.*

class EditProfile : AppCompatActivity() {

    lateinit var db: DatabaseReference

    lateinit var email: EditText
    lateinit var password: EditText

    var NAME_KEY = "nama_dpn"
    var nm_dpn = ""
    var nm_dpn_new: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        db = FirebaseDatabase.getInstance().getReference("user").child(nm_dpn_new!!)

        db.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(baseContext, "Gagal Databse", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                email.setText(dataSnapshot.child("email").value!!.toString())
                password.setText(dataSnapshot.child("password").value!!.toString())
            }
            }
        )
    }
}

