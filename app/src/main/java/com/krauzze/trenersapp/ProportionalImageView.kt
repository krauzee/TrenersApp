package com.krauzze.trenersapp


import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import com.krauzze.trenersapp.R

class ProportionalImageView : ImageView {

    constructor(context: Context) : super(context) {init(null)}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {init(attrs)}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {init(attrs)}

    private val VERTICAL = 1
    private val HORISONTAL = 2
    private var w = 0
    private var h = 0
    private var proportionalPlan = VERTICAL



    private fun init(attrs: AttributeSet?){
         /*val a= context.obtainStyledAttributes(attrs, R.styleable.ProportionalImageView)

        proportionalPlan = a.getInt(R.styleable.ProportionalImageView_proportional_plane, VERTICAL)
        a.recycle()*/
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val d = drawable
        if (d != null) {

            if(w == 0 && h == 0) {
                when (proportionalPlan) {
                    VERTICAL -> {
                        w = View.MeasureSpec.getSize(widthMeasureSpec)
                        h = w * d.intrinsicHeight / d.intrinsicWidth

//                    println("image $w $h")
                    }
                    HORISONTAL -> {
                        h = View.MeasureSpec.getSize(heightMeasureSpec)
                        w = h * d.intrinsicWidth / d.intrinsicHeight
                    }
                }
            }

            setMeasuredDimension(w, h)
        } else
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }


}