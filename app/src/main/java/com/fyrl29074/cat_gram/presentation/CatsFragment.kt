package com.fyrl29074.cat_gram.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnLayout
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

        binding.recyclerView.doOnLayout {

            binding.recyclerView.adapter = catAdapter

            viewModel.cats.onEach {
                catAdapter.submitData(it)
            }.launchIn(viewLifecycleOwner.lifecycleScope)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}