package id.ac.ukdw.timbangantri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import data.Antrian
import data.Booking
import kotlinx.android.synthetic.main.activity_riwayat.*

class Riwayat : AppCompatActivity() {
    var list: ArrayList<Antrian> = ArrayList<Antrian>()
    var riwayatAdapter = RiwayatAdapter(list,this)
    var layoutManager = LinearLayoutManager(this)

    lateinit var id: String
    lateinit var db: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat)

        rcyRiwayat.adapter = riwayatAdapter
        rcyRiwayat.layoutManager = layoutManager
        rcyRiwayat.setHasFixedSize(true)

        var uid = intent.getStringExtra("id")

//        db = FirebaseDatabase.getInstance().getReference("booking/$uid")
//            .equalTo(uid) as DatabaseReference
//
//        db.addValueEventListener()

        db = FirebaseDatabase.getInstance().getReference("antrian")
        val listener = object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onDataChange(data: DataSnapshot) {
                val child = data.children
                child.forEach{
                    val at = it.getValue(Antrian::class.java)
                    if(at!!.uid.equals(uid)){
                        list.add(at!!)
                    }
                    riwayatAdapter.notifyDataSetChanged()
                }
            }
        }
        db.addValueEventListener(listener)
    }

}
