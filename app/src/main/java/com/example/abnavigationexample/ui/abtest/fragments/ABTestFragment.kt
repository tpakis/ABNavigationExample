package com.example.abnavigationexample.ui.abtest.fragments

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.abnavigationexample.STEP_BUNDLE_KEY
import com.example.abnavigationexample.UNKNOWN_STEP
import com.example.abnavigationexample.ui.abtest.ActivityViewModel

abstract class ABTestFragment : Fragment() {

    val activityViewModel: ActivityViewModel by lazy {
        ViewModelProvider(requireActivity())[ActivityViewModel::class.java]
    }

    val stepNumber: Int
        get() = arguments?.getInt(STEP_BUNDLE_KEY, UNKNOWN_STEP) ?: UNKNOWN_STEP

}