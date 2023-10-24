package com.example.fragment_pertemuan8

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragment_pertemuan8.databinding.FragmentRegisterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
        btnToHome.setOnClickListener {
            if (isInputValid()) {
                val intent = Intent(activity, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "Input tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
            }
        }
    }

    private fun isInputValid(): Boolean {
        val username = binding.registerUsername.text.toString()
        val email = binding.registerEmail.text.toString()
        val phone = binding.registerPhone.text.toString()
        val password = binding.registerPassword.text.toString()

        if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            return false
        }

        return true
    }
}
