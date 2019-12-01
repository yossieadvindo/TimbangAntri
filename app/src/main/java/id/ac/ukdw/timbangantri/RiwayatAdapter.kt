package id.ac.ukdw.timbangantri

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import data.Antrian
import data.Booking

class RiwayatAdapter(val list : ArrayList<Antrian>, val context: Context) : RecyclerView.Adapter<RiwayatAdapter.RiwayatHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatAdapter.RiwayatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_booking, parent, false)
        return RiwayatHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: RiwayatAdapter.RiwayatHolder, position: Int) {
        val doc = list.get(position)
        holder.Bgkl?.text = doc.bengkel
        holder.No_plat?.text = doc.no_plat
        holder.Nama?.text = doc.nama
        holder.Contact?.text = doc.contact
        holder.Tgl?.text = doc.tgl
        holder.Waktu?.text = doc.jam
        holder.No_plat?.setOnClickListener { Toast.makeText(context, doc.no_plat, Toast.LENGTH_LONG).show() }
    }

    class RiwayatHolder(val view: View): RecyclerView.ViewHolder(view){
        var Bgkl : TextView? = null
        var No_plat : TextView? = null
        var Nama : TextView? = null
        var Contact : TextView? = null
        var Tgl : TextView? = null
        var Waktu : TextView? = null

        init{
            Bgkl = view.findViewById(R.id.itm_toko) as TextView
            No_plat = view.findViewById(R.id.no_platitm)  as TextView
            Nama = view.findViewById(R.id.namaitm)  as TextView
            Contact = view.findViewById(R.id.contactitm)  as TextView
            Tgl = view.findViewById(R.id.tglitm)  as TextView
            Waktu = view.findViewById(R.id.jamitm)  as TextView
        }
    }
}