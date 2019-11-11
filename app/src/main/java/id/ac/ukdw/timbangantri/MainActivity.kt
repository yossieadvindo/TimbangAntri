package id.ac.ukdw.timbangantri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btnLogin.setOnClickListener({login(emailLogin.text.toString(), passwordLogin.text.toString())})
        txtsignup.setOnClickListener({showRegisterActivity()})
    }

    fun login(email: String, password:String){
        if (email.equals("coba@gmail.com") && password.equals("1234")){
            showHomeActivity()
        }else{
            Toast.makeText(this, "Login Gagal", Toast.LENGTH_LONG).show()
        }
    }

    fun showHomeActivity(){
        var i: Intent = Intent(this, Home::class.java)
//        i.putExtra()
        startActivity(i)
    }

    fun showRegisterActivity(){
        var i: Intent = Intent(this, Register::class.java)
//        i.putExtra()
        startActivity(i)
    }

}
