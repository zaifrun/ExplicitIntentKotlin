package org.pondar.explicitintentkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_b.*


class ActivityB : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        //notice use of Elvis operator
        val extras = intent.extras ?: return
        val qString = extras.getString(Constants.QUESTION_KEY)
        if (qString!=null)
            textView1.text = qString
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
