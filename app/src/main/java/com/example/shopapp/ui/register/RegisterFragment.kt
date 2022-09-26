package com.example.shopapp.ui.register

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.shopapp.data.User
import com.example.shopapp.databinding.RegisterFragmentBinding
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: RegisterFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = binding.name.text.toString()
        val date = binding.date.text.toString()
        binding.singUpButton.setOnClickListener {
            registerUser()
        }
        binding.eyeImg.setOnClickListener {
            hidePassword()
        }
        binding.dateImg.setOnClickListener {
            showDatePickerDialog(it)
        }
    }

    private fun registerUser() {
        val email = binding.email.text.toString()
        val password = binding.password.text.toString()
        viewModel.registerUser(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                binding.loading.visibility = View.GONE
                if (task.isSuccessful) {
                    val user = task.result.user
                    Toast.makeText(
                        context, "Authentication success -  $user.",
                        Toast.LENGTH_SHORT
                    ).show()
                    viewModel.addNewUser(User("wsadffafea", "TEST"))
                    //FirebaseAuth.getInstance().signOut()
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                } else {
                    Toast.makeText(
                        context, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
    }

    private fun showDatePickerDialog(v: View) {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()

        datePicker.show(parentFragmentManager, "datapicker")
        datePicker.addOnPositiveButtonClickListener {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val date = sdf.format(it)
            binding.date.setText(date)
        }
    }

    private fun hidePassword() {
        val passwordField = binding.password
        if (passwordField.transformationMethod.equals(PasswordTransformationMethod.getInstance())) {
            passwordField.transformationMethod = HideReturnsTransformationMethod.getInstance();
        } else {
            passwordField.transformationMethod = PasswordTransformationMethod.getInstance();
        }
        passwordField.setSelection(passwordField.text.length);
    }


}