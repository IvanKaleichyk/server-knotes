package com.kaleichyk.service

import com.kaleichyk.model.EmailData

interface EmailService {

    fun sendEmail(email: EmailData)
}
