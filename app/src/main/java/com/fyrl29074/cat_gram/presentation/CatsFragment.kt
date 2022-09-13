package com.fyrl29074.cat_gram.presentation

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.fyrl29074.cat_gram.databinding.FragmentCatsBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CatsFragment : Fragment() {

    private var _binding: FragmentCatsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CatsViewModel by viewModels()

//    private val screenPixelDensity: Float? = context?.resources?.displayMetrics?.density
//
//    private val screenWidthInPixels = resources.displayMetrics.widthPixels
//    private val screenHeightInPixels = resources.displayMetrics.heightPixels

//    private val catAdapter = CatAdapter(
//        screenPixelDensity,
//        screenWidthInPixels.toFloat(),
//        screenHeightInPixels.toFloat()
//    )

    private val catAdapter = CatAdapter()

    companion object {
        fun newInstance() = CatsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = catAdapter

        viewModel.cats.onEach {
            catAdapter.submitData(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}