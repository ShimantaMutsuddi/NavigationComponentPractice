package com.chutyrooms.navigationcomponentpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

import com.chutyrooms.navigationcomponentpractice.databinding.FragmentFirstBinding
import com.chutyrooms.navigationcomponentpractice.databinding.FragmentSecondBinding


class SecondFragment : Fragment()
{
    val args:SecondFragmentArgs by navArgs()
    private var _binding: FragmentSecondBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myNumber= args.number
        binding.two.text=myNumber.toString()
        binding.two.setOnClickListener {
            it.findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}