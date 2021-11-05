package com.example.futs.util

import android.view.View


fun View.visible(toShow: Boolean) = if (toShow) {
    this.visibility = View.VISIBLE
} else {
    this.visibility = View.GONE
}

