package id.ac.ukdw.timbangantri

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import data.Place
import kotlinx.android.synthetic.main.place.*
import java.util.Locale.filter


class placeActivity : AppCompatActivity() {
    lateinit var db: DatabaseReference
    var uid = FirebaseAuth.getInstance().currentUser?.uid.toString()
    var list: ArrayList<Place> = ArrayList<Place>()
    val placeAdapter = PlaceAdapter(list,this, uid)
    val layoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.place)
        rcyPlace.adapter = placeAdapter
        rcyPlace.layoutManager = layoutManager
        rcyPlace.setHasFixedSize(true)

        //membuat data dummy
        db = FirebaseDatabase.getInstance().getReference("Bengkel")
        val listener = object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) { //
            }

            override fun onDataChange(data: DataSnapshot) {
                val child = data.children
                child.forEach {
                    val bengkel = it.getValue(Place::class.java)
                    list.add(bengkel!!)
                }
                placeAdapter.notifyDataSetChanged()
            }
        }
        db.addValueEventListener(listener)
        txtSearcuBengkel.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filter(s.toString());
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })


    }

    fun filter(search: String){
        var filterList: ArrayList<Place> = ArrayList<Place>()
        for(bengkel:Place in list){
            if(bengkel.nama_bengkel.toLowerCase().contains(search.toLowerCase())){
                filterList.add(bengkel)
            }
        }
        placeAdapter.filterList(filterList)
    }
}