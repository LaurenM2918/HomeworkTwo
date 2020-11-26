package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class ValueColumnGenerator(val ctx : Context) {
    fun generate() : LinearLayout {

        //CREATES THE LINEAR LAYOUT TO PLACE THE OBJECTS
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        //SETS THE SMALLER LINEAR LAYOUT TO COLOR BLUE (REST ON TOP OF MAIN LAYOUT)
        layoutObj.setBackgroundColor(Color.BLUE)


        //USED TO CREATE THE TEXT FIELDS TO ENTER INFO
        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)


        //CREATES SPACE BETWEEN THE VPARAMS OBJECTS (blue lines)
        vParams.bottomMargin = 5

        //CREATES THE INPUT FIELD FOR CLAIM TITLE
        var value = EditText(ctx)
        value.id= R.id.claim_title
        value.setHint("Enter Title")
        value.setBackgroundColor(Color.LTGRAY)
        //THIS ADDS TO THE FIELD TO THE MAIN LAYOUT
        layoutObj.addView(value, vParams)

        //CREATES THE INPUT FIELD FOR THE DATE
        value = EditText(ctx)
        value.id = R.id.claim_date
        value.setHint("DD-MM-YYYY")
        value.setBackgroundColor(Color.LTGRAY)
        layoutObj.addView(value, vParams)


        return layoutObj
    }
}