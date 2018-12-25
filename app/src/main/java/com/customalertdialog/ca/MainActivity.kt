package com.customalertdialog.ca

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showDialog()

        btTryAgain.setOnClickListener{ showDialog() }
    }

    fun showDialog(){
        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.custon_dialog, null)
        val edName = dialogView.findViewById<EditText>(R.id.edName)
        dialog.setView(dialogView)
        dialog.setCancelable(false)
        dialog.setPositiveButton(getString(R.string.button_send)) { dialogInterface: DialogInterface?, i: Int ->  }
        val customDialog = dialog.create()
        customDialog.show()
        customDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            if(edName.text.length > 2)
                customDialog.dismiss()
            else
                Toast.makeText(baseContext, getString(R.string.error_message), Toast.LENGTH_LONG).show()
        }
    }
}
