package com.example.viewapplication

import android.content.Context
import android.util.AttributeSet
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams

class CanvasHoldingView : ConstraintLayout {


	constructor(context: Context) : super(context)

	constructor(context: Context, set: AttributeSet?) : super(context, set)

	constructor(context: Context, set: AttributeSet?, style: Int) : super(context, set, style)

	val fixedView: CustomEndLineView
	val container: ScrollView

	init {
		inflate(context, R.layout.last_line_view, this)
		fixedView = findViewById(R.id.fixedView)
		container = findViewById(R.id.scroll)
		val lastLine = findViewById<TextView>(R.id.textView)
		val showMore = findViewById<TextView>(R.id.showMoreView)
		val showLess = findViewById<TextView>(R.id.showLessView)

		fixedView.drawShowMore = {
			container.updateLayoutParams {
				this.height = LayoutParams.WRAP_CONTENT
			}
			showLess.isVisible = false
			lastLine.isVisible = true
			showMore.isVisible = true
			lastLine.text = it
		}
		fixedView.drawShowLess = {
			container.updateLayoutParams<LayoutParams> {
				this.height = LayoutParams.MATCH_CONSTRAINT
			}
			showLess.isVisible = true
			showMore.isVisible = false
			lastLine.isVisible = false
		}

		showMore.setOnClickListener {
			fixedView.showMore()
		}

		showLess.setOnClickListener {
			fixedView.showLess()
		}
	}

	fun setText(text: String) {
		fixedView.text = text
	}

}