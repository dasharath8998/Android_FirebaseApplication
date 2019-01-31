package gurukul.com.firebaseauthentication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_database.*

class DatabaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        btnSubmit.setOnClickListener {
            var fDatabase = FirebaseDatabase.getInstance()
            var fRef = fDatabase.getReference("students")
            var uid = FirebaseAuth.getInstance().uid
            var ref_child = fRef.child(uid!!)
            ref_child.child("Id").setValue(etStudentId.text.toString())
            ref_child.child("Name").setValue(etStudentName.text.toString())
            ref_child.child("Gender").setValue(etStudentGender.text.toString())
            ref_child.child("Mno").setValue(etStudentMno.text.toString())
            ref_child.child("Address").setValue(etStudentAdd.text.toString())

            var i = Intent(this@DatabaseActivity,ProfileActivity::class.java)
            startActivity(i)
        }
    }
}
