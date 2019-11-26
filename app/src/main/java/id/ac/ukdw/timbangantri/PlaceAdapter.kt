package id.ac.ukdw.timbangantri

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import data.Place

class PlaceAdapter(var list : ArrayList<Place>, val context: Context) : RecyclerView.Adapter<PlaceAdapter.PlaceHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceAdapter.PlaceHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_adapter, parent, false)
        return PlaceHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PlaceAdapter.PlaceHolder, position: Int) {
        val bengkel = list.get(position)
        holder.txtNamaBengkel?.text = bengkel.nama_bengkel
        holder.txtJdwlv?.text = bengkel.jam_buka + " - " + bengkel.jam_tutup
        holder.clickRelative?.setOnClickListener {
            var i : Intent = Intent(context, placeActivity::class.java)
            context.startActivity(i)
        }
    }

    fun filterList(filteredList: ArrayList<Place>){
        list = filteredList
        notifyDataSetChanged()
    }

    class PlaceHolder(val view: View): RecyclerView.ViewHolder(view){
        var txtNamaBengkel : TextView? = null
        var txtJdwlv : TextView? = null
        var clickRelative : RelativeLayout? = null

        init{
            txtNamaBengkel = view.findViewById(R.id.txtNamaBengkel) as TextView
            txtJdwlv = view.findViewById(R.id.txtJam)  as TextView
            clickRelative = view.findViewById(R.id.relativeList) as RelativeLayout
        }
    }
}