package com.kaleichyk.verifier.email

import com.kaleichyk.verifier.ValidateException
import java.util.regex.Pattern

class EmailValidatorImpl : EmailValidator {

    companion object {
        const val EMAIL_PATTERN = "^[A-Za-z](.*)([@])(.+)(\\.)(.+)"
    }

    override fun validate(value: String) {
        val pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher = pattern.matcher(value)
        if (!matcher.matches()) throw ValidateException("Invalid email")
    }
}