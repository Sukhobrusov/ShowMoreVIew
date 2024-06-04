package com.example.viewapplication

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.widget.TextView

class CustomEndLineView : TextView {


	constructor(context: Context) : super(context)

	constructor(context: Context, set: AttributeSet?) : super(context, set)

	constructor(context: Context, set: AttributeSet?, style: Int) : super(context, set, style)


	var drawShowMore: ((text: String) -> Unit)? = null
	var drawShowLess: (() -> Unit)? = null
	var maximumLines = 4

	override fun onDraw(canvas: Canvas) {
		Log.d("TAG", "onDraw: ${layout != null}")
		if (layout != null && layout.lineCount == maximumLines) {
			//last line
			val lastLine = maximumLines - 1
			if (layout.getEllipsisCount(lastLine) != 0) {
				drawShowMore?.invoke(
					text.substring(
						layout.getLineStart( lastLine) until text.length
					)
				)
			}
		}
		else if (layout != null && layout.lineCount > maximumLines) {
			drawShowLess?.invoke()
		}
		super.onDraw(canvas)
	}

	fun showMore() {
		maxLines = Int.MAX_VALUE
	}

	fun showLess() {
		maxLines = maximumLines
	}

}

