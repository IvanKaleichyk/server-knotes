package com.kaleichyk.table

import java.util.*
import org.jetbrains.exposed.dao.id.LongIdTable

object UserDetailsTable : LongIdTable() {

    private const val ABOUT_LENGTH = 500
    private const val NAME_LENGTH = 50
    private const val EMAIL_LENGTH = 100
    private const val PASSWORD_LENGTH = 100
    private const val IMAGE_LENGTH = 300

    val name = varchar("name", NAME_LENGTH).uniqueIndex()
    val email = varchar("email", EMAIL_LENGTH).uniqueIndex()
    val password = varchar("password", PASSWORD_LENGTH).default("test")
    val about = varchar("about", ABOUT_LENGTH).nullable()
    val image = varchar("image", IMAGE_LENGTH).nullable()

    val lastUpdated = long("last_updates").default(Date().time)

    // for analytics
    val created = long("created").default(Date().time)
}
