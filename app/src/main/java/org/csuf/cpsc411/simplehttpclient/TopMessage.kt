package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class TopMessage(val ctx: Context)
{
    fun generate(): LinearLayout
    {
        //Create linear Layout
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        //SETS THE SMALLER LINEAR LAYOUT TO COLOR BLUE (REST ON TOP OF MAIN LAYOUT)
        layoutObj.setBackgroundColor(Color.WHITE)


        val mParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        mParams.setMargins(20,20,20,20)
        //CREATES THE CLAIM TITLE OBJECT
        var lbl = TextView(ctx)
        lbl.setTextSize(22F)
        lbl.text = "Please Enter Claim Information"
        lbl.gravity = Gravity.CENTER
        lbl.setBackgroundColor(Color.WHITE)
        layoutObj.addView(lbl, mParams)

        return layoutObj
    }
}