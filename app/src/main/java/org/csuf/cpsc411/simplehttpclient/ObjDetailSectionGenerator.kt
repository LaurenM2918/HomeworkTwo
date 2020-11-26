package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.LinearLayout

class ObjDetailSectionGenerator(val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {
        //CREATE THE MAIN LINEAR LAYOUT THE OBJECTS ARE PLACED ON (VALUE COLUMN & LABEL COLUMN)
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.HORIZONTAL
        //SETS THE COLOR TO WHITE
        layoutObj.setBackgroundColor(Color.WHITE)


        //ADDS THE CLAIM AND DATE ONTO THE LINEAR OBJECT
        val lcParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        val colGenerator = LableColumnGenerator(ctx)
        var lblView = colGenerator.generate()
        lcParams.weight = 1.0F
        layoutObj.addView(lblView, lcParams)

        //ADDS THE INPUT FOR CLAIM TITLE AND DATE
        val valGenerator = ValueColumnGenerator(ctx)
        val vcParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lblView = valGenerator.generate()
        vcParams.marginStart = 5
        vcParams.weight = 3.0F
        layoutObj.addView(lblView, vcParams)


        return layoutObj
    }
}