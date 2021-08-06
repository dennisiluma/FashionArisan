package com.dennisiluma.fashionartisan.starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.dennisiluma.fashionartisan.R
import com.dennisiluma.fashionartisan.databinding.FragmentSignupBinding
import com.dennisiluma.fashionartisan.dataclass.UserRegistrationFormDataClass
import com.dennisiluma.fashionartisan.utils.InputFieldValidation.validateAccountCategorySelection
import com.dennisiluma.fashionartisan.utils.InputFieldValidation.validateEmail
import com.dennisiluma.fashionartisan.utils.InputFieldValidation.validateGenderSelection
import com.dennisiluma.fashionartisan.utils.InputFieldValidation.validatePasswordMatch
import com.dennisiluma.fashionartisan.utils.InputFieldValidation.validatePhoneNumber
import com.dennisiluma.fashionartisan.utils.InputFieldValidation.validateStateSelection
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignupFragment : Fragment() {

    /* declear variables that will be used later */

    private lateinit var accountCategoryDropDown: AutoCompleteTextView
    private lateinit var genderCategoryDropdown:AutoCompleteTextView
    private lateinit var stateCategoryDropdown:AutoCompleteTextView

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the layer for this fragment
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        accountCategoryDropDown = binding.fragmentSignUpAccountCategoryTextView
        genderCategoryDropdown = binding.fragmentSignUpGenderTextView
        stateCategoryDropdown = binding.fragmentSignUpStateTextView

        binding.fragmentSignUpLoginTextView.setOnClickListener {
            findNavController().navigate(R.id.action_signup_to_login)
        }
        binding.fragmentSignUpSignupButton.setOnClickListener {
            val firstName = binding.fragmentSignUpFirstNameEditText.text.toString().trim()
            val lastName = binding.fragmentSignUpLastNameEditText.text.toString().trim()
            val email = binding.fragmentSignUpEmailEditText.text.toString().trim()
            val phoneNumber = binding.fragmentSignUpPhoneNumberEditText.text.toString().trim()
            val password = binding.fragmentSignUpPasswordEditText.text.toString().trim()
            val confirmPassword = binding.fragmentSignUpConfirmPasswordEditText.text.toString().trim()
            val category = accountCategoryDropDown.text.toString().trim()
            val gender = binding.fragmentSignUpGenderTextView.text.toString().trim()
            val state = binding.fragmentSignUpStateTextView.text.toString().trim()

            when {
                firstName.isEmpty() -> {
                    binding.fragmentSignUpFirstNameEditTextLayout.error =
                        getString(R.string.all_please_enter_first_name)
                    return@setOnClickListener
                }
                lastName.isEmpty() -> {
                    binding.fragmentSignUpFirstNameEditTextLayout.error =
                        getString(R.string.all_please_enter_first_name)
                    return@setOnClickListener
                }
                state.isEmpty() ->{
                    binding.fragmentSignUpStateTextLayout.error =
                        getString(R.string.select_state)
                    return@setOnClickListener
                }
                !validateAccountCategorySelection(category) -> {
                    binding.fragmentSignUpAccountCategoryTextLayout.error =
                        getString(R.string.all_select_account_type)
                    binding.fragmentSignUpAccountCategoryTextLayout.errorIconDrawable = null
                    return@setOnClickListener
                }
                !validateGenderSelection(gender) -> {
                    binding.fragmentSignUpGenderTextLayout.error =
                        getString(R.string.all_select_gender)
                    binding.fragmentSignUpGenderTextLayout.errorIconDrawable = null
                    return@setOnClickListener
                }
                !validateStateSelection(state) ->{
                    binding.fragmentSignUpStateTextLayout.error =
                        getString(R.string.select_state)
                    binding.fragmentSignUpStateTextLayout.errorIconDrawable = null
                    return@setOnClickListener
                }

                email.isEmpty() -> {
                    binding.fragmentSignUpEmailEditTextLayout.error =
                        getString(R.string.all_email_cant_be_empty)
                    return@setOnClickListener
                }
                !binding.fragmentSignUpPhoneNumberEditText.validatePhoneNumber(phoneNumber) -> {
                    binding.fragmentSignUpPhoneNumberEditTextLayout.error =
                        getString(R.string.invalid_phone_number)
                    return@setOnClickListener
                }
                phoneNumber.isEmpty() -> {
                    binding.fragmentSignUpPhoneNumberEditTextLayout.error =
                        getString(R.string.all_phone_number_is_required)
                    return@setOnClickListener
                }
                !validateEmail(email) -> {
                    binding.fragmentSignUpEmailEditTextLayout.error =
                        getString(R.string.all_invalid_email)
                    return@setOnClickListener
                }
                password.isEmpty() -> {
                    binding.fragmentSignUpPasswordEditTextLayout.error =
                        getString(R.string.all_password_is_required)
                    binding.fragmentSignUpPasswordEditTextLayout.errorIconDrawable = null
                    return@setOnClickListener
                }
                confirmPassword.isEmpty() -> {
                    binding.fragmentSignUpConfirmPasswordEditTextLayout.error =
                        getString(R.string.all_password_is_required)
                    binding.fragmentSignUpConfirmPasswordEditTextLayout.errorIconDrawable =
                        null
                    return@setOnClickListener
                }
                !validatePasswordMatch(password, confirmPassword) -> {
                    binding.fragmentSignUpConfirmPasswordEditTextLayout.error =
                        getString(R.string.all_password_mismatch)
                    binding.fragmentSignUpConfirmPasswordEditTextLayout.errorIconDrawable =
                        null
                    return@setOnClickListener
                }
                else -> {
                    if (validateSignUpFieldsOnTextChange()) {
                        val newRegisteredUser = UserRegistrationFormDataClass(
                            firstName=firstName,
                            lastName=lastName,
                            phoneNumber=phoneNumber,
                            gender=gender,
                            accountCategory=category,
                            state=state,
                            email=email,
                            confirmPassword=confirmPassword
                        )
                        Toast.makeText(requireContext(), "Inputs are valid", Toast.LENGTH_LONG).show()
//                        authenticationViewModel.registerUser(newRegisteredUser)
                    } else {
                        return@setOnClickListener
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        /*Set up Account Category Views Dropdown Items*/
        val accountCategories = resources.getStringArray(R.array.account_category)
        val accountCategoriesArrayAdapter = ArrayAdapter(
            requireContext(),
            R.layout.account_category_dropdown_item,
            accountCategories
        )
        accountCategoryDropDown.setAdapter(accountCategoriesArrayAdapter)

        /*Set up Gender Selection Dropdown Items*/
        val genderCategories = resources.getStringArray(R.array.gender_item)
        val genderArrayAdapter = ArrayAdapter(requireContext(),
        R.layout.account_category_dropdown_item,
            genderCategories)
        genderCategoryDropdown.setAdapter(genderArrayAdapter)


        /*Set up State Selection Dropdown Items*/
        val stateCategories = resources.getStringArray(R.array.state_item)
        val stateArrayAdapter = ArrayAdapter(requireContext(),
            R.layout.account_category_dropdown_item,
            stateCategories)
        stateCategoryDropdown.setAdapter(stateArrayAdapter)


        /*Method to Validate All Sign Up Fields*/
        validateSignUpFieldsOnTextChange()
    }

    /*Method to Validate All Sign Up Fields*/
    private fun validateSignUpFieldsOnTextChange(): Boolean {
        var isValidated = true

        binding.fragmentSignUpFirstNameEditText.doOnTextChanged { _, _, _, _ ->
            when {
                binding.fragmentSignUpFirstNameEditText.text.toString().trim().isEmpty() -> {
                    binding.fragmentSignUpFirstNameEditTextLayout.error =
                        getString(R.string.all_please_enter_first_name)
                    isValidated = false
                }
                else -> {
                    binding.fragmentSignUpFirstNameEditTextLayout.error = null
                    isValidated = true
                }
            }
        }


        binding.fragmentSignUpEmailEditText.doOnTextChanged { _, _, _, _ ->
            when {
                binding.fragmentSignUpEmailEditText.text.toString().trim().isEmpty() -> {
                    binding.fragmentSignUpEmailEditTextLayout.error =
                        getString(R.string.all_email_cant_be_empty)
                    isValidated = false
                }
                !validateEmail(binding.fragmentSignUpEmailEditText.text.toString().trim()) -> {
                    binding.fragmentSignUpEmailEditTextLayout.error =
                        getString(R.string.all_invalid_email)
                    isValidated = false
                }
                else -> {
                    binding.fragmentSignUpEmailEditTextLayout.error = null
                    isValidated = true
                }
            }
        }

        binding.fragmentSignUpPhoneNumberEditText.doOnTextChanged { _, _, _, _ ->
            when {
                binding.fragmentSignUpPhoneNumberEditText.text.toString().trim().isEmpty() -> {
                    binding.fragmentSignUpPhoneNumberEditTextLayout.error =
                        getString(R.string.all_password_is_required)
                    binding.fragmentSignUpPhoneNumberEditTextLayout.errorIconDrawable = null
                    isValidated = false
                }
                else -> {
                    binding.fragmentSignUpPhoneNumberEditTextLayout.error = null
                    isValidated = true
                }
            }
        }

        binding.fragmentSignUpConfirmPasswordEditText.doOnTextChanged { _, _, _, _ ->
            when {
                binding.fragmentSignUpConfirmPasswordEditText.text.toString().trim().isEmpty() -> {
                    binding.fragmentSignUpConfirmPasswordEditTextLayout.error =
                        getString(R.string.all_password_is_required)
                    binding.fragmentSignUpConfirmPasswordEditTextLayout.errorIconDrawable =
                        null
                    isValidated = false
                }
                !validatePasswordMatch(
                    binding.fragmentSignUpPasswordEditText.text.toString().trim(),
                    binding.fragmentSignUpConfirmPasswordEditText.text.toString().trim()
                ) -> {
                    binding.fragmentSignUpConfirmPasswordEditTextLayout.error =
                        getString(R.string.all_password_mismatch)
                    binding.fragmentSignUpConfirmPasswordEditTextLayout.errorIconDrawable =
                        null
                    isValidated = false
                }
                else -> {
                    binding.fragmentSignUpConfirmPasswordEditTextLayout.error = null
                    isValidated = true
                }
            }
        }

        accountCategoryDropDown.doOnTextChanged { _, _, _, _ ->
            if (!validateAccountCategorySelection(binding.fragmentSignUpAccountCategoryTextView.text.toString())) {
                binding.fragmentSignUpAccountCategoryTextLayout.error =
                    getString(R.string.all_select_account_type)
                binding.fragmentSignUpAccountCategoryTextLayout.errorIconDrawable = null
                isValidated = false
            } else {
                binding.fragmentSignUpAccountCategoryTextLayout.error = null
                isValidated = true
            }
        }
        genderCategoryDropdown.doOnTextChanged { _, _, _, _ ->
            if (!validateGenderSelection(binding.fragmentSignUpGenderTextView.text.toString())) {
                binding.fragmentSignUpAccountCategoryTextLayout.error =
                    getString(R.string.all_select_gender)
                binding.fragmentSignUpGenderTextLayout.errorIconDrawable = null
                isValidated = false
            } else {
                binding.fragmentSignUpGenderTextLayout.error = null
                isValidated = true
            }
        }

        return isValidated
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}