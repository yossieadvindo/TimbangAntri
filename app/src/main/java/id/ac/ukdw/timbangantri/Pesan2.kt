package id.ac.ukdw.timbangantri

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.jhonnyx2012.horizontalpicker.DatePickerListener
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker

import kotlinx.android.synthetic.main.activity_booking.*
import org.joda.time.DateTime
import java.util.*


class Pesan2: AppCompatActivity(), DatePickerListener {
    override fun onDateSelected(dateSelected: DateTime?) {
        Toast.makeText(this,dateSelected.toString(),Toast.LENGTH_LONG).show()
    }

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking2)

        val picker: HorizontalPicker = findViewById(R.id.datePicker) as HorizontalPicker

        picker
            .setListener(this)
            .init();
        
    }
}