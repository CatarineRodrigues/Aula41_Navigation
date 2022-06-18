package br.com.zup.testenavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.zup.testenavigation.databinding.FragmentTerceiroBinding

class TerceiroFragment : Fragment() {
    private lateinit var binding: FragmentTerceiroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTerceiroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        receberArgumento()
        clicarBotão()

    }

    private fun clicarBotão() {
        binding.btn.setOnClickListener {
            val texto = recuperarDado()
            if (texto != null) {
                findNavController().navigate(
                    TerceiroFragmentDirections.actionTerceiroFragmentToPrimeiroFragment2(
                        texto
                    )
                )
            } else Toast.makeText(context, "Digite algo", Toast.LENGTH_LONG).show()
        }
    }

    private fun recuperarDado(): String {
        var texto = binding.et.text.toString()
        if (texto != null) {
            return texto
        } else return "Texto Padrão"
    }

    private fun receberArgumento() {
        val argumento = TerceiroFragmentArgs.fromBundle(requireArguments())
        binding.text.text = argumento.terceiroParametro.toString()
    }
}