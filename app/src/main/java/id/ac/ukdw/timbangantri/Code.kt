package id.ac.ukdw.timbangantri

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import kotlinx.android.synthetic.main.activity_code.*

class Code : AppCompatActivity() {

    internal var bitmap: Bitmap?=null
    private var qr: ImageView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code)

        val uid :String = intent.getStringExtra("id")
        val bgkl :String = intent.getStringExtra("bgklantr")
        val nama :String = intent.getStringExtra("namaantr")
        val contact :String = intent.getStringExtra("contactantr")
        val no_plat :String = intent.getStringExtra("noplatantr")
        val tgl :String = intent.getStringExtra("tglantr")
        val jaml :String = intent.getStringExtra("jamantr")
        val service: String = intent.getStringExtra("service")

        var hasil= bgkl+"\n"+nama+"\n"+contact+"\n"+no_plat+"\n"+tgl+"\n"+jaml+"\n"+service
        qr=findViewById(R.id.qrcode) as ImageView
        txtData.text=nama+"\n"+tgl
        try{
            val qrcode = hasil
            bitmap= TextToImageEncode(qrcode)
            qr!!.setImageBitmap(bitmap)
        }catch (e: WriterException){
            e.printStackTrace()
        }

        kembali.setOnClickListener {
            val i = Intent(baseContext, Home::class.java)
            startActivity(i)
            finish()
        }
    }

    @Throws(WriterException::class)
    private fun TextToImageEncode(Value: String): Bitmap? {
        val bitMatrix: BitMatrix
        try {
            bitMatrix = MultiFormatWriter().encode(
                Value,
                BarcodeFormat.QR_CODE,
                1000, 1000, null
            )

        } catch (Illegalargumentexception: IllegalArgumentException) {

            return null
        }

        val bitMatrixWidth = bitMatrix.getWidth()

        val bitMatrixHeight = bitMatrix.getHeight()

        val pixels = IntArray(bitMatrixWidth * bitMatrixHeight)

        for (y in 0 until bitMatrixHeight) {
            val offset = y * bitMatrixWidth

            for (x in 0 until bitMatrixWidth) {

                pixels[offset + x] = if (bitMatrix.get(x, y))
                    Color.BLACK
                else
                    Color.WHITE
            }
        }
        val bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_8888)

        bitmap.setPixels(pixels, 0, 1000, 0, 0, bitMatrixWidth, bitMatrixHeight)
        return bitmap
    }
}
