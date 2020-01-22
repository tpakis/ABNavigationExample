package com.example.abnavigationexample.ui.abtest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.abnavigationexample.R
import kotlinx.android.synthetic.main.fragment_step2_baseline.button

class Step2Fragment : ABTestFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_step2_baseline, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.text = resources.getString(R.string.end_step, stepNumber)
        button.setOnClickListener {
            activityViewModel.endedStepNavigateToNext(stepNumber)
        }
    }
}