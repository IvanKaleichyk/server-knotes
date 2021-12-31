package com.kaleichyk.verifier.password

import com.kaleichyk.verifier.ValidateException
import java.util.regex.Pattern

class PasswordValidatorImpl : PasswordValidator {

    companion object {

        const val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
    }

    override fun validate(value: String) {
        val pattern = Pattern.compile(PASSWORD_PATTERN)
        val matcher = pattern.matcher(value)
        if (!matcher.matches()) throw ValidateException("Invalid password")
    }
}
