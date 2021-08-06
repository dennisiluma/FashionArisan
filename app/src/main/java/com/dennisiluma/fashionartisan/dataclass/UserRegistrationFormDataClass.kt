package com.dennisiluma.fashionartisan.dataclass

data class UserRegistrationFormDataClass(
    val firstName:String,
    val lastName:String,
    val phoneNumber:String,
    val gender:String,
    val accountCategory:String,
    val state:String,
    val email:String,
    val confirmPassword:String
)
