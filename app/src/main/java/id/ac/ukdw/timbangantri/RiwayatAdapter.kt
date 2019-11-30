package id.ac.ukdw.timbangantri

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import data.Riwayat



class RiwayatAdapter (val list: ArrayList<Riwayat>, val context: Context) : RecyclerView.Adapter<RiwayatAdapter.riwayatHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): riwayatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listriwayat, parent, false)
        return riwayatHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: riwayatHolder, position: Int) {
        val riwayat = list.get(position)
    }

    class riwayatHolder(val view: View): RecyclerView.ViewHolder(view){
        var txtNamaBengkel: TextView? = null
        var txtTanggal: TextView? = null
        var txtJam: TextView? = null

        init {
            txtNamaBengkel= view.findViewById(R.id.txtNamaBngklri) as TextView
            txtTanggal = view.findViewById(R.id.txtTanggalri) as TextView
            txtJam = view.findViewById(R.id.txtJamri)
        }
    }
}