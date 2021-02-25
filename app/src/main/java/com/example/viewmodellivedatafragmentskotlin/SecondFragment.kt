package com.example.viewmodellivedatafragmentskotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    // Declaración de la propiedad del VM
    var dataViewModel:DataViewModel? = null
    // boton a pulsar
    var buttonChange: Button? = null


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inicialización del objeto del VM
        dataViewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonChange = view.findViewById(R.id.button_change)
        buttonChange?.setOnClickListener{
            Log.d("app","Change data from F2: ${dataViewModel?.count}")
            dataViewModel?.count = dataViewModel?.count?.plus(1)!!
            dataViewModel?.dato?.setValue("Valor Cambiado desde F2: ${dataViewModel?.count}")
        }
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}