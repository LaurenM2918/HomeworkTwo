package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView


class ObjDetailScreenGenerator(val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {

        // 1. Create a linearLayout object
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)


        //Add the Claim Info Message
        val titleParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        val tGenerator = TopMessage(ctx)
        var lbView = tGenerator.generate()
        titleParams.gravity = Gravity.CENTER
        layoutObj.addView(lbView,titleParams )


        // 2. Add ObjDetailSection
        val fldRowGenerator = ObjDetailSectionGenerator(ctx)
        val colView = fldRowGenerator.generate()
        layoutObj.addView(colView)


        // 3. Add Next Button LinearLayout
        val nLayout = LinearLayout(ctx)
        val nParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        // only applied to height now
        nParams.gravity = Gravity.RIGHT
        nLayout.layoutParams = nParams
        nLayout.orientation = LinearLayout.HORIZONTAL
       nLayout.setBackgroundColor(Color.BLUE)

        val nButton = Button(ctx)
        nButton.text = "Add"
        nButton.setId(R.id.add_btn)
        nButton.setBackgroundColor(Color.WHITE)
        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nbParams.bottomMargin = 2
        nbParams.topMargin =5
        nbParams.leftMargin=5
        nbParams.rightMargin =3
        nbParams.gravity = Gravity.BOTTOM
        nLayout.addView(nButton, nbParams)
        layoutObj.addView(nLayout, nParams)

        //This Creates the Status Label
       var label = TextView(ctx)
        label.text = "Status Message: Nil"
        label.gravity = Gravity.LEFT
        label.setTextSize(20F)
        label.setTextColor(Color.BLUE)
        label.setBackgroundColor(Color.CYAN)
        label.id = R.id.status_msg
        layoutObj.addView(label, nParams)

        return layoutObj

    }
}