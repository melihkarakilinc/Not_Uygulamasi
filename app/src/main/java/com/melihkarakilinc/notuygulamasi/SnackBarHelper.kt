package com.melihkarakilinc.notuygulamasi

import android.view.View
import com.google.android.material.snackbar.Snackbar

public fun SnackBarHelper(view:View, text:String) {
    view?.let {
        Snackbar.make(
            it,
            text,
            Snackbar.LENGTH_SHORT
        ).show()
    }
}