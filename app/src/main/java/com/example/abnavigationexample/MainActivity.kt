package com.example.abnavigationexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.abnavigationexample.ui.abtest.ABTestActivity
import com.example.abnavigationexample.ui.abtest.ABTestVariation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_go_to_baseline.setOnClickListener {
            goToABTest(ABTestVariation.BASELINE)
        }
        button_go_to_variant1.setOnClickListener {
            goToABTest(ABTestVariation.VARIATION1)
        }
        button_go_to_variant2.setOnClickListener {
            goToABTest(ABTestVariation.VARIATION2)
        }
    }

    private fun goToABTest(variation: ABTestVariation) {
        ABTestActivity.startInABTestVariation(this, variation)
    }

}
