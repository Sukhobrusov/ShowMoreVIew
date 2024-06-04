package com.example.viewapplication

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.text.TextPaint
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import com.example.viewapplication.databinding.MainActivityBinding

class MainActivity : Activity() {

	private var binding: MainActivityBinding? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = MainActivityBinding.inflate(layoutInflater)
		setContentView(binding!!.root)
	}

	override fun onResume() {
		super.onResume()


		binding?.view?.setText("" +
			"Instead, pass the AttributeSet to obtainStyledAttributes(). This method passes back a TypedArray array of values that are already dereferenced and styled.\n" +
			"The Android resource compiler does a lot of work for you to make calling obtainStyledAttributes() easier. For each <declare-styleable> resource in the res/ directory, the generated R.java defines both an array of attribute IDs and a set of constants that define the index for each attribute in the array. You use the predefined constants to read the attributes from the TypedArray. Here")
	}
}