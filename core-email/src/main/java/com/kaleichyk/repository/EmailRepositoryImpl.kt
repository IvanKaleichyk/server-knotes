package com.kaleichyk.repository

import com.kaleichyk.model.EmailData
import org.apache.commons.mail.DefaultAuthenticator
import org.apache.commons.mail.SimpleEmail

class EmailRepositoryImpl(
    private val hostName: String,
    private val smtpPort: Int,
    private val account: String,
    private val username: String,
    private val password: String,
) : EmailRepository {

    private val useSSL = true

    override fun sendEmail(email: EmailData) {
        SimpleEmail().apply {
            hostName = this@EmailRepositoryImpl.hostName
            setSmtpPort(this@EmailRepositoryImpl.smtpPort)
            setFrom(account)
            setAuthenticator(DefaultAuthenticator(username, password))
            isSSLOnConnect = useSSL
            subject = email.title
            setMsg(email.body)
            addTo(email.receiver)
        }.send()
    }
}