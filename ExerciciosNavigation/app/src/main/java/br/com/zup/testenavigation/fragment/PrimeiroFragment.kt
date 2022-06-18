package br.com.zup.testenavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.zup.testenavigation.R
import br.com.zup.testenavigation.databinding.FragmentPrimeiroBinding

class PrimeiroFragment : Fragment() {
    private lateinit var binding: FragmentPrimeiroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrimeiroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clicarBotão()
    }

    private fun clicarBotão() {
        binding.btn.setOnClickListener {
            val numero = recuperarDado()
            if (numero != null) {
                findNavController().navigate(
                    PrimeiroFragmentDirections.actionPrimeiroFragmentToSegundoFragment(
                        numero,
                        false
                    )
                )
            }
        }
    }

    private fun recuperarDado(): Int {
        var numero = binding.et.text.toString().toInt()
        if (numero != null) {
            return numero
        } else Toast.makeText(context, "Digite algo", Toast.LENGTH_LONG).show()
        return 1234567890
    }

    private fun receberArgumento() {
        val argumento = PrimeiroFragmentArgs.fromBundle(requireArguments())
        binding.text.text = argumento.primeiroParametro
    }
}