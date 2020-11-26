package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class LableColumnGenerator(val ctx : Context) {

    fun generate() : LinearLayout {

        //LINEAR FOR THE OBJECTS TO BE PLACED ON
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL

        //SETS THE LOBJ TO WHITE
        layoutObj.setBackgroundColor(Color.WHITE)
        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 1.0F

        //CREATES THE CLAIM TITLE OBJECT
        var lbl = TextView(ctx)
        lbl.setTextSize(19F)
        lbl.text = "Claim Title"
        lbl.gravity = Gravity.CENTER
        lbl.setBackgroundColor(Color.WHITE)
        layoutObj.addView(lbl, lbParams)

        //CREATED THE DATE OBJECT
        lbl = TextView(ctx)
        lbl.setTextSize(20F)
        lbl.gravity = Gravity.CENTER
        lbl.text = "Date "
        lbl.setBackgroundColor(Color.WHITE)
        layoutObj.addView(lbl, lbParams)

        return layoutObj
    }
}