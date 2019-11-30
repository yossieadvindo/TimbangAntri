package id.ac.ukdw.timbangantri

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import data.Riwayat
import kotlinx.android.synthetic.main.activity_riwayat.*

class TampilRiwayat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_riwayat)

        val list: ArrayList<Riwayat> = ArrayList<Riwayat>()
        val riwayatAdapter = RiwayatAdapter(list, this)
        val layoutManager = LinearLayoutManager(this)

        rcyRiwayat.adapter = riwayatAdapter
        rcyRiwayat.layoutManager = layoutManager
        rcyRiwayat.setHasFixedSize(true)

        list.add(Riwayat("Hei Bengkel", "2 Mei 2019", "10:00"))

        riwayatAdapter.notifyDataSetChanged()
    }
}