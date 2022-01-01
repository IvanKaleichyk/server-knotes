package com.kaleichyk.service

import com.kaleichyk.model.EmailData
import com.kaleichyk.repository.EmailRepository

class EmailServiceImpl(
    private val repository: EmailRepository
) : EmailService {

    override fun sendEmail(email: EmailData) = repository.sendEmail(email)
}