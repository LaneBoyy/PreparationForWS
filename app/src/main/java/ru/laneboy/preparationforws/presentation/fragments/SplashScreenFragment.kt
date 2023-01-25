package ru.laneboy.preparationforws.presentation.fragments

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.laneboy.preparationforws.R
import ru.laneboy.preparationforws.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {

    private var _binding: FragmentSplashScreenBinding? = null
    private val binding: FragmentSplashScreenBinding
        get() = _binding ?: throw RuntimeException("FragmentSplashScreenBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val animation =
            AnimatorInflater.loadAnimator(context, R.animator.animator_logo) as AnimatorSet
        animation.setTarget(binding.ivLogo)
        animation.addListener(object : AnimatorListener {
            override fun onAnimationStart(p0: Animator) {
            }

            override fun onAnimationEnd(p0: Animator) {
                launchSignInFragment()
            }

            override fun onAnimationCancel(p0: Animator) {
            }

            override fun onAnimationRepeat(p0: Animator) {
            }
        })
        animation.start()
    }

    private fun launchSignInFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SignInFragment.newInstance())
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance(): SplashScreenFragment {
            return SplashScreenFragment()
        }
    }
}