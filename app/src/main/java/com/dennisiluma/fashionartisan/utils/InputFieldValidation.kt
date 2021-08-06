package com.dennisiluma.fashionartisan.utils

import android.widget.EditText
import com.dennisiluma.fashionartisan.enumclass.AccountCategorySelectionEnumClass
import com.dennisiluma.fashionartisan.enumclass.GenderSelectionEnumClass
import com.dennisiluma.fashionartisan.enumclass.StateSelectionEnumClass
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

object InputFieldValidation {
    /*Function to validate Email*/
    fun validateEmail(email: String): Boolean {
        val pattern = "\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}".toRegex()
        return email.matches(pattern)
    }

    fun EditText.validatePhoneNumber(number: String): Boolean {
        val pattern: Pattern = Pattern.compile("^(0|234)((70)|([89][01]))[0-9]{8}\$")
        val matcher: Matcher = pattern.matcher(number)
        val matchFound = matcher.matches()
        return !(number.isEmpty() || !matchFound)
    }

    // Function to check password mismatch
    fun validatePasswordMatch(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword
    }

    /*Function to Validate Account Category Selection*/
    fun validateAccountCategorySelection(account_Category: String): Boolean {
        return when (account_Category.uppercase(Locale.ROOT)) {
            AccountCategorySelectionEnumClass.DESIGNER.name -> true
            AccountCategorySelectionEnumClass.USER.name -> true
            else -> false
        }
    }
    /*Function to Validate Gender Selection*/
    fun validateGenderSelection(gender_input: String): Boolean {
        return when (gender_input.uppercase(Locale.ROOT)) {
            GenderSelectionEnumClass.MALE.name -> true
            GenderSelectionEnumClass.FEMALE.name -> true
            else -> false
        }
    }



    fun validateName(name: String): Boolean {
        val namePattern: Pattern = Pattern.compile("([a-zA-Z]{2,})+")
        return namePattern.matcher(name).matches()
    }

    fun validateGender(gender: String): Boolean {
        return when (gender.toUpperCase(Locale.ROOT)) {
            "MALE" -> true
            "FEMALE" -> true
            else -> false
        }
    }
    /*Function to Validate State Selection*/
    fun validateStateSelection(gender_input: String): Boolean {
        return when (gender_input.uppercase(Locale.ROOT)) {
            StateSelectionEnumClass.ABUJA.name -> true
            StateSelectionEnumClass.LAGOS.name -> true
            else -> false
        }
    }
}