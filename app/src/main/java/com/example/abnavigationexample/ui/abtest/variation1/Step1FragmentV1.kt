package com.example.abnavigationexample.ui.abtest.variation1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.abnavigationexample.R
import com.example.abnavigationexample.bindView
import com.example.abnavigationexample.ui.abtest.fragments.ABTestFragment

class Step1FragmentV1 : ABTestFragment() {

    private val button: Button by bindView(R.id.button)
    private val button2: Button by bindView(R.id.button2)
    private var buttonLeak: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_step1_variant1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    // both of these will leak View if not null onDestroyView
        // buttonLeak = view.findViewById(R.id.button2)
        // buttonLeak = button2
        button.text = resources.getString(R.string.end_step, stepNumber)
        button.setOnClickListener {
            activityViewModel.endedStepNavigateToNext(stepNumber)
        }
    }
}