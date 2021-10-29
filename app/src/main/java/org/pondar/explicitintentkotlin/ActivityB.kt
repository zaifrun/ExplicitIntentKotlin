package org.pondar.explicitintentkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_b.*
import org.pondar.explicitintentkotlin.databinding.ActivityABinding
import org.pondar.explicitintentkotlin.databinding.ActivityBBinding


class ActivityB : AppCompatActivity() {

    lateinit var binding : ActivityBBinding


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //notice use of Elvis operator
        val extras = intent.extras ?: return
        val qString = extras.getString(Constants.QUESTION_KEY)
        if (qString!=null)
            binding.textView1.text = qString
    }

    fun onClick(view: View) {
        finish()
    }

    override fun finish() {
        val data = Intent()
        val returnString = editText1.text.toString()
        data.putExtra(Constants.RETURN_KEY, returnString)
        setResult(Activity.RESULT_OK, data)
        super.finish()
    }
}
