package gurukul.com.firebaseauthentication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            var fAuth = FirebaseAuth.getInstance()
            var task = fAuth.signInWithEmailAndPassword(etEmail.text.toString(),etPass.text.toString())
            task.addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this@MainActivity,"Login Successful",Toast.LENGTH_LONG).show()
                    var i = Intent(this@MainActivity,DatabaseActivity::class.java)
                    startActivity(i)
                }else{
                    Toast.makeText(this@MainActivity,"Login Failed",Toast.LENGTH_LONG).show()
                }
            }
        }

        btnRegister.setOnClickListener {
            var fAuth = FirebaseAuth.getInstance()
            var task = fAuth.createUserWithEmailAndPassword(etEmail.text.toString(),etPass.text.toString())
            task.addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(this@MainActivity,"Register Successful",Toast.LENGTH_LONG).show()
                    var i = Intent(this@MainActivity,DatabaseActivity::class.java)
                    startActivity(i)
                }else{
                    Toast.makeText(this@MainActivity,"Register Failded",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
