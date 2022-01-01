package com.kaleichyk.repository

import com.kaleichyk.model.EmailData

interface EmailRepository {

    fun sendEmail(email: EmailData)
}