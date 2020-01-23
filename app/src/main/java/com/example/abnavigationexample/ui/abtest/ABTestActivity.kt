package com.example.abnavigationexample.ui.abtest

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.abnavigationexample.*
import com.example.abnavigationexample.utils.callPrivateFunc
import kotlinx.android.synthetic.main.activity_abtest.*

enum class ABTestVariation(val navGraphRes: Int, val totalNumberOfSteps: Int) {
    BASELINE(R.navigation.baseline_navigation, 4),
    VARIATION1(R.navigation.variant1_navigation, 4),
    VARIATION2(R.navigation.variant2_navigation, 4),
}

class ABTestActivity : AppCompatActivity() {

    private val activityViewModel by viewModels<ActivityViewModel> {
        ActivityViewModel.ActivityViewModelFactory(
            abTestVariation
        )
    }

    private lateinit var abTestVariation: ABTestVariation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abtest)
        abTestVariation =
            intent?.getSerializableExtra(KEY) as? ABTestVariation ?: ABTestVariation.BASELINE
        setupNavigation(abTestVariation.navGraphRes)
        activityViewModel.navEvent.observe(this, Observer {
            handleNavigationEvent(it.getContentIfNotHandled())
        })

    }

    private fun setupNavigation(navGraphId: Int) {
        val myNavHostFragment: NavHostFragment = nav_host_fragment as NavHostFragment
        val inflater = myNavHostFragment.navController.navInflater
        val graph = inflater.inflate(navGraphId)
        myNavHostFragment.navController.setGraph(graph, bundleOf(STEP_BUNDLE_KEY to FIRST_STEP))
    }

    private fun handleNavigationEvent(nextStep: Int?) {
        val stepsCount = findNavController(R.id.nav_host_fragment)
            .callPrivateFunc("getDestinationCountOnBackStack") as? Int

        stepsCount?.let {
            when (it) {
                1 -> findNavController(R.id.nav_host_fragment)
                    .navigate(R.id.action_ended_step1, bundleOf(STEP_BUNDLE_KEY to nextStep))
                2 -> findNavController(R.id.nav_host_fragment)
                    .navigate(R.id.action_ended_step2, bundleOf(STEP_BUNDLE_KEY to nextStep))
                3 -> findNavController(R.id.nav_host_fragment)
                    .navigate(R.id.action_ended_step3, bundleOf(STEP_BUNDLE_KEY to nextStep))
                else -> finish()
            }
        }

      /*  when (nextStep) {
            2 -> findNavController(R.id.nav_host_fragment)
                .navigate(R.id.action_ended_step1, bundleOf(STEP_BUNDLE_KEY to nextStep))
            3 -> findNavController(R.id.nav_host_fragment)
                .navigate(R.id.action_ended_step2, bundleOf(STEP_BUNDLE_KEY to nextStep))
            4 -> findNavController(R.id.nav_host_fragment)
                .navigate(R.id.action_ended_step3, bundleOf(STEP_BUNDLE_KEY to nextStep))
            NO_NEXT_STEP -> finish()
        }*/
    }

    companion object {
        const val KEY = "TestVariation"

        fun startInABTestVariation(context: AppCompatActivity, variation: ABTestVariation) {
            val intent = Intent(context, ABTestActivity::class.java)
            intent.putExtra(KEY, variation)
            context.startActivity(intent)
        }
    }
}