package com.example.atrapalacabra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TableLayout
import android.widget.TableRow
import androidx.navigation.fragment.findNavController
import com.example.atrapalacabra.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            val botonCerco8 = requireActivity().findViewById<ImageButton>(R.id.imageButtoncerco8)
            val botonCerco1 = requireActivity().findViewById<ImageButton>(R.id.imageButtoncerco1)
            val botonCerco2 = requireActivity().findViewById<ImageButton>(R.id.imageButtoncerco2)
            val botonPasto1 = requireActivity().findViewById<ImageButton>(R.id.imageButtonpasto1)
            val botonCerco7 = requireActivity().findViewById<ImageButton>(R.id.imageButtoncerco7)
            val botonRef = requireActivity().findViewById<ImageButton>(R.id.imageButtoninvisible)
            val botonCerco3 = requireActivity().findViewById<ImageButton>(R.id.imageButtoncerco3)
            val botonCabra = requireActivity().findViewById<ImageButton>(R.id.imageButtoncabra)
            val botonCerco6 = requireActivity().findViewById<ImageButton>(R.id.imageButtoncerco6)
            val botonCerco5 = requireActivity().findViewById<ImageButton>(R.id.imageButtoncerco5)
            val botonCerco4 = requireActivity().findViewById<ImageButton>(R.id.imageButtoncerco4)
            val botonPasto2 = requireActivity().findViewById<ImageButton>(R.id.imageButtonpasto2)
            val layoutTabla0 = requireActivity().findViewById<TableRow>(R.id.Tabla0)
            val layoutTabla1 = requireActivity().findViewById<TableRow>(R.id.Tabla1)
            val layoutTabla2 = requireActivity().findViewById<TableRow>(R.id.Tabla2)
            layoutTabla0.removeAllViews()
            layoutTabla1.removeAllViews()
            layoutTabla2.removeAllViews()
            layoutTabla0.addView(botonCerco8)
            layoutTabla0.addView(botonCerco1)
            layoutTabla0.addView(botonCerco2)
            layoutTabla0.addView(botonPasto1)
            layoutTabla1.addView(botonCerco7)
            layoutTabla1.addView(botonRef)
            layoutTabla1.addView(botonCerco3)
            layoutTabla1.addView(botonCabra)
            layoutTabla2.addView(botonCerco6)
            layoutTabla2.addView(botonCerco5)
            layoutTabla2.addView(botonCerco4)
            layoutTabla2.addView(botonPasto2)
            (requireActivity() as MainActivity).reset()
            //findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}