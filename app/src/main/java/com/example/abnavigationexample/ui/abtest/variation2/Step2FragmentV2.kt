package com.example.abnavigationexample.ui.abtest.variation2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.abnavigationexample.R
import com.example.abnavigationexample.ui.abtest.ActivityViewModel
import com.example.abnavigationexample.ui.abtest.fragments.ABTestFragment
import kotlinx.android.synthetic.main.fragment_step2_variant2.*

class Step2FragmentV2 : ABTestFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_step2_variant2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.text = resources.getString(R.string.end_step, stepNumber)
        button.setOnClickListener {
            activityViewModel.endedStepNavigateToNext(stepNumber)
        }
    }
}