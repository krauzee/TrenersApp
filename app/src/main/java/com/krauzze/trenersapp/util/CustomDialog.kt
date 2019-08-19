package com.krauzze.trenersapp.util

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import kotlinx.android.synthetic.main.dialog_base.*
import com.krauzze.trenersapp.R

class CustomDialog(
    val title: String,
    val message: String,
    val buttonText: String,
    val action: () -> Unit,
    val type: Int,
    context: Context,
    theme: Int
) : Dialog(context, theme) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_base)
        title_view.text = title
        message_view.text = message
        reload.text = buttonText
        reload.setOnClickListener {
            action.invoke()
            cancel()
        }

    }
}