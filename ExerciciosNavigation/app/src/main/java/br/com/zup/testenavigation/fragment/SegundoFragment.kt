package br.com.zup.testenavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.zup.testenavigation.databinding.FragmentSegundoBinding
import br.com.zup.testenavigation.model.ValoresNumero

class SegundoFragment : Fragment() {
    private lateinit var binding: FragmentSegundoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSegundoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        receberArgumento()
        clicarBotão()
    }

    private fun clicarBotão() {
        binding.btn.setOnClickListener {
            val numero = recuperarDado()
            if (numero != null) {
                findNavController().navigate(
                    SegundoFragmentDirections.actionSegundoFragmentToTerceiroFragment2(
                        numero
                    )
                )
            }
        }
    }

    private fun recuperarDado(): ValoresNumero {
        val numeroDigitado = binding.et.text.toString()
        if (numeroDigitado != null) {
            return ValoresNumero(numeroDigitado.toDouble())
        } else Toast.makeText(context, "Digite algo", Toast.LENGTH_LONG).show()
        return ValoresNumero(0.0)
    }

    private fun receberArgumento() {
        val argumento = SegundoFragmentArgs.fromBundle(requireArguments())
        binding.textInteiro.text = argumento.segundoParametroI.toString()
        binding.tvBolean.text = argumento.segundoParametroB.toString()
    }
}
