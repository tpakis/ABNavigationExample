package com.example.abnavigationexample

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.abnavigationexample.ui.abtest.ABTestActivity
import com.example.abnavigationexample.ui.abtest.ABTestVariation

class MainActivity : AppCompatActivity() {

    private val buttonBaseline: Button by bindView(R.id.button_go_to_baseline)
    private val buttonVariant1: Button by bindView(R.id.button_go_to_variant1)
    private val buttonVariant2: Button by bindView(R.id.button_go_to_variant2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonBaseline.setOnClickListener {
            goToABTest(ABTestVariation.BASELINE)
        }
        buttonVariant1.setOnClickListener {
            goToABTest(ABTestVariation.VARIATION1)
        }
        buttonVariant2.setOnClickListener {
            goToABTest(ABTestVariation.VARIATION2)
        }
    }

    private fun goToABTest(variation: ABTestVariation) {
        ABTestActivity.startInABTestVariation(this, variation)
    }

}
