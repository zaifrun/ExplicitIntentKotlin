package org.pondar.explicitintentkotlin

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_a.*
import org.pondar.explicitintentkotlin.databinding.ActivityABinding

class ActivityA : AppCompatActivity() {
    private val REQUEST_CODE = 5


    lateinit var binding : ActivityABinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityABinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val returnString = data?.extras!!.getString(Constants.RETURN_KEY)
            binding.textView1.text = returnString
        }
    }


    //The view parameter needs to be her for this
    //to be a onClick method
    fun onClick(view : View) {

        //startActivity(i);
        //if we want the result then we need the four last
        //lines, but if we do not care about the result
        //we can use one line of code shown above
        val i = Intent(this, ActivityB::class.java)
        val myString = editText1.text.toString()
        i.putExtra("qString", myString)
        startActivityForResult(i, REQUEST_CODE)

    }


}
