package id.ac.ukdw.timbangantri

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import data.Booking

class RiwayatAdapter(val list : ArrayList<Booking>, val context: Context) : RecyclerView.Adapter<RiwayatAdapter.RiwayatHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatAdapter.RiwayatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_booking, parent, false)
        return RiwayatHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RiwayatAdapter.RiwayatHolder, position: Int) {
        val doc = list.get(position)
        holder.No_Plat?.text = doc.no_plat
        holder.Namarcy?.text = doc.nama
        holder.Contactrcy?.text = doc.contact
        holder.No_Plat?.setOnClickListener { Toast.makeText(context, doc.no_plat, Toast.LENGTH_LONG).show() }
    }

    class RiwayatHolder(val view: View): RecyclerView.ViewHolder(view){
        var No_Plat : TextView? = null
        var Namarcy : TextView? = null
        var Contactrcy : TextView? = null

        init{
            No_Plat = view.findViewById(R.id.no_platrcy) as TextView
            Namarcy = view.findViewById(R.id.namarcy)  as TextView
            Contactrcy = view.findViewById(R.id.contactrcy)  as TextView
        }
    }
}